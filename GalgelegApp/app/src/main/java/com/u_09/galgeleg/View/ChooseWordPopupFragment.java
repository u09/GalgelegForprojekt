package com.u_09.galgeleg.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.u_09.galgeleg.R;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Umais on 15/01/2017.
 */

public class ChooseWordPopupFragment extends Fragment implements AdapterView.OnItemClickListener {

    private GallowGameFragment mGallowGameFragment;
    private ArrayList mMuligeOrdArray;
    private View mView;
    private ListView mLvWords;
    private ArrayAdapter mLvWordsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.choose_word_popup, container, false);

        mGallowGameFragment = new GallowGameFragment();

        mLvWords = (ListView) mView.findViewById(R.id.lv_words);

        mLvWords.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mLvWords.setOnItemClickListener(this);

        try {
            hentMuligeOrdArray();
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }

        return mView;
    }

    private void hentMuligeOrdArray() throws InterruptedException, ExecutionException, JSONException {
        mMuligeOrdArray = ((GameActivity)getActivity()).getMuligeOrdFromActivity();
        mLvWordsAdapter = new ArrayAdapter<>(getContext(), R.layout.choose_word_list_element, mMuligeOrdArray);
        mLvWords.setAdapter(mLvWordsAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        CheckedTextView item = (CheckedTextView) view;
        item.setCheckMarkDrawable(R.drawable.ic_check_24dp);
        item.setChecked(true);
        String ordet = item.getText().toString();
        Log.d("WORD: ", i + " - " + item.getText().toString());
        try {
            ((GameActivity)getActivity()).setOrdetFromActivity(i);
            ((GameActivity)getActivity()).setSynligtOrdFromActivity();
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in_pop, R.anim.slide_out_pop)
                .replace(R.id.fragment_content, mGallowGameFragment).addToBackStack(null)
                .commit();
    }
}
