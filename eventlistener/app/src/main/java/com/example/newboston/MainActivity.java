package com.example.newboston;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.button);

        myButton.setOnClickListener(
                v -> {
                    TextView myText = findViewById(R.id.textView);
                    myText.setText("Hello im clicked!");
                }
        );

        myButton.setOnLongClickListener(
                v -> {
                    TextView myText = findViewById(R.id.textView);
                    myText.setText("Hello im long clicked!");
                    return false;
                }
        );

    }
}