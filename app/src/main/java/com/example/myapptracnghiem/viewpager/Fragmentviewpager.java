package com.example.myapptracnghiem.viewpager;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;
import com.example.myapptracnghiem.question.QuestionAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class Fragmentviewpager extends Fragment {
    TextView txtCheck;



    public Fragmentviewpager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_viewpager, container, false);


        txtCheck=rootView.findViewById(R.id.idcheck);

        Bundle bundle=getArguments();
        if (bundle!=null){
            String tmp=bundle.getString("k");
            txtCheck.setText(tmp);
            Toast.makeText(getActivity(),txtCheck.getText(),Toast.LENGTH_SHORT).show();


        }

        return rootView;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Bundle bundle=getArguments();
//        if (bundle!=null){
//
//            txtCheck.setText(bundle.getString("Keycheck"));
//
//        }
//
//    }
}
