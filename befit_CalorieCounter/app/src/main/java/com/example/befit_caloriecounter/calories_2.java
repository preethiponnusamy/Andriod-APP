package com.example.befit_caloriecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class calories_2 extends AppCompatActivity {

    private FirebaseDatabase fb=FirebaseDatabase.getInstance();
    private DatabaseReference db=fb.getReference();
    private DatabaseReference f;

    String[] food = {"Bengal Gram Cooked","Bengal Gram Roasted","Black Gram Cooked","Broken Dals","Potato(Fresh)","Potato(mashed with milk )","Potato(baked)","Potato(boiled)",
    "Sweet Potatoes(Boiled)","Tomato Ketchup","Onion","Peas","Carrot","Cabbage","Corn","Cucumber","CauliFlower","Pumpkin","Beans(French Green)","Brinjal","Brocoli","Baked Beans",
    "Lettuce","Beets","Mushroom","Radish(Red)","Spinach","Butter","GroundNut Oil","Corn Oil","Margarine","Desi Ghee","Mayonnaise","Sugar","Honey","Jaggery","Brown Sugar","Jam/Jelly",
    "Horlicks","Chocolate","Chicken","Pork","Goat Meat/ Mutton","Beef","Egg(Boiled)","Egg(Fried)","Egg White","Egg(Scrambled)","Tomato Juice","Buffalo Milk","Cow Milk","Paneer",
    "Bread White","Bread Brown","Corn Flakes","Oats","Barley","Red Gram","Green Gram","Black Gram","Rajma","Soya Bean","Beetroot","Cabbage","CauliFlower","Cucumber","MixedVegetables","Olives"
    ,"SpringOnion","SweetCorn","Tomatoes","Brown Rice","White Rice","Basmathi Rice","Oil"};
    AutoCompleteTextView atv;
    EditText et1;
    TextView t1,t2;
    String k ="";
    String w = "";
    float val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_selectable_list_item,food);
        atv= findViewById(R.id.act);
        atv.setThreshold(1);
        atv.setAdapter(adapter);
        atv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                atv.showDropDown();
                return false;
            }
        });

        t1=findViewById(R.id.txt);
        t2=findViewById(R.id.txt1);
        et1 = findViewById(R.id.quan);



    }

    public void search(View view) {


        String key=atv.getText().toString();
        f=db.child("foods2").child(key);
        w = key + ":";
        f.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String l =snapshot.child("amt").getValue().toString() ;
                String str = l;
                String numberOnly= l.replaceAll("[^0-9]", "");
                str = str.replaceAll("[0-9]", "");
                float i = Float.parseFloat(numberOnly);
                String u = et1.getText().toString();
                float a = Float.parseFloat(u);
                w = w + u + " " + str;
                k = k + w + "\n";
                w = "";
                t1.setText(k);

                String e = snapshot.child("calories").getValue().toString();
                float v = Float.parseFloat(e);
                v = (a*v)/i;
                val = val + v;
                v = 0;
                t2.setText("Calories : "+ Float.toString(val));
                et1.setText("");
                atv.setText("");




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void menu(View view) {
    }
    public void NewClick(View view){
        t1.setText("");
        t2.setText("");
        k = "";
        et1.setText("");
        atv.setText("");
        val = 0;
    }
}