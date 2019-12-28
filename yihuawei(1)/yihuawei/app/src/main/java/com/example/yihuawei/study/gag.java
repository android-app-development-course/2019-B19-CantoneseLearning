package com.example.yihuawei.study;



import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.yihuawei.Dbmanager;
import com.example.yihuawei.MainActivity;
import com.example.yihuawei.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class gag extends AppCompatActivity implements  View.OnClickListener{
    TextView  open,gag1;
    Button next;
    private Toolbar tool;
    int _id = (int) (Math.random() * 6+1);
    String answer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gag);
        gag1 = (TextView) findViewById(R.id.gag);
        next = (Button) findViewById(R.id.next);
        open = (Button) findViewById(R.id.btn_open1);
        tool = (Toolbar) findViewById(R.id.tool);
        next.setOnClickListener(this);
        open.setOnClickListener(this);
        tool.setTitle("");
        setSupportActionBar(tool);//设置toolbar
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置显示返回按钮
        tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMain = new Intent();
                setResult(RESULT_OK,toMain);
                finish();
            }
        });
        Dbmanager manager = new Dbmanager(gag.this);
        manager.openDataBase();
        SQLiteDatabase db = manager.getDb();
        Cursor cursor = db.query("gag", null, "_id=?", new String[]{_id+""}, null, null, null);
        cursor.moveToFirst();
        int contentIndex, answerIndex;
        contentIndex = cursor.getColumnIndex("content");
        answerIndex = cursor.getColumnIndex("answer");
        String content = cursor.getString(contentIndex);
        answer = cursor.getString(answerIndex);
        gag1.setText(content);
        manager.closeDataBase();
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_open1:
                open.setText(answer);
                break;
            case R.id.next:
                _id = (int) (Math.random() * 6+1);
                Intent intent = new Intent(this,gag.class);
                startActivity(intent);
                gag.this.finish();
                break;
        }

    }
//    protected void onResume() {
//        super.onResume();
////在子线程中进行对数据库的打开操作
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Dbmanager manager = new Dbmanager(gag.this);
//                manager.openDataBase();
//                SQLiteDatabase db = manager.getDb();
//                Cursor cursor = db.query("gag", null, null, null, null, null, null);
//                if (cursor.moveToNext()) {
//                    int _idIndex, contentIndex, answerIndex;
//                    _idIndex = cursor.getColumnIndex("_id");
//                    contentIndex = cursor.getColumnIndex("content");
//                    answerIndex = cursor.getColumnIndex("answer");
//                    do {
//                        int _id = cursor.getInt(_idIndex);
//                        String content = cursor.getString(contentIndex);
//                        String answer  = cursor.getString(answerIndex);
////使用Log查看数据,未在界面展示
//                        Log.d("DbTest","_id:"+_id+" content:"+content+" answer:"+answer);
//                    }while(cursor.moveToNext());
//                }
//                manager.closeDataBase();
//            }
//        }).start();
//    }
}


