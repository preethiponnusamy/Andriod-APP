package com.example.befit_caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity implements View.OnClickListener {
    TextView tv,tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Bundle b=getIntent().getExtras();
        String ph=b.getString("ph");
        tv = findViewById(R.id.tv);
        tv.setText(ph);
        tv1 = findViewById(R.id.profile);
        tv2 = findViewById(R.id.about);
        tv3 = findViewById(R.id.Contact);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv2.setOnClickListener(this);

    }

    public void OnLogoutClick(View view) {
        Intent i = new Intent(this, Start_Page.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {

        if(view == tv1){

            Intent i = new Intent(this, Profile.class);
            i.putExtra("ph",tv.getText() );
            startActivity(i);

        }
        if(view == tv2){
            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);

        }

    }
}