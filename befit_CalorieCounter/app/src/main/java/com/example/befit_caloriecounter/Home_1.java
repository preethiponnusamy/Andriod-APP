package com.example.befit_caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home_1 extends AppCompatActivity implements View.OnClickListener {
    TextView textView,bmi,tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_1);
        textView = findViewById(R.id.textView);
        Bundle b=getIntent().getExtras();
        String name1=b.getString("name");
        String ph = b.getString("ph");
        textView.setText(ph);
        bmi = findViewById(R.id.bmi);
        bmi.setOnClickListener(this);
        tv1 = findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        tv2 = findViewById(R.id.tv2);
        tv2.setOnClickListener(this);

    }
    public void OnSettingsClick(View view){
        Intent i = new Intent(this, settings.class);
        i.putExtra("ph",textView.getText() );
        startActivity(i);
    }

    @Override
    public void onClick(View view) {

        if(view == bmi){
            Intent i = new Intent(this, BMI.class);
            startActivity(i);
        }
        if(view == tv1){
            Intent i = new Intent(this, calories.class);
            startActivity(i);
        }

        if(view == tv2){
            Intent i = new Intent(this,calories_2.class);
            startActivity(i);
        }

    }


}