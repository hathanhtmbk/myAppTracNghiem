package com.example.myapptracnghiem.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapptracnghiem.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exams) {
        super(context, 0,exams);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_gridview,parent,false);
        }
        TextView tvName=(TextView)convertView.findViewById(R.id.tv_idExam);
        ImageView imgIcon=(ImageView)convertView.findViewById(R.id.imgicon);
        Exam p=getItem(position);
        if (p!=null){
            tvName.setText(""+p.getName());
            imgIcon.setImageResource(R.drawable.book);
        }
        return convertView;
    }
}
