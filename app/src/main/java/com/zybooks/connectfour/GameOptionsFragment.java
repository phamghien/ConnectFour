package com.zybooks.connectfour;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GameOptionsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_options, container, false);

        // Extract level ID from SharedPreferences
        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        int levelId = sharedPref.getInt("onLevelSelected", R.string.easyMode);

        // Select radio button matching color ID
        int radioId = R.id.radio_easy;
        if (levelId == R.string.mediumMode) {
            radioId = R.id.radio_medium;
        } else if (levelId == R.string.hardMode) {
            radioId = R.id.radio_hard;
        }

        RadioButton radio = rootView.findViewById(radioId);
        radio.setChecked(true);

        // Add click callback to all radio buttons
        RadioGroup levelRadioGroup = rootView.findViewById(R.id.difficulty_radio_group);
        for (int i = 0; i < levelRadioGroup.getChildCount(); i++) {
            radio = (RadioButton) levelRadioGroup.getChildAt(i);
            radio.setOnClickListener(this::onLevelSelected);
        }

        return rootView;
    }


    public void onLevelSelected(View view) {
        int levelId = R.id.radio_easy;

       if (view.getId() == R.id.radio_medium) {
            levelId = R.id.radio_medium;
        } else if (view.getId() == R.id.radio_hard) {
            levelId = R.id.radio_hard;
        }


        // Save selected level  ID in SharedPreferences
        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("onLevelSelected", levelId);
        editor.apply();
    }

}