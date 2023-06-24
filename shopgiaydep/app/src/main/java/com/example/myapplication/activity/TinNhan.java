package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.R;
import com.example.myapplication.Object.TN;
import com.example.myapplication.Adapter.TinNhanAdapter;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TinNhan extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private EditText etTinNhan;
    private ImageButton btSend;
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;
    public static ArrayList<TN> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_nhan);
        cnView();
        if(list!=null){

        }else{
            list=getListData();
        }
        final ListView listView = (ListView) findViewById(R.id.lvTinNhan);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etTinNhan.length()>0) {
                    TN tn = new TN(Boolean.TRUE, etTinNhan.getText().toString().trim());
                    list.add(tn);
                    startActivities(new Intent[]{new Intent(getApplicationContext(), TinNhan.class)});
                }
            }
        });
        listView.setAdapter(new TinNhanAdapter(this,list));
        setEvent();
    }

    private void setEvent() {
        ibTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TrangChu.class)});
            }
        });
        ibThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), ThongBao.class)});
            }
        });
        ibTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TinNhan.class)});
            }
        });
        ibCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
        ibGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGIOHANG();
            }
        });
    }

    private void cnView() {
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        btSend=(ImageButton) findViewById(R.id.btSend);
        etTinNhan=(EditText) findViewById(R.id.etTinNhan);
    }
    private void getGIOHANG() {
        ApiService.apiService.getGIOHANG(TrangChu.accessToken).enqueue(new Callback<LISTGIOHANG>() {
            @Override
            public void onResponse(Call<LISTGIOHANG> call, Response<LISTGIOHANG> response) {
                LISTGIOHANG listgiohang=response.body();
                Intent intent=new Intent(TinNhan.this, GioHang.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_giohang",listgiohang);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTGIOHANG> call, Throwable t) {
                Toast.makeText(TinNhan.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }
    private  ArrayList<TN> getListData() {
        ArrayList<TN> list = new ArrayList<TN>();
        TN tn1 = new TN(Boolean.FALSE,"BANANA’S SHOP Cảm ơn bạn đã tin tưởng sử dụng " +
                "dịch vụ của shop. Chúng tôi có thể giúp gì cho bạn ?");
        TN tn2 = new TN(Boolean.TRUE,"Hi Shop.");
        TN tn3 = new TN(Boolean.TRUE,"Cho em hỏi bên mình còn Nike size 41 nữa không ạ ?");
        list.add(tn1);
        list.add(tn2);
        list.add(tn3);
        return list;
    }
}