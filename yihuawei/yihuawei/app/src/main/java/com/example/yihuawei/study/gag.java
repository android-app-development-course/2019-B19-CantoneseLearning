package com.example.yihuawei.study;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yihuawei.MyHelper;
import com.example.yihuawei.R;
import com.example.yihuawei.my.MyFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class gag extends AppCompatActivity {
    TextView  open,gag;
    Button next;
    String DB_NAME = "gag.db";
    SQLiteDatabase db;
    MyHelper myHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gag);
        Log.v("breakthrough", "加载界面完成");
        File fileDir = getFilesDir();
        Log.v("breakthrough", "fileDir成功");
        File file = new File(fileDir, DB_NAME);
        Log.v("breakthrough", "file创建成功");
        if(file.exists())
        {
            Log.v("breakthrough", "界面已存在了file文件，为上次运行的时候的造成的");
            return;
        }
        InputStream in = null;
        FileOutputStream out = null;
        Log.v("breakthrough", "输入输出流构建完成");
        try
        {
            in = this.getAssets().open(DB_NAME);
            Log.v("breakthrough", "打开了getAssets中的db");
            out = new FileOutputStream(file);
            Log.v("breakthrough", "初始化输出流成功");
            byte[] buffer = new byte[1024];
            int length = -1;
            while( (length = in.read(buffer)) != -1 )
            {
                out.write(buffer, 0, length);
                Log.v("breakthrough", "输入流输入了多少次啊");
            }
            Log.v("breakthrough", "复制成功");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Log.v("breakthrough", "数据库复制失败");
        }
        finally
        {
            try{
                in.close();
                out.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Log.v("breakthrough", "关闭输入输出流失败");
            }
        gag = (TextView) findViewById(R.id.gag);
        next = (Button) findViewById(R.id.next);
        open = (Button)findViewById(R.id.btn_open1);
        myHelper=new MyHelper(this);
    }
    db=myHelper.getReadableDatabase();
        final Cursor cursor =db.query("gag",null,null,null,null,null,null);
        cursor.moveToFirst();
        gag.setText(cursor.getString(2));
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open.setText(cursor.getString(3));
            }
        });
        cursor.close();
        db.close();
    }
}
