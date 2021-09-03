package com.example.befit_caloriecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PassChange extends AppCompatActivity {
    TextView tv;
    SQLiteDatabase db;
    EditText pass,npass,cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_change);
        Bundle b = getIntent().getExtras();
        String ph = b.getString("ph");
        tv = findViewById(R.id.textView);
        tv.setText(ph);
        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        pass = findViewById(R.id.pass);
        npass = findViewById(R.id.npass);
        cpass = findViewById(R.id.cpass);


    }


    public void OnConfirmClick(View view) {
        Cursor c = db.rawQuery("SELECT * FROM users WHERE number ='" + tv.getText()+ "'", null);
        if(c!= null && c.moveToFirst()){
            String y = c.getString(2);


            if(y.equals(pass.getText().toString())){
               if(npass.getText().toString().equals(cpass.getText().toString())){
                   db.execSQL("UPDATE users"+" SET password = "+"'"+npass.getText()+"' "+ "WHERE number = "+"'"+tv.getText()+"'");
                   showMessage("SUCCESS","Password Changed Successfully \n Can use this from next login");
               }
               else{
                   showMessage("ERROR","Password reentered wrong");
               }
            }
            else{
                showMessage("ERROR","Current password is not matching");
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