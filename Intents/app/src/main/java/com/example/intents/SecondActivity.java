package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intents.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    public ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.tvName.setText(String.format("Hi there! \n %s", getIntent().getExtras().getString("name")));
        Person person = (Person) getIntent().getExtras().getSerializable("EXTRA_PERSON");
        binding.tvName.setText(person.name);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}