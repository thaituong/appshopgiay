package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.Object.ChiTietThongKe;
import com.example.myapplication.Object.LIST_TK;
import com.example.myapplication.Object.OTK;
import com.example.myapplication.R;
import com.example.myapplication.Adapter.ThongKeAdapter;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongKe extends AppCompatActivity {
    private static final int MY_REQUEST_CODER = 10;
    private static final int MY_REQUEST_CODE = 10;
    private Spinner spinner_nam,spinner_thang;
    ListView lvThongKe;
    String nam,thang;
    List<OTK> list;
    private Button btHTTK,btBieuDo;
    private TextView tvDangXuat;
    private ThongKeAdapter thongKeAdapter;
    String[] data_nam = {"2020", "2021", "2022", "2023", "2024"};
    String[] data_thang = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        cnView();
        setEvent();
        ArrayAdapter<String> adapter_nam = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data_nam);
        spinner_nam.setAdapter(adapter_nam);
        ArrayAdapter<String> adapter_thang = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data_thang);
        spinner_thang.setAdapter(adapter_thang);
    }

    private void setEvent() {
        spinner_nam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nam = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                nam = (String) parent.getItemAtPosition(0);
            }
        });
        spinner_thang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                thang = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                thang = (String) parent.getItemAtPosition(0);
            }
        });

        btHTTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTTTK();
            }
        });
        btBieuDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTTTKSBD();
            }
        });
        tvDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(), DangNhap.class)});
            }
        });
    }

    private void cnView() {
        spinner_nam=(Spinner)findViewById(R.id.spinner_nam);
        spinner_thang=(Spinner)findViewById(R.id.spinner_thang);
        btHTTK=(Button) findViewById(R.id.btHTTK);
        btBieuDo=(Button) findViewById(R.id.btBieuDo);
        tvDangXuat=(TextView) findViewById(R.id.tvDangXuat);
    }

    private void getTTTK() {
        ApiService.apiService.getTK(nam,thang).enqueue(new Callback<LIST_TK>() {
            @Override
            public void onResponse(Call<LIST_TK> call, Response<LIST_TK> response) {
                LIST_TK list_tk=response.body();
                list=list_tk.getResult();
                setAdapterThongKe();
            }
            @Override
            public void onFailure(Call<LIST_TK> call, Throwable t) {

            }
        });
    }
    private void getTTTKSBD() {
        ApiService.apiService.getTK(nam,thang).enqueue(new Callback<LIST_TK>() {
            @Override
            public void onResponse(Call<LIST_TK> call, Response<LIST_TK> response) {
                LIST_TK list_tk=response.body();
                Intent intent=new Intent(ThongKe.this, BieuDo.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list_tk",list_tk);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }
            @Override
            public void onFailure(Call<LIST_TK> call, Throwable t) {

            }
        });
    }
    private void setAdapterThongKe() {
        thongKeAdapter=new ThongKeAdapter(this,list);
        lvThongKe = (ListView) findViewById(R.id.lvThongKe);
        lvThongKe.setAdapter(thongKeAdapter);
        lvThongKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lvThongKe.getItemAtPosition(position);
                OTK tttk = (OTK) o;
                Intent intent=new Intent(ThongKe.this, ChiTietThongKe.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_cttk",tttk);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODER);
            }
        });
    }
}