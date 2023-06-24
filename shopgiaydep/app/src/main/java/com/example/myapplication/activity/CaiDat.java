package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.activity.CaNhan;

public class CaiDat extends AppCompatActivity {
    private Button btnApDungCaiDat;
    private ImageButton CaiDatBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);
        cnView();
        setEvent();
    }

    private void setEvent() {
        CaiDatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
    }

    private void cnView() {
        CaiDatBack=(ImageButton) findViewById(R.id.CaiDatBack);
        btnApDungCaiDat=(Button) findViewById(R.id.btnApDungCaiDat);
    }
}