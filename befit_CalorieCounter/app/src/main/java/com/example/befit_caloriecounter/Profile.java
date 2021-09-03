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

public class Profile extends AppCompatActivity {
    TextView phone;
    SQLiteDatabase db;
    EditText name,uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle b=getIntent().getExtras();
        String ph=b.getString("ph");
        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM users WHERE number ='" + ph+ "'", null);
        phone = findViewById(R.id.phone);
        phone.setText(ph);
        name = findViewById(R.id.name);
        uname = findViewById(R.id.uname);
        if(c!=null && c.moveToFirst()){
       String s = c.getString(0);
       String v = c.getString(1);
        name.setText(s);
        uname.setText(v);
        }


    }

    public void onSaveClick(View view) {
        db.execSQL("UPDATE users"+" SET name = "+"'"+name.getText()+"' "+ "WHERE number = "+"'"+phone.getText()+"'");
        db.execSQL("UPDATE users"+" SET uname = "+"'"+uname.getText()+"' "+ "WHERE number = "+"'"+phone.getText()+"'");
        showMessage("Success","Details Updated successfully");
        Cursor c1 = db.rawQuery("SELECT * FROM users WHERE number ='" + phone.getText()+ "'", null);
        if(c1 != null && c1.moveToFirst()) {
            String x = c1.getString(0);

        }
    }

    public void OnChangeClick(View view) {
        Intent i = new Intent(this, PassChange.class);
        i.putExtra("ph",phone.getText());
        startActivity(i);
    }
    public void showMessage (String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}