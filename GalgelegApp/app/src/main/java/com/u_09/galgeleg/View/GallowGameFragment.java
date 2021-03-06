package com.u_09.galgeleg.View;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.u_09.galgeleg.Model.GalgelogikCalls;
import com.u_09.galgeleg.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class GallowGameFragment extends Fragment implements View.OnClickListener, View.OnKeyListener {

    private SharedPreferences mPrefs;

    private GalgelogikCalls mGame;
    private ArrayList<Integer> mImages = new ArrayList<>();
    private String mGuess;
    private View mView;
    private ImageSwitcher mImageSwitcher;
    private TextView mTvTitle, mTvTheWordIs, mTvTheWord, mTvGuessedLetters, mTvWrongLetters;
    private EditText mEtLetter;
    private Button mBtnGuess, mBtnNewWord;
    public ProgressBar mProgressBar1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.gallow_game_fragment, container, false);

        mTvTitle = (TextView) mView.findViewById(R.id.textview_title);
        mImageSwitcher = (ImageSwitcher) mView.findViewById(R.id.imageSwitcher);
        mTvTheWordIs = (TextView) mView.findViewById(R.id.textview_the_word_is);
        mTvTheWord = (TextView) mView.findViewById(R.id.textview_the_word);
        mTvGuessedLetters = (TextView) mView.findViewById(R.id.textview_guessed_letters);
        mTvWrongLetters = (TextView) mView.findViewById(R.id.textview_wrong_letters);
        mEtLetter = (EditText) mView.findViewById(R.id.editText_letter);
        mBtnGuess = (Button) mView.findViewById(R.id.button_guess);
        mBtnNewWord = (Button) mView.findViewById(R.id.button_new_word);
        mProgressBar1 = (ProgressBar) mView.findViewById(R.id.pb_game);

        Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
        mImageSwitcher.setInAnimation(in);
        mImageSwitcher.setOutAnimation(out);

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        mBtnGuess.setOnClickListener(this);
        mBtnNewWord.setOnClickListener(this);
        mEtLetter.setOnKeyListener(this);

        if (savedInstanceState == null) {
            mPrefs = this.getActivity().getSharedPreferences("highscorePrefs", Context.MODE_PRIVATE);
            refillImageArray();
            mGame = ((GameActivity) getActivity()).getmGalgelogikCalls();
            // Snackbar.make(mView, "Henter ord...", Snackbar.LENGTH_SHORT).show();
            try {
                newGame();
            } catch (InterruptedException | ExecutionException | JSONException e) {
                e.printStackTrace();
            }
            mEtLetter.requestFocus();
        }

        return mView;
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnGuess) {
            mGuess = mEtLetter.getText().toString();
            try {
                String guessInfo;
                JSONObject returnObj = mGame.gaet(mGuess, User.sid, 0);
                Log.d("FORRIGEFORKERTE", "" + Integer.parseInt(mTvWrongLetters.getText().toString().split("/")[0]));
                Log.d("ANTALFORKERTE", "" + returnObj.getInt("antalForkerteBogstaver"));
                int forrigeForkerte = Integer.parseInt(mTvWrongLetters.getText().toString().split("/")[0]);
                if (mTvGuessedLetters.getText().toString().contains(mGuess))
                    guessInfo = "Allerede brugt!";
                else if (forrigeForkerte == returnObj.getInt("antalForkerteBogstaver"))
                    guessInfo = "Super! Gættet var korrekt!";
                else guessInfo = "Øv! Forkert gæt!";
                updateUIOnGuess(returnObj);
                Snackbar.make(mView, guessInfo, Snackbar.LENGTH_SHORT).show();
            } catch (InterruptedException | ExecutionException | JSONException e) {
                e.printStackTrace();
            }
        } else if (v == mBtnNewWord) {
            try {
                newGame();
            } catch (InterruptedException | ExecutionException | JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            mBtnGuess.callOnClick();
        }
        return false;
    }

    public void updateUIOnGuess(JSONObject returnObj) throws InterruptedException, ExecutionException, JSONException {
        String ordet = returnObj.getString("ordet");
        String synligtOrd = returnObj.getString("synligtOrd");
        final int antalForkerteBogstaver = returnObj.getInt("antalForkerteBogstaver");
        JSONArray brugteBogstaver = returnObj.getJSONArray("brugteBogstaver");
        mEtLetter.setText("");
        mEtLetter.requestFocus();
        mTvTheWord.setText(synligtOrd);
        mTvGuessedLetters.setText(brugteBogstaver.toString());
        mTvWrongLetters.setText(antalForkerteBogstaver + "/7");

        if (antalForkerteBogstaver != 0)
            mImageSwitcher.setImageResource(mImages.get(antalForkerteBogstaver - 1));

        if (antalForkerteBogstaver == 7 || !synligtOrd.contains("*")) {
            String title;
            if (!synligtOrd.contains("*")) {
                title = "Tillykke! Du har vundet spillet!";
                mTvTitle.setTextColor(getResources().getColor(R.color.green));
                mImageSwitcher.setImageResource(R.drawable.vundet);
            } else {
                title = "Øv! Du har tabt spillet!";
                mTvTitle.setTextColor(getResources().getColor(R.color.red));
                mTvTheWordIs.setText(R.string.ordet_var);
                mTvTheWord.setText(ordet);
            }

            mTvTitle.setText(title);
            mTvTitle.setVisibility(View.VISIBLE);
        }
    }

    public void newGame() throws InterruptedException, ExecutionException, JSONException {
        mImageSwitcher.setImageResource(R.drawable.galge);
        refillImageArray();
        mTvTitle.setVisibility(View.INVISIBLE);
        mTvTitle.setText("");
        mTvTheWordIs.setText(R.string.ordet_er);
        mTvTheWord.setText(mGame.nulstil(User.sid).getString("synligtOrd"));

        mGame.getBrugteBogstaver(User.sid).clear();

        mTvGuessedLetters.setText("[]");
        mTvWrongLetters.setText("0/7");
        mEtLetter.setText("");
    }

    public void refillImageArray() {

        mImages.clear();
        mImages.trimToSize();
        mImages.add(R.drawable.forkert1);
        mImages.add(R.drawable.forkert2);
        mImages.add(R.drawable.forkert3);
        mImages.add(R.drawable.forkert4);
        mImages.add(R.drawable.forkert5);
        mImages.add(R.drawable.forkert6);
        mImages.add(R.drawable.tabt);
    }
}
