package com.example.myapplication.Object;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.Adapter.CTTKAdapter;
import com.example.myapplication.R;

import java.util.List;

public class ChiTietThongKe extends AppCompatActivity {
    ListView lvCTTK;
    List<CTTK> cttk;
    CTTKAdapter cttkAdapter;
    OTK otk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thong_ke);
        cnView();
        if(getIntent().getExtras().get("oj_cttk")!=null){
            otk=(OTK) getIntent().getExtras().get("oj_cttk");
        }

            cttk=otk.getCT();
            cttkAdapter=new CTTKAdapter(this,cttk);
            lvCTTK.setAdapter(cttkAdapter);


    }

    private void cnView() {
        lvCTTK=(ListView) findViewById(R.id.lvCTTK);
    }
}