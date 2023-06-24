package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.Object.DiaChi;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN_NH;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoiDiaChi extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private EditText etDiaChiHoTen,etDiaChiSDT,etDiaChi;
    private ImageButton DoiDiaChiBack;
    private Button btnDoiDiaChi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_dia_chi);
        cnView();
        getTTCN();
        setEvent();
    }

    private void setEvent() {
        DoiDiaChiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoiDiaChi.this.onBackPressed();
            }
        });
        btnDoiDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }

    private void nextActivity() {
        String strHoTen=etDiaChiHoTen.getText().toString().trim();
        String strSDT=etDiaChiSDT.getText().toString().trim();
        String strDiaChi=etDiaChi.getText().toString().trim();

        DiaChi diachi=new DiaChi(strHoTen,strSDT,strDiaChi);
        Intent intent=new Intent(this, ThanhToan.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("obj_diachi",diachi);
        intent.putExtras(bundle);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }
    private void getTTCN() {
        ApiService.apiService.getTTCN(TrangChu.accessToken).enqueue(new Callback<TTCN_NH>() {
            @Override
            public void onResponse(Call<TTCN_NH> call, Response<TTCN_NH> response) {
                TTCN_NH ttcn_nh=response.body();
                etDiaChiHoTen.setText(ttcn_nh.getTENNGUOIDUNG());
                etDiaChiSDT.setText(ttcn_nh.getSDT());
                etDiaChi.setText(ttcn_nh.getDIACHI());
            }
            @Override
            public void onFailure(Call<TTCN_NH> call, Throwable t) {

            }
        });
    }

    private void cnView() {
        DoiDiaChiBack=(ImageButton) findViewById(R.id.DoiDiaChiBack);
        etDiaChiHoTen=(EditText) findViewById(R.id.etDiaChiHoTen);
        etDiaChiSDT=(EditText) findViewById(R.id.etDiaChiSDT);
        etDiaChi=(EditText) findViewById(R.id.etDiaChi);
        btnDoiDiaChi=(Button) findViewById(R.id.btnDoiDiaChi);
    }
}