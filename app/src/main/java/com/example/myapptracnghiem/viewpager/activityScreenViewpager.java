package com.example.myapptracnghiem.viewpager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapptracnghiem.MainActivity;
import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;
import com.example.myapptracnghiem.question.QuestionAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class activityScreenViewpager extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
   // private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
  //  private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    //private PagerAdapter pagerAdapter;
    String urlGetMath="http://192.168.1.147/android_BC/getdataMath.php";
    String urlGetPhy="http://192.168.1.147/android_BC/getPhysical.php";
    String urlGetChem="http://192.168.1.147/android_BC/getChemistry.php";
    RecyclerView rcView;
    String subject;
    RadioButton radA,radB,radC,radD;
    TextView tvCkeck,tvTimer,tvXemdiem,txtCkeckQues;
    int idexam;

    ArrayList<Question> arrayQuestion;

    QuestionAdapter adapter;
    CounterClass timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_viewpager);

       // Instantiate a ViewPager and a PagerAdapter.
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
          subject=bundle.getString("subject","");
         idexam=bundle.getInt("idexam",0);
           //Toast.makeText(activityScreenViewpager.this,subject.toString(),Toast.LENGTH_SHORT).show();
           // Toast.makeText(activityScreenViewpager.this,String.valueOf(idexam).toString(),Toast.LENGTH_SHORT).show();
        }

        rcView=findViewById(R.id.rcView);
        tvCkeck=(TextView)findViewById(R.id.tvCheck);
        tvXemdiem=(TextView)findViewById(R.id.tvScore);
        txtCkeckQues=(TextView)findViewById(R.id.txtCkeckQues);

        tvTimer=findViewById(R.id.tvTimer);
        timer=new CounterClass(20*60*1000,1000);
//        mPager = (ViewPager) findViewById(R.id.pager);
//        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
//        mPager.setAdapter(pagerAdapter);
//        mPager.setPageTransformer(true, new DepthPageTransformer());
        arrayQuestion=new ArrayList<>();
        adapter=new QuestionAdapter(activityScreenViewpager.this, arrayQuestion);
        LinearLayoutManager manager=new LinearLayoutManager(activityScreenViewpager.this,LinearLayoutManager.HORIZONTAL,false);
        rcView.setLayoutManager(manager);
        rcView.setAdapter(adapter);
    if(subject.equals("Math")){
        GetData(urlGetMath,subject,idexam);
    }else if(subject.equals("Chemistry")){
        GetData(urlGetChem,subject,idexam);
    }
    else if(subject.equals("Physical")){
        GetData(urlGetPhy,subject,idexam);
    }

    //  Toast.makeText(activityScreenViewpager.this,Question,Toast.LENGTH_SHORT).show();
        tvCkeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer();
            }
        });
        tvXemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(activityScreenViewpager.this, Finishac.class);
                intent1.putExtra("arr_Ques", arrayQuestion);
                startActivity(intent1);
            }
        });

       tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        timer.start();

    }
    @Override
    public void onBackPressed() {

            dialogExit();

    }
    public void dialogExit(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(activityScreenViewpager.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }
    public void GetData(String url, final String subject, final int idexam){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               // Toast.makeText(activityScreenViewpager.this,response.toString(),Toast.LENGTH_SHORT).show();
               // Toast.makeText(activityScreenViewpager.this,subject.toString(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(activityScreenViewpager.this,String.valueOf(idexam).toString(),Toast.LENGTH_SHORT).show();
                for (int i=0;i<=response.length();i++){


                    try {
                        JSONObject object=response.getJSONObject(i);

                        if (object.getInt("id_exam")==(idexam+1)&&object.getString("subject").equals(subject)){
                            //Toast.makeText(activityScreenViewpager.this,"Bắt đầu làm bài",Toast.LENGTH_SHORT).show();
                        arrayQuestion.add(new Question(

                                object.getInt("id"),
                                object.getInt("numberQues"),
                                object.getString("question"),
                                object.getString("ans_a"),
                                object.getString("ans_b"),
                                object.getString("ans_c"),
                                object.getString("ans_d"),
                                object.getString("result"),
                                object.getInt("id_exam"),
                                object.getString("subject"),
                                object.getString("image")

                        ));
                        }
//                        else{
//                            Toast.makeText(activityScreenViewpager.this,"Đề này hiện tại chưa có !",Toast.LENGTH_SHORT).show();
//                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activityScreenViewpager.this,"lỗi",Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void CheckAnswer(){


        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.check_ans_layout);
        dialog.setTitle("Danh sách các câu hỏi");
        final CheckAnsAdapter answerAdapter=new CheckAnsAdapter(arrayQuestion,this);
        GridView gridView = (GridView) dialog.findViewById(R.id.gvAns);
        gridView.setAdapter(answerAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                dialog.dismiss();
            }
        });
        final TextView tvEnd;
        Button btnHuy,btnNop;
        final TextView txtcheck;
//        radA=(RadioButton)findViewById(R.id.radA);
//        radB=(RadioButton)findViewById(R.id.radB);
//        radC=(RadioButton)findViewById(R.id.radC);
//        radD=(RadioButton)findViewById(R.id.radD);
        btnHuy=(Button)dialog.findViewById(R.id.btnhuy);
        btnNop=(Button)dialog.findViewById(R.id.btnend);

        txtcheck=(TextView)findViewById(R.id.idcheck) ;


        btnHuy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dialog.dismiss();
    }
});
        btnNop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(activityScreenViewpager.this);
        builder.setIcon(R.drawable.hoicham);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có chắc chắn muốn nộp hay chưa?");
        builder.setPositiveButton("Chắc chắn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragmentviewpager fragmentviewpager=new Fragmentviewpager();
        Bundle bundle=new Bundle();
        bundle.putString("k","Thành công");
        fragmentviewpager.setArguments(bundle);
        fragmentTransaction.add(R.id.myid,fragmentviewpager,null);
        fragmentTransaction.addToBackStack(null).commit();


                //adapter.notifyDataSetChanged();
               // txtcheck.setText("success");
                timer.cancel();
                tvXemdiem.setVisibility(View.VISIBLE);
                txtCkeckQues.setVisibility(View.VISIBLE);
                tvCkeck.setVisibility(View.GONE);
                dialog.dismiss();

            }
        }).setNegativeButton("Chưa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
        dialog.dismiss();

    }
});

        dialog.show();

    }



    public class CounterClass extends CountDownTimer {


        //millisInFuture: 60*1000
        //countDownInterval:  1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
            Toast.makeText(activityScreenViewpager.this,"Đã hết thời gian làm bài!",Toast.LENGTH_SHORT).show();
            tvXemdiem.setVisibility(View.VISIBLE);
            tvCkeck.setVisibility(View.GONE);

        }
    }
//    @Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }
//
//    /**
//     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
//     * sequence.
//     */
//    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
//        public ScreenSlidePagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return new Fragmentviewpager();
//        }
//
//        @Override
//        public int getCount() {
//            return NUM_PAGES;
//        }
//    }
//    public class DepthPageTransformer implements ViewPager.PageTransformer {
//        private static final float MIN_SCALE = 0.75f;
//
//        public void transformPage(View view, float position) {
//            int pageWidth = view.getWidth();
//
//            if (position < -1) { // [-Infinity,-1)
//                // This page is way off-screen to the left.
//                view.setAlpha(0f);
//
//            } else if (position <= 0) { // [-1,0]
//                // Use the default slide transition when moving to the left page
//                view.setAlpha(1f);
//                view.setTranslationX(0f);
//                view.setScaleX(1f);
//                view.setScaleY(1f);
//
//            } else if (position <= 1) { // (0,1]
//                // Fade the page out.
//                view.setAlpha(1 - position);
//
//                // Counteract the default slide transition
//                view.setTranslationX(pageWidth * -position);
//
//                // Scale the page down (between MIN_SCALE and 1)
//                float scaleFactor = MIN_SCALE
//                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
//                view.setScaleX(scaleFactor);
//                view.setScaleY(scaleFactor);
//
//            } else { // (1,+Infinity]
//                // This page is way off-screen to the right.
//                view.setAlpha(0f);
//            }
//        }
//    }
}
