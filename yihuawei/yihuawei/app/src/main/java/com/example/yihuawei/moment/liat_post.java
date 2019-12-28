package com.example.yihuawei.moment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yihuawei.R;

public class liat_post extends AppCompatActivity {
    TextView name;
    ImageView photo;
    Button btn_like,btn_unlike;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liat_post);
        name = (TextView) findViewById(R.id.name);
        photo = (ImageView) findViewById(R.id.post);
        btn_like = (Button) findViewById(R.id.bt_like);
        btn_unlike = (Button)findViewById(R.id.bt_unlike);
    }
}
