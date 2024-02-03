package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.data.mydbhandler;
import com.example.myapplication.model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydbhandler db = new mydbhandler(MainActivity.this);
//        contact harry = new contact();
//        harry.setPhonenumber("889788970879");
//        harry.setName("harry");
//        db.add_contact(harry);
//        contact savin = new contact();
//        savin.setPhonenumber("78788970879");
//        savin.setName("savin");
//        db.add_contact(savin);
//        contact darry = new contact();
//        darry.setPhonenumber("889788970879");
//        darry.setName("darry");
//        db.add_contact(darry);
//        darry.setId(46);
//        darry.setName("parry");
//        darry.setPhonenumber("0000000000");
//        int affect_rows = db.update_contact(darry);
//        Log.d("hello paji ji ", "no of affected rows are "+affect_rows);
        List<contact> all_contacts = db.getall_contact();
        for(contact cona: all_contacts){
            Log.d("padd", cona.getName() + " the id of the object in this app is "+cona.getName()+"this is the phone number of the app "+ cona.getPhonenumber());
        }
        Log.d("dba", "you have "+ db.get_count()+"contacts in your database");
    }
}