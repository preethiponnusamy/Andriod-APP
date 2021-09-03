package com.example.befit_caloriecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText name,uname,pass,age,mail,phone;
    SQLiteDatabase db;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        age = findViewById(R.id.age);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR ,uname VARCHAR,password VARCHAR," +
                " number VARCHAR unique ,email VARCHAR ,age INTEGER);");
        reg = findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(name.getText().toString().isEmpty() || uname.getText().toString().isEmpty() ||
            pass.getText().toString().isEmpty() || age.getText().toString().isEmpty() ||
            mail.getText().toString().isEmpty() || phone.getText().toString().isEmpty()){
                showMessage("ERROR","please do Enter all the details");
            }

        else{
            Cursor c = db.rawQuery("SELECT * FROM users WHERE number ='" + phone.getText() + "'", null);

            if (c != null && c.moveToFirst()) {
                showMessage("Error","Phone Number Already Exists \n Please try registering with another ");
            }

            else{
                if((pass.getText().toString().length()) >= 8){
                    if(mail.getText().toString().contains("@") && mail.getText().toString().contains(".")){
            db.execSQL("INSERT INTO users VALUES('" + name.getText() + "','" + uname.getText() +
                    "','" + pass.getText() + "', '"+ phone.getText() + "','" + mail.getText() + "'," +
                    "'" + age.getText() + "');");
            showMessage("Registered", "Welcome to Family.. \n Please Login to Continue..");
            clearText();
                }
                else{
                showMessage("ERROR","The Mail is not in proper format");
                     }
                }
               
            else{
            showMessage("ERROR","YOUR Password doesnot have enough number of characters. The min is 8..");
                 }
            }
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText(){
        name.setText("");
        pass.setText("");
        phone.setText("");
        uname.setText("");
        mail.setText("");
        age.setText("");
    }

    public void OnHomeClick(View view) {
        Intent i = new Intent(getApplicationContext(), Start_Page.class);
        startActivity(i);
    }
}