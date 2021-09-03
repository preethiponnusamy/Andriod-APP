package com.example.befit_caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BMI extends AppCompatActivity {
    int selector;
    TextView display;
    ArrayList<String> listOfRandomQuotes;
    EditText height;
    EditText weight;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        display = findViewById(R.id.textView);
        listOfRandomQuotes = new ArrayList<String>();
        listOfRandomQuotes.add("Dieting is the only game where you win when you lose!");
        listOfRandomQuotes.add("Dear Stomach You Are Bored Not Hungry .So SHUT UP");
        listOfRandomQuotes.add("If u take care of your body it will take care of you");
        listOfRandomQuotes.add(" Food, Like Your Money, Should Be Working For You");
        listOfRandomQuotes.add(" It’s Not A Diet, It’s A Lifestyle Change");
        listOfRandomQuotes.add("Nothing Tastes As Good As Being Thin Feels");
        listOfRandomQuotes.add("The groundwork of all happiness is health.");
        listOfRandomQuotes.add("Don’t work out because you hate your body — work out because you love it.");
        listOfRandomQuotes.add("Exercise should be regarded as a tribute to the heart.");
        listOfRandomQuotes.add("I am a better person when I have less on my plate.");
        Random randomNumber = new Random();
        selector = randomNumber.nextInt(10);
        display.setText(listOfRandomQuotes.get(selector));
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel =  "very_severely_underweight";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "severely_underweight";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel ="normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "overweight";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "obese_class_i";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "obese_class_ii";
        } else {
            bmiLabel ="obese_class_iii";
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}