package com.example.menutoolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Fragment {

    private SharedPreferences.Editor edit;
    private SharedPreferences sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button btnSaveSettings = (Button) view.findViewById(R.id.btnSaveSettings);
        CheckBox cbxColorMode = (CheckBox) view.findViewById(R.id.cbxColorMode);
        RadioGroup rgSpeed = view.findViewById(R.id.rgSpeed);
        int selectedSpeed = rgSpeed.getCheckedRadioButtonId();
        RadioButton speed = (RadioButton) view.findViewById(selectedSpeed);

        sharedPref = getContext().getSharedPreferences("mySettings", Context.MODE_PRIVATE);
        edit = sharedPref.edit();

        cbxColorMode.setChecked(sharedPref.getString("THEME_COLOR", "true").equals("true"));

        cbxColorMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(cbxColorMode.isChecked()){
                edit.putString("THEME_COLOR", "true");
            }else {
                edit.putString("THEME_COLOR", "false");
            }
        });

        String speedRg = sharedPref.getString("SPEED", null);
        rgSpeed.clearCheck();
        if(speedRg.equals("Slow")){
            rgSpeed.check(R.id.rbtnSlow);
        } else if(speedRg.equals("Medium")) {
            rgSpeed.check(R.id.rbtnMedium);
        } else {
            rgSpeed.check(R.id.rbtnFast);
        }

        rgSpeed.setOnCheckedChangeListener((group, checkedId) -> {
            switch (group.findViewById(checkedId).getId()){
                case R.id.rbtnSlow:
                    edit.putString("SPEED", "Slow");
                    break;
                case R.id.rbtnMedium:
                    edit.putString("SPEED", "Medium");
                    break;
                case R.id.rbtnFast:
                    edit.putString("SPEED", "Fast");
                    break;
            }
        });

        btnSaveSettings.setOnClickListener(v -> {
            edit.apply();
            assert getFragmentManager() != null;
            getActivity().getSupportFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentByTag("settings")).commit();
            Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();

        });

//        edit.commit();
        return view;
    }
}