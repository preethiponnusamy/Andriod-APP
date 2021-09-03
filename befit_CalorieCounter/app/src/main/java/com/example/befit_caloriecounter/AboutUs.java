package com.example.befit_caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    TextView tv;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        tv = findViewById(R.id.TextView);
        tv.setText("In this busy day to day life , it is very difficult to cope up with natural and healthy diet." +
                " It needs lot of time and patience , but here we provide accurate calorie values for thousands of food" +
                " items with in seconds of your search . Create and mix your own food." +
                " This app is user friendly and aslo free in cost. your identity and information will be safe with us. ");
    }
}