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

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText pass, uname;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass = findViewById(R.id.pass);
        uname = findViewById(R.id.name);
        login = findViewById(R.id.log);
        login.setOnClickListener(this);
        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
    }

    public void OnHomeClick(View view) {
        Intent i = new Intent(getApplicationContext(), Start_Page.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        if (uname.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
            showMessage("Error", "Please Fill in all details");
            return;
        } else {
            Cursor c = db.rawQuery("SELECT * FROM users WHERE uname ='" + uname.getText() + "'", null);
            if (c != null && c.moveToFirst()) {


                if (c.getString(2).equals(pass.getText().toString())) {
                    String name1 = c.getString(0);
                    String ph = c.getString(3);

                    Intent i = new Intent(this, Home_1.class);
                    i.putExtra("name", name1);
                    i.putExtra("ph", ph);
                    startActivity(i);


                }

            } else {
                Intent i = new Intent(this, Signup.class);
                startActivity(i);

            }

        }
    }

    public void showMessage (String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}