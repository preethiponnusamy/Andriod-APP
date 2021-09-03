package com.example.befit_caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Start_Page extends AppCompatActivity {

    int selector;
    TextView display;
    // List of random quotes
    ArrayList<String> listOfRandomQuotes;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);
        display = findViewById(R.id.TextView);
        listOfRandomQuotes = new ArrayList<String>();

        listOfRandomQuotes.add(" “CAME FROM A PLANT, EAT IT; WAS MADE IN A PLANT, DON'T.” – MICHAEL POLLAN");
        listOfRandomQuotes.add("EVERY TIME U EAT OR DRINK,YOU ARE EITHER FEEDING DISEASE OR FIGHTING IT");
        listOfRandomQuotes.add("ENJOY THE JOURNEY AS U STRIVE FOR WELLNESS");
        listOfRandomQuotes.add("SOMEONE HAS TO STAND UP AND SAY ANSWER ISN'T ANOTHER PILL.THE ANSWER IS SPINACH");
        listOfRandomQuotes.add("“LET FOOD BE THY MEDICINE, THY MEDICINE SHALL BE THY FOOD.” – HIPPOCRATES");
        listOfRandomQuotes.add("“TO KEEP THE BODY IN GOOD HEALTH IS A DUTY, OTHERWISE" +
                " WE SHALL NOT BE ABLE TO KEEP OUR MIND STRONG AND CLEAR.” – BUDDHA");
        listOfRandomQuotes.add("“THE DOCTOR OF THE FUTURE WILL NO LONGER TREAT THE HUMAN FRAME WITH DRUGS," +
                " BUT RATHER WILL CURE AND PREVENT DISEASE WITH NUTRITION.” – THOMAS EDISON");
        listOfRandomQuotes.add("“SORRY, THERE’S NO MAGIC BULLET. YOU GOTTA EAT HEALTHY AND LIVE HEALTHY TO BE HEALTHY" +
                " AND LOOK HEALTHY. END OF STORY.” – MORGAN SPURLOCK");
        listOfRandomQuotes.add(" “WHEN DIET IS WRONG, MEDICINE IS OF NO USE. WHEN DIET IS CORRECT, MEDICINE IS OF NO NEED.”");
        listOfRandomQuotes.add("“IT IS HEALTH THAT IS REAL WEALTH AND NOT PIECES OF GOLD AND SILVER.” – MAHATMA GANDHI");

        Random randomNumber = new Random();
        selector = randomNumber.nextInt(10);
        display.setText(listOfRandomQuotes.get(selector));

    }

    public void OnLoginClick(View view) {
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);

    }
    public void OnSignupClick(View view){
        Intent i = new Intent(getApplicationContext(), Signup.class);
        startActivity(i);

    }
}