package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.Object.LIST_TB;
import com.example.myapplication.Object.TB;
import com.example.myapplication.R;
import com.example.myapplication.Adapter.ThongBaoAdapter;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongBao extends AppCompatActivity {
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;
    private static final int MY_REQUEST_CODE = 10;
    List<TB> thongbao;
    ThongBaoAdapter thongBaoAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        cnView();
        setEvent();
        getTB();
    }
    private void getTB() {
        ApiService.apiService.getTB().enqueue(new Callback<LIST_TB>() {
            @Override
            public void onResponse(Call<LIST_TB> call, Response<LIST_TB> response) {
                LIST_TB list_tb=response.body();
                thongbao=list_tb.getResult();
                setAdapterThongBao();
            }
            @Override
            public void onFailure(Call<LIST_TB> call, Throwable t) {

            }
        });
    }
    private void setAdapterThongBao() {
        thongBaoAdapter=new ThongBaoAdapter(this,thongbao);
        listView = (ListView) findViewById(R.id.lvThongBao);
        listView.setAdapter(thongBaoAdapter);
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
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
    }


    private void getGIOHANG() {
        ApiService.apiService.getGIOHANG(TrangChu.accessToken).enqueue(new Callback<LISTGIOHANG>() {
            @Override
            public void onResponse(Call<LISTGIOHANG> call, Response<LISTGIOHANG> response) {
                LISTGIOHANG listgiohang=response.body();
                Intent intent=new Intent(ThongBao.this, GioHang.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_giohang",listgiohang);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTGIOHANG> call, Throwable t) {
                Toast.makeText(ThongBao.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}