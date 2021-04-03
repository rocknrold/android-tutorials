package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.spinner.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Example of resource spinnerAdapter is on the string resource


        //Example create a spinner with ArrayAdapter
        String[] customs = new String[] {"First","Second","Third", "Fourth"};
        LinkedList<String> spCustoms = new LinkedList<String>(Arrays.asList(customs));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spCustoms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spMonths.setAdapter(adapter);

        binding.spMonths.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"You've have selected "+ parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                binding.tvMonth.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}