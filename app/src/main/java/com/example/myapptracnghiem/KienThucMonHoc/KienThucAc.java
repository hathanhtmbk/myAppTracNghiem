package com.example.myapptracnghiem.KienThucMonHoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapptracnghiem.R;
import com.example.myapptracnghiem.question.Question;
import com.example.myapptracnghiem.question.QuestionAdapter;
import com.example.myapptracnghiem.viewpager.activityScreenViewpager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class KienThucAc extends AppCompatActivity {

    String urlGetData="http://192.168.1.147/android_BC/getNguyenTo.php";
    RecyclerView KTrcView;
    ArrayList<nguyenTo> nguyenTos;

    nguyenToAdapter nguyentoadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kien_thuc);
        KTrcView=findViewById(R.id.ktRecyc);
        nguyenTos=new ArrayList<>();
        nguyentoadapter=new nguyenToAdapter(KienThucAc.this, nguyenTos);
        LinearLayoutManager manager=new LinearLayoutManager(KienThucAc.this,LinearLayoutManager.VERTICAL,false);
        KTrcView.setLayoutManager(manager);
        KTrcView.setAdapter(nguyentoadapter);
        GetData(urlGetData);
    }
    public void GetData(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){


                    try {
                        JSONObject object=response.getJSONObject(i);


                            //Toast.makeText(activityScreenViewpager.this,"Bắt đầu làm bài",Toast.LENGTH_SHORT).show();
                            nguyenTos.add(new nguyenTo(

                                    object.getInt("id"),
                                   object.getString("ten"),
                                    object.getString("kiHieu"),
                                    object.getInt("soHieuNgTu"),
                                    object.getInt("ngTuKhoiTB"),
                                    object.getInt("doAmDien"),
                                    object.getString("soOxiHoa")

                            ));

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
                Toast.makeText(KienThucAc.this,"lỗi",Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
