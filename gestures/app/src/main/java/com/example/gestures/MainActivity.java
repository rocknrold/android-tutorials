package com.example.gestures;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GestureDetectorCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private Button myButton;
    private TextView myText;
    private GestureDetectorCompat gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.clickme);
        myText = findViewById(R.id.texttochange);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setText("I got tapped!");
            }
        });

        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        myText.setText("on single tap confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        myText.setText("on double tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        myText.setText("on double tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        myText.setText("on down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        myText.setText("on show press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        myText.setText("on single tap up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        myText.setText("on scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        myText.setText("on long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        myText.setText("on fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}