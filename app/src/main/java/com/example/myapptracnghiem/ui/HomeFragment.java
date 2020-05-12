package com.example.myapptracnghiem.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapptracnghiem.KienThucMonHoc.KienThucAc;
import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.viewpager.activityScreenViewpager;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

ImageView imgtoan,imghoa,imgly;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_home, container, false);

        imghoa=rootView.findViewById(R.id.imghoa);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imghoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), KienThucAc.class);

                startActivity(intent);
            }
        });
    }
}
