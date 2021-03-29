package com.example.checkboxandradiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
//        RadioButton rbtnMeat = findViewById(R.id.rBtnMeat);
//        RadioButton rbtnPork = findViewById(R.id.rBtnPork);
//        RadioButton rbtnChicken = findViewById(R.id.rBtnChicken);

        Button btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(this::onClick);

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton radioButton = (RadioButton)findViewById(checkedId);
//                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public void onClick(View view){
        CheckBox cbxCheese  = findViewById(R.id.cbxCheese);
        CheckBox cbxTomato = findViewById(R.id.cbxTomato);
        CheckBox cbxLetuce = findViewById(R.id.cbxLetuce);
        TextView tvOrders = findViewById(R.id.tvOrders);

        String orderDetails = "You have ordered\n";
        int checkedRadioButton = radioGroup.getCheckedRadioButtonId();
        Log.d("choosenLaman", String.valueOf(checkedRadioButton));

        RadioButton choosenOne = (RadioButton)findViewById(checkedRadioButton);

        orderDetails += choosenOne.getText() + " with \n";

        if(cbxCheese.isChecked()){
            orderDetails += cbxCheese.getText() + "\n";
        };

        if(cbxTomato.isChecked()){
            orderDetails += cbxTomato.getText() + "\n";
        };

        if(cbxLetuce.isChecked()){
            orderDetails += cbxLetuce.getText() + "\n";
        };

        tvOrders.setText(orderDetails);
    }
}