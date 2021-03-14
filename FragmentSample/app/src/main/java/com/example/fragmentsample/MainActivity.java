package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button fragment1;
    public Button fragment2;
    private static final String COMMON_TAG = "StateIn";
    public static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();
    public static final String TAG = COMMON_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();
        fragment1 = (Button)findViewById(R.id.btnFirstFragment);
        fragment2 = (Button)findViewById(R.id.btnSecondFragment);

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentation, firstFragment).commit();

        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentation, firstFragment).addToBackStack("firstFragment").commit();
            }
        });

        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentation, secondFragment).addToBackStack("secondFragment").commit();
            }
        });

        Log.i(TAG, ACTIVITY_NAME+" is onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, ACTIVITY_NAME+" is onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onStart();
        Log.i(TAG, ACTIVITY_NAME+" is onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, ACTIVITY_NAME+" onPause");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, ACTIVITY_NAME+" is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, ACTIVITY_NAME+" is onDestroy");
    }
}