package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.example.intents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = binding.etName.getText().toString();
                
                Person myPerson = new Person(myName);

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                intent.putExtra("name",myName);
                intent.putExtra("EXTRA_PERSON", myPerson);

                startActivity(intent);
            }
        });
    }
}