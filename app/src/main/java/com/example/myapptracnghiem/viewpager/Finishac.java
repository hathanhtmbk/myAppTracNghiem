package com.example.myapptracnghiem.viewpager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapptracnghiem.MainActivity;
import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;
import com.example.myapptracnghiem.ui.MathFragment;

import java.util.ArrayList;

public class Finishac extends AppCompatActivity {
    ArrayList<Question> arr_QuesBegin= new ArrayList<Question>();
   // ArrayList<Question> arrayQuestion;
    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;
    int totalScore=0;
    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishac);
        final Intent intent= getIntent();
        arr_QuesBegin= (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        anhXa();
        checkResult();
        totalScore= numTrue*5;

        tvNotAns.setText(""+numNoAns);
        tvFalse.setText(""+numFalse);
        tvTrue.setText(""+numTrue);
        tvTotalScore.setText(""+totalScore);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                final AlertDialog.Builder builder=new AlertDialog.Builder(Finishac.this);
//                builder.setIcon(R.drawable.exit);
//                builder.setTitle("Thông báo");
//                builder.setMessage("Bạn có muốn thoát hay không?");
//                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                });
//                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
//
//                builder.show();
            }
        });
        checkDapAnAdapter checkDapAnAdapter=new checkDapAnAdapter(arr_QuesBegin,this);
        GridView gridView = (GridView)findViewById(R.id.ktradapan);
        gridView.setAdapter(checkDapAnAdapter);

    }
    public void checkResult(){
        for(int i=0; i< arr_QuesBegin.size(); i++){
            if(arr_QuesBegin.get(i).getAnsCheck().equals("")==true){
                numNoAns++;
            }else if(arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getAnsCheck())==true){
                numTrue++;
            }else numFalse++;
        }
    }
    public void anhXa(){
        tvFalse= (TextView)findViewById(R.id.tvFalse);
        tvTrue= (TextView)findViewById(R.id.tvTrue);
        tvNotAns= (TextView)findViewById(R.id.tvNotAns);
        tvTotalScore= (TextView)findViewById(R.id.tvTotalPoint);

        btnExit=(Button)findViewById(R.id.btnExit);
    }
}
