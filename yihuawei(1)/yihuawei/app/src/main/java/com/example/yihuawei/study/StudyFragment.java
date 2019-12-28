package com.example.yihuawei.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.yihuawei.R;

public class StudyFragment extends Fragment {
    public StudyFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        Button btn_sty = (Button)view.findViewById(R.id.btn_sty);
        Button btn_fashion = (Button)view.findViewById(R.id.btn_fashion);
        Button btn_gag = (Button)view.findViewById(R.id.btn_gag);
        btn_sty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),gag.class);
                startActivity(intent);
            }
        });
        btn_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),gag.class);
                startActivity(intent);
            }
        });
        btn_gag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),gag.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
