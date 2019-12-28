package com.example.yihuawei;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context,"gag.db",null,2);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE gag(_id INTEGER PRIMARY KEY AUTOINCREMENT,content VARCHAR(100),answer VARCHAR(20))");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
