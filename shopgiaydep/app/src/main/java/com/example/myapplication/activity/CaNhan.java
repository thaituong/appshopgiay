package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN_NH;
import com.example.myapplication.Object.TTCN_SUA;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CaNhan extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;

    private ImageView nextThongTinCaNhan,nextDiaChiNhanHang,nextCaiDat,nextDonHangCuaToi;
    private TextView tvTenUser,tvDangXuat;
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);
        cnView();
        setEvent();
        getTTCN();
        if (getIntent().getExtras() != null) {
            TTCN_SUA ttcn= (TTCN_SUA) getIntent().getExtras().get("oj_ttcn");
            tvTenUser.setText(ttcn.getTennguoidung());
        }
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
        nextThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), ThongTinCaNhan.class)});
            }
        });
        nextDiaChiNhanHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DiaChiNhanHang.class)});
            }
        });
        nextDonHangCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DonHangCuaToi.class)});
            }
        });
        nextCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaiDat.class)});
            }
        });
        tvDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DangNhap.class)});
            }
        });
    }
    private void getGIOHANG() {
        ApiService.apiService.getGIOHANG(TrangChu.accessToken).enqueue(new Callback<LISTGIOHANG>() {
            @Override
            public void onResponse(Call<LISTGIOHANG> call, Response<LISTGIOHANG> response) {
                LISTGIOHANG listgiohang=response.body();
                Intent intent=new Intent(CaNhan.this, GioHang.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_giohang",listgiohang);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTGIOHANG> call, Throwable t) {
                Toast.makeText(CaNhan.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getTTCN() {
        ApiService.apiService.getTTCN(TrangChu.accessToken).enqueue(new Callback<TTCN_NH>() {
            @Override
            public void onResponse(Call<TTCN_NH> call, Response<TTCN_NH> response) {
                TTCN_NH ttcn_nh=response.body();
                tvTenUser.setText(ttcn_nh.getTENNGUOIDUNG());
            }
            @Override
            public void onFailure(Call<TTCN_NH> call, Throwable t) {

            }
        });
    }
    private void cnView() {
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
        nextThongTinCaNhan=(ImageView) findViewById(R.id.nextThongTinCaNhan);
        nextDiaChiNhanHang=(ImageView) findViewById(R.id.nextDiaChiNhanHang);
        nextDonHangCuaToi=(ImageView) findViewById(R.id.nextDonHangCuaToi);
        nextCaiDat=(ImageView) findViewById(R.id.nextCaiDat);
        tvTenUser=(TextView) findViewById(R.id.tvTenUser);
        tvDangXuat=(TextView) findViewById(R.id.tvDangXuat);
    }
}