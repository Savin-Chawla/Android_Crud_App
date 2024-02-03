package com.example.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.model.contact;
import com.example.myapplication.params.params;

import java.util.ArrayList;
import java.util.List;

public class mydbhandler extends SQLiteOpenHelper {
    public mydbhandler(@Nullable Context context) {
        super(context, params.DB_NAME, null, params.DB_version);
    }

    @Override
    @Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String create = "CREATE TABLE " + params.TABLE_NAME + "(" + params.KEY_ID + " INTEGER PRIMARY KEY, " +
            params.KEY_NAME + " TEXT, " + params.KEY_PHONE + " TEXT" + ")";
    Log.d("dbharry", "query running is the : " + create);
    sqLiteDatabase.execSQL(create);
}


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void add_contact(contact ontact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME, ontact.getName());
        values.put(params.KEY_PHONE, ontact.getPhonenumber());
        db.insert(params.TABLE_NAME,null , values );
        Log.d("dbharry", "nicely insert");
        db.close();
    }
    public List<contact> getall_contact(){
        List<contact> contactlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = " SELECT * FROM " + params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do {
                contact con = new contact();
                con.setId(Integer.parseInt(cursor.getString(0)));
                con.setName(cursor.getString(1));
                con.setPhonenumber(cursor.getString(2));
                contactlist.add(con);
            }while(cursor.moveToNext());
        }
        return contactlist;
    }
    public int update_contact(contact cont){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME, cont.getName());
        values.put(params.KEY_PHONE,cont.getPhonenumber() );
        return db.update(params.TABLE_NAME, values , params.KEY_ID+"=?", new String[]{String.valueOf(cont.getId())});
    }
    public void Delete_contactby_id(int id ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME, params.KEY_ID +"=?",new String[]{String.valueOf(id)});
        db.close();

    }
    public void Delete_contact(contact contt ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME, params.KEY_ID +"=?",new String[]{String.valueOf(contt.getId())});
        db.close();

    }
    public int get_count(){
        String query= "SELECT * FROM "+ params.TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =db.rawQuery(query, null );
        return cursor.getCount();
    }

}
