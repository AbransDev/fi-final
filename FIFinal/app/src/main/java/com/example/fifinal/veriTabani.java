package com.example.fifinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class veriTabani extends SQLiteOpenHelper{
    public  veriTabani(Context context){
        super(context, "Farukilhan", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kelimeler (id INTEGER PRIMARY KEY AUTOINCREMENT, kelimeno TEXT, tr TEXT, en TEXT, alm TEXT);");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kelimeler");
        this.onCreate(db);
    }

}
