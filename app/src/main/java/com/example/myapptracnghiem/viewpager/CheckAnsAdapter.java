package com.example.myapptracnghiem.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;

import java.util.ArrayList;

public class CheckAnsAdapter extends BaseAdapter {
    ArrayList listdata;
    LayoutInflater inflater;


    public CheckAnsAdapter(ArrayList listdata, Context context) {
        this.listdata = listdata;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int i) {
        return listdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Question question =(Question)getItem(i);
        final ViewHolder holder;


        if (view==null){
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.item_ans_gv,null);
            holder.tvNumAns=(TextView)view.findViewById(R.id.tvnumAns);
            holder.tvAns=(TextView)view.findViewById(R.id.tvAns);
           ;
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }

        int vitri=i+1;
        holder.tvNumAns.setText("Câu "+vitri+" : ");
        holder.tvAns.setText(question.getAnsCheck());

        return view;
    }

    private  static class ViewHolder{
        TextView tvNumAns,tvAns;


    }
}
