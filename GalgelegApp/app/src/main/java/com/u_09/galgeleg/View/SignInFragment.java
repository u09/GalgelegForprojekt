package com.u_09.galgeleg.View;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.u_09.galgeleg.Model.GalgelogikFunc;
import com.u_09.galgeleg.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Tolga on 19-04-2017.
 */

public class SignInFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private TextView mTvUsername, mTvPassword;
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin;

    private GalgelogikFunc mGame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.sign_in_fragment, container, false);

        mGame = new GalgelogikFunc();

        mTvUsername = (TextView) mView.findViewById(R.id.tv_username);
        mEtUsername = (EditText) mView.findViewById(R.id.et_username);
        mTvPassword = (TextView) mView.findViewById(R.id.tv_password);
        mEtPassword = (EditText) mView.findViewById(R.id.et_password);
        mBtnLogin = (Button) mView.findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnLogin) {
            try {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                JSONObject user = mGame.hentBruger(username, password);
                boolean error = user.getBoolean("error");
                Log.d("XXXX", "" + error);
                if (!error) {
                    Snackbar.make(mView, "Du er logget ind", Snackbar.LENGTH_SHORT).show();
                    mTvUsername.setVisibility(View.GONE);
                    mEtUsername.setVisibility(View.GONE);
                    mTvPassword.setVisibility(View.GONE);
                    mEtPassword.setVisibility(View.GONE);
                    mBtnLogin.setVisibility(View.GONE);
                    TextView tvSpiller = (TextView) getActivity().findViewById(R.id.tv_spiller);
                    String fullname = user.getString("fullname");
                    tvSpiller.setText("Spiller: " + fullname + " " + username);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("fullname", fullname);
                    MainMenuFragment mainMenuFragment = new MainMenuFragment();
                    mainMenuFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in_pop, R.anim.slide_out_pop).replace(R.id.fragment_content, mainMenuFragment).addToBackStack(null).commit();
                } else {
                    Snackbar.make(mView, "Login mislykket", Snackbar.LENGTH_SHORT).show();
                    mEtUsername.setText("");
                    mEtPassword.setText("");
                    mEtUsername.requestFocus();
                }
            } catch (InterruptedException | ExecutionException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
