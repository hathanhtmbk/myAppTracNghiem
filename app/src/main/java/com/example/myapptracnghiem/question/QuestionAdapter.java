package com.example.myapptracnghiem.question;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptracnghiem.R;

import java.util.ArrayList;

import static android.content.Intent.getIntent;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    Context context;
    ArrayList<Question> questions;
    public QuestionAdapter(Context context, ArrayList<Question> questions) {
        this.context = context;
        this.questions = questions;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemview=inflater .inflate(R.layout.fragment_viewpager,parent,false);
        return new ViewHolder(itemview);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


       holder.tvNum.setText("Câu "+String.valueOf(questions.get(position).getNumberQues()));

        holder.tvQuestion.setText(questions.get(position).getQuestion());
        holder.radA.setText(questions.get(position).getAns_a());
        holder.radB.setText(questions.get(position).getAns_b());
        holder.radC.setText(questions.get(position).getAns_c());
        holder.radD.setText(questions.get(position).getAns_d());
        //Toast.makeText(context,questions.get(position).getCheck(),Toast.LENGTH_SHORT).show();
//         String  end="false";
//            if (holder.txtCheck.getText().toString().equals("success")) {
//                end="true";
//
//                Toast.makeText(context, "thanh cong", Toast.LENGTH_SHORT).show();
//
//
//            }
//            if (end.equals("true")==true){
//
//                    holder.radA.setClickable(false);
//                    holder.radB.setClickable(false);
//                    holder.radC.setClickable(false);
//                    holder.radD.setClickable(false);
//                    holder.getCheckAns(questions.get(position).getResult());
//
//            }

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idCheck) {

               // getChoiceFromID(idCheck);

                getItem(position).setAnsCheck(getChoiceFromID(idCheck));
               // Toast.makeText(context,getChoiceFromID(idCheck).toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
    public Question getItem(int posotion){
        return questions.get(posotion);
    }


    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }




    @Override
    public int getItemCount() {
        return questions.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
TextView tvNum,tvQuestion,tvNumAns,txtCheck;

RadioButton radA,radB,radC,radD;
RadioGroup radioGroup;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            radioGroup=itemView.findViewById(R.id.radGroup);
            tvNumAns=itemView.findViewById(R.id.tvAns);
            tvNum=itemView.findViewById(R.id.tvNum);
            txtCheck=itemView.findViewById(R.id.idcheck);
            tvQuestion=itemView.findViewById(R.id.tvQuestion);
            radA=itemView.findViewById(R.id.radA);
            radB=itemView.findViewById(R.id.radB);
            radC=itemView.findViewById(R.id.radC);
            radD=itemView.findViewById(R.id.radD);


        }
        private void getCheckAns(String ans){
            if(ans.equals("A")==true){
                radA.setBackgroundColor(Color.RED);
            }
            else if(ans.equals("B")==true){
                radB.setBackgroundColor(Color.RED);
            }else if(ans.equals("C")==true){
                radC.setBackgroundColor(Color.RED);
            }else if(ans.equals("D")==true){
                radD.setBackgroundColor(Color.RED);
            }else ;
        }


    }

}
