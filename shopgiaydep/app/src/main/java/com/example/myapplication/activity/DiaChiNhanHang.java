package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.DiaChi;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN_NH;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiaChiNhanHang extends AppCompatActivity {
    private EditText etDCNHHoTen,etDCNHSDT,etDCNHDiaChi;
    private Button btnLuuDCNH;
    private ImageButton DCNHBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi_nhan_hang);
        cnView();
        getTTCN();
        setEvent();
    }

    private void setEvent() {
        DCNHBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
        btnLuuDCNH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiaChi diaChi=new DiaChi(etDCNHDiaChi.getText().toString());
                ApiService.apiService.putTT_DC(diaChi, TrangChu.accessToken).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                        Log.d("TAG", message+"");
                        Toast.makeText(DiaChiNhanHang.this,"Call Api Success",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(DiaChiNhanHang.this,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void cnView() {
        etDCNHHoTen=(EditText) findViewById(R.id.etDCNHHoTen);
        etDCNHSDT=(EditText) findViewById(R.id.etDCNHSDT);
        etDCNHDiaChi=(EditText) findViewById(R.id.etDCNHDiaChi);
        btnLuuDCNH=(Button) findViewById(R.id.btnLuuDCNH);
        DCNHBack=(ImageButton) findViewById(R.id.DCNHBack);
    }
    private void getTTCN() {
        ApiService.apiService.getTTCN(TrangChu.accessToken).enqueue(new Callback<TTCN_NH>() {
            @Override
            public void onResponse(Call<TTCN_NH> call, Response<TTCN_NH> response) {
                TTCN_NH ttcn_nh=response.body();
                etDCNHHoTen.setText(ttcn_nh.getTENNGUOIDUNG());
                etDCNHSDT.setText(ttcn_nh.getSDT());
                etDCNHDiaChi.setText(ttcn_nh.getDIACHI());
            }
            @Override
            public void onFailure(Call<TTCN_NH> call, Throwable t) {

            }
        });
    }
}