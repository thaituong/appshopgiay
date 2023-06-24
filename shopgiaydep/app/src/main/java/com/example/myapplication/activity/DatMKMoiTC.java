package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.activity.DangNhap;
import com.example.myapplication.activity.DatMKMoi;

public class DatMKMoiTC extends AppCompatActivity {
    private ImageButton DatMKMoiTCBack;
    private Button btVaoDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mkmoi_tc);
        cnView();
    }
    private void cnView(){
        DatMKMoiTCBack=(ImageButton) findViewById(R.id.DatMKMoiTCBack);
        DatMKMoiTCBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DatMKMoi.class)});
            }
        });
        btVaoDangNhap=(Button) findViewById(R.id.btVaoDangNhap);
        btVaoDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DangNhap.class)});
            }
        });
    }
}