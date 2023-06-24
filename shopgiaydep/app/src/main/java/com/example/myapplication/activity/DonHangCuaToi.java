package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.DonHangAdapter;
import com.example.myapplication.Object.LIST_TTDH;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTDONHANG;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonHangCuaToi extends AppCompatActivity {
    private static final int MY_REQUEST_CODER = 10;
    public static TextView tvIDDH,tvTrangThai,tvNgayDat,tvHoTen,tvSDT,tvDiaChi,tvPTTT;
    public static Button btHuyDon;
    public static ImageButton DonHangBack;
    public ListView listView;
    public static List<TTDONHANG> ttdonhang;
    private DonHangAdapter donHangAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang_cua_toi);
        cnView();
        getDonHang();
        DonHangBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
    }

    private void getDonHang() {
        ApiService.apiService.getDonHang(TrangChu.accessToken).enqueue(new Callback<LIST_TTDH>() {
            @Override
            public void onResponse(Call<LIST_TTDH> call, Response<LIST_TTDH> response) {
                LIST_TTDH list_ttdh=response.body();
                ttdonhang=list_ttdh.getDonhang();
                setAdapterDonHang();
                Toast.makeText(DonHangCuaToi.this,"Call Api Success",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<LIST_TTDH> call, Throwable t) {
                Toast.makeText(DonHangCuaToi.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setAdapterDonHang() {
        donHangAdapter=new DonHangAdapter(this,ttdonhang);
        listView = (ListView) findViewById(R.id.lvDonHang);
        listView.setAdapter(donHangAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                TTDONHANG ttdonhang1 = (TTDONHANG) o;
                Intent intent=new Intent(DonHangCuaToi.this, CTDH.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_ctdh",ttdonhang1);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODER);
            }
        });
    }

    private void cnView() {
        tvIDDH=(TextView) findViewById(R.id.tvIDDH);
        tvTrangThai=(TextView) findViewById(R.id.tvTrangThai);
        tvNgayDat=(TextView) findViewById(R.id.tvNgayDat);
        tvHoTen=(TextView) findViewById(R.id.tvHoTen);
        tvSDT=(TextView) findViewById(R.id.tvSDT);
        tvDiaChi=(TextView) findViewById(R.id.tvDiaChi);
        tvPTTT=(TextView) findViewById(R.id.tvPTTT);
        btHuyDon=(Button) findViewById(R.id.btHuyDon);
        DonHangBack=(ImageButton) findViewById(R.id.DonHangBack);
    }
}