package com.example.yihuawei.moment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.example.yihuawei.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MomentFragment extends Fragment {
    public MomentFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moment, container, false);
        ListView listView;
        FloatingActionButton add=(FloatingActionButton)view.findViewById(R.id.add);
        SimpleAdapter adapter;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SendActivity.class);
                startActivity(intent);
            }
        });
	    return view;
    }

}
