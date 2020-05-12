package com.example.myapptracnghiem.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;

import java.util.ArrayList;

public class checkDapAnAdapter extends BaseAdapter {
    ArrayList listdata;
    LayoutInflater inflater;

    public checkDapAnAdapter(ArrayList listdata, Context context) {
        this.listdata = listdata;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Question question =(Question)getItem(position);
       ViewHolder holder;

        if (view==null){
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.item_ktdapan,null);
            holder.cauhoi=(TextView)view.findViewById(R.id.cauhoi);
            holder.cauchon=(TextView)view.findViewById(R.id.cauchon);
            holder.dapan=(TextView)view.findViewById(R.id.dapan);

            view.setTag(holder);
        }else{
            holder=(checkDapAnAdapter.ViewHolder)view.getTag();
        }

        int vitri=position+1;
        holder.cauhoi.setText("Câu "+vitri+" : ");
        holder.cauchon.setText(question.getAnsCheck());
        holder.dapan.setText(question.getResult());
        if (holder.cauchon.getText().toString().equals(holder.dapan.getText().toString())){
            holder.cauchon.setTextColor(Color.BLUE);
            holder.dapan.setTextColor(Color.BLUE);
        }else {
            holder.cauchon.setTextColor(Color.RED);
            holder.dapan.setTextColor(Color.BLUE);
        }

        return view;
    }
   private static class ViewHolder{
        TextView cauhoi,cauchon,dapan;

   }
}
