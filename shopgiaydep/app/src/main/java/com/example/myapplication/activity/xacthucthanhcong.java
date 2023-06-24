package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.activity.DangNhap;

public class xacthucthanhcong extends AppCompatActivity {
    private Button btVaoDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xacthucthanhcong);
        cnView();
    }
    private void cnView(){
        btVaoDangNhap=(Button) findViewById(R.id.btVaoDangNhap);
        btVaoDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DangNhap.class)});
            }
        });
    }
}