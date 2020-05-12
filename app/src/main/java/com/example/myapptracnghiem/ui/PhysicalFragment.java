package com.example.myapptracnghiem.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.viewpager.activityScreenViewpager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFragment extends Fragment {

    ExamAdapter examAdapter;
    GridView gridView;
    ArrayList<Exam> arrayList =new ArrayList<Exam>();
    public PhysicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_physical, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView=(GridView)getActivity().findViewById(R.id.gridviewP);
        arrayList.add(new Exam("Đề số 1"));
        arrayList.add(new Exam("Đề số 2"));
        arrayList.add(new Exam("Đề số 3"));
        arrayList.add(new Exam("Đề số 4"));
        arrayList.add(new Exam("Đề số 5"));
        examAdapter=new ExamAdapter(getActivity(),arrayList);
        gridView.setAdapter(examAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),activityScreenViewpager.class);
                Bundle bundle =new Bundle();
                bundle.putString("subject","Physical");
                bundle.putInt("idexam",i);
//                intent.putExtra("subject","math");
//                intent.putExtra("idexam",i);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}