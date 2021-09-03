package com.example.befit_caloriecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class calories extends AppCompatActivity {

    private FirebaseDatabase fb=FirebaseDatabase.getInstance();
    private DatabaseReference db=fb.getReference();
    private DatabaseReference f;

    String[] food ={"Aloo gobi","aloo tika","Aloo matar","aloo methi","Aloo shimla mirch","Amriti with rabdi","Amritsari fish","Amritsari kulcha",
            "Baati","bhautra","Bhindi masala","veg Biryani","mushroom Biryani","meal maker Biryani","soya Biryani","Butter chicken","Chaat",
            "Chana masala","Chapati","Chicken razala","Chicken Tikka","Chicken Tikka masala","Chole bhature","Daal baati churma","Daal puri",
            "Dal","Poha","Firni","French bean aloo","Gajar ka halwa","Gajar matar aloo","Gobi matar","Imarti","green peas daal","Jalebi","Kachori",
            "Kadai paneer","Kadhi pakoda","Karela bharta","halwakadoo","Katha meetha petha","Kheer","Khichdi","Kofta","Kulfi falooda","Lauki ke kofte",
            "Litti chokha","Lauki ki subji","Makki di roti","sarson da saag","Mathura ke pede","Misi roti","Moong dal ka halwa","Mushroom do pyaza",
            "Mushroom matar","Naan","Navrattan korma","Pakhala","Palak paneer","Paneer butter masala","Paneer tikka masala","Pani puri",
            "Panjeeri","Papad","Paratha","Pattor","Phirni","Pindi chana","Pinni","Rajma","Ramatori subji","Rongi","Samosa","Sattu ki roti" ,"Shahi paneer","Shahi tukra","Singhada halwa","Sooji halwa","Sweet pethas "," kesar petha","pista petha","Vegetable jalfrezi","Tandoori Chicken",
            "Tandoori Fish Tikka","Attu","Dosa","Avial","Halwa","chicken biryani","mutton biryani","Bisi bele bath",
            "Chettinadu Chicken" ,"Chicken 65","Currivepillai sadam","Dibba rotti","Double ka meetha","Ennai kathirikkai",
            "Goli bajje","Idiappam","Idli"," omelette","Kaara kozhambu","Kanji","Keerai kootu","Keerai masiyal","Keerai poriyal","Keerai sadam",
            "Kerala_Beef_Fry","Beef Fry" ,"Koottu","Kori rotti","Kos kootu","Koshambri","Kothamali sadam","Kuzhakkattai","Masala Dosa","Obbattu","holige","bobbattu","pooran-poli",
            "Olan","Paniyaram","Paravannam","Parotta","Paruppu sadam","Daal rice","Payasam","Pesarattu","Pongal","Puli sadam","Tamarind rice","Puttu","Ragi mudhe","Rasam","Sajjige",
            "Sakkara pongal","Sambar","Sandige","Sevai","thayir sadam","Curd rice","Theeyal","Thengai sadam","Uttapam","Wheat upma","Yelumincham sadam","Amti","Zunka","Pitla",
            "Naralachi vadi ","Khobryachi vadi","Coconut vadi","Bajri no rotlo","Modak","Barfi","Basundi","Bhakri","Karanji","Bombil fry","Bhalla Papri Chaat","Chakri","Chevdo",
            "Cholafali","Copra paak","Daal Dhokli","Dabeli","Kutchi dabeli","Dahi vada","Dalithoy","Dhokla","Doodhpak","Dudhi no halwo","Dum aaloo","Pohe","Gajar halwo","Gatta curry","Ghari",
            "Ghooghra","Gud papdi","Gol papdi","Gulab jamun","Halvasan","Handwo","Gur","Jeera Aloo","Juvar no rotlo","Kansar","Keri no ras","Khakhra","Khandvi","Kombdi vade","Koshimbir",
            "Laapsi","Laddu","Locha","Malpua","Methi na Gota","Modak","Mohanthal","Muthiya","Oondees","Patra","Penda","Pooran-poli","Puri","Puri Bhaji","Rasya muthia",
            "Sabudana Khichadi","Sev khamani","Sev tameta","Shakarpara","Namakpara","Shankarpali","Shiro","Shrikhand","Sohan papdi","Soonvali","Sukhdi","Surnoli","Sutarfeni","Thalipeeth",
            "Undhiyu","Veg Kolhapuri","Vindaloo","Ghevar","Lilva Kachori","Maghaz","Undhiyu","Mag Dhokli","Khichu","Thepla","Farsi Puri","Khaman","Turiya Patra Vatana sabji",
            "Churma Ladoo","Cheera Doi","Dhup Pitha","Gheela Pitha","Hurum", "Khar","Kumol Sawul","Loskora","Luchi","Momo","Muri Naaru","Pani Tenga","Sunga Pitha","Alu Pitika","Masor tenga",
            "Bengena Pitika","Bilahi Maas","Black rice","Bora Sawul","Brown Rice","Chhenagaja","Chhenapoda","Chingri malai curry","Goja","Hando Guri","Haq Maas","Horioh Maas",
            "Ilish "," Chingri Bhape","Kabiraji","Kharoli","Khorisa","Koldil Chicken","Koldil Duck","Konir Dom","Lai Haq Maas","Litti","Maasor Tenga","Masor Koni","Mishti Chholar Dal",
            "Mishti Doi","Ou tenga Maas","Pakhala","Pani Pitha","Pantua","Payokh","Peda","Prawn malai curry","Red Rice","Rice","Rosgulla","Sabzi","shondesh","Shukto","Sunga Pork","Tenga Doi",
            "Til Pitha","pizza","burger","sandwich","puff","Acai Juice","Apple Juice","Apricot Nectar","Banana Juice","Blackberry Juice","Boysenberry Juice","Grapefruit Juice","Lemon Juice","Lemonade","Lime Juice","Limeade",
             "Boysenberry Juice","Capri-Sun","Chamomile Tea","Carrot Juice","Cherry Juice","Clamato","Coconut Milk","Coconut Water","Mango Lassi","Nestea","Orange Juice","Papaya Juice","Passion Fruit Juice","Peach Juice","Peach Nectar",
            "Grape Juice","Fruitopia","Energy-Drink","Cucumber Juice","Cranberry Juice","Cranberry Grape Juice","Cranberry Apple Juice","Concord Grape","Pear Juice","Pear Nectar","Pineapple Juice","Pineapple Orange Juice","Plum Juice",
            "Pomegranate Juice","Sauerkraut Juice","Tangerine Juice","Tomato Juice","Vegetable Juice","White Grape Juice"};
    AutoCompleteTextView atv;
    ImageButton search,menu;
    ImageView img;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_selectable_list_item,food);
        atv= findViewById(R.id.act);
        atv.setThreshold(1);
        atv.setAdapter(adapter);
        img=findViewById(R.id.imgfood);
        t1=findViewById(R.id.txt);
        t2=findViewById(R.id.txt1);
        t3=findViewById(R.id.txt2);

        atv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                atv.showDropDown();
                return false;
            }
        });
    }
    public void search(View view) {

        String key=atv.getText().toString();

        f=db.child("food").child(key);
        f.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String link=snapshot.child("url").getValue().toString();
                Picasso.get().load(link).into(img);
                t1.setText(snapshot.child("calories").getValue().toString());
                t2.setText(snapshot.child("n_value").getValue().toString());
                t3.setText(snapshot.child("description").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void menu(View view) {
    }
}