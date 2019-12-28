package com.example.yihuawei.moment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.yihuawei.R;

public class SendActivity extends AppCompatActivity {
    private Toolbar tool;
    private EditText et_content;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        tool = (Toolbar) findViewById(R.id.tool);
        et_content = (EditText) findViewById(R.id.et_content);
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
    }
}
