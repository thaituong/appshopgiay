package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapplication.Object.NH;
import com.example.myapplication.R;
import com.example.myapplication.Adapter.ThuongHieuAdapter;

import java.util.List;

public class BoLoc extends AppCompatActivity {
    public GridView gridView;
    private TextView tvNhanHieu;
    private ThuongHieuAdapter thuonghieuAdapter;
    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_loc);
        tvNhanHieu=(TextView) findViewById(R.id.tvNhanHieu);
        List<NH> thuonghieu = TrangChu.thuonghieu;
        thuonghieuAdapter=new ThuongHieuAdapter(this,thuonghieu);
        gridView = (GridView) findViewById(R.id.gvItemThuongHieu);
        gridView.setAdapter(thuonghieuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                NH NH = (NH) o;
                tvNhanHieu.setText("Nhãn hiệu: "+ NH.getTENNHANHIEU().toUpperCase());
            }
        });
    }
}