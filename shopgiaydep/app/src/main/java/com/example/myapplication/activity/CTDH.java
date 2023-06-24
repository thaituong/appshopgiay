package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.Object.TTDONHANG;
import com.example.myapplication.Adapter.ThanhToanAdapter;

import java.util.List;

public class CTDH extends AppCompatActivity {
    public ListView listView;
    public static List<SPGIOHANG> spgiohangs;
    private ThanhToanAdapter ttspdhAdapter;
    TTDONHANG ttdonhang;
    public static ImageButton CTDHBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctdh);
        cnView();
        if(getIntent().getExtras().get("oj_ctdh")!=null){
            ttdonhang=(TTDONHANG) getIntent().getExtras().get("oj_ctdh");
            Log.d("TAG", ttdonhang.getIDDH());
        }
        spgiohangs=ttdonhang.getCT_DONHANGs();
        ttspdhAdapter=new ThanhToanAdapter(this,spgiohangs);
        listView.setAdapter(ttspdhAdapter);
        CTDHBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DonHangCuaToi.class)});
            }
        });
    }

    private void cnView() {
        listView=(ListView) findViewById(R.id.lvSPDonHang);
        CTDHBack=(ImageButton) findViewById(R.id.CTDHBack);
    }
}