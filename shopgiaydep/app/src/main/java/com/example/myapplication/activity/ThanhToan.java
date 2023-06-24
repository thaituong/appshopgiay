package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.DH;
import com.example.myapplication.Object.DiaChi;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.POSTSPGH;
import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN_NH;
import com.example.myapplication.Adapter.ThanhToanAdapter;
import com.example.myapplication.api.ApiService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThanhToan extends AppCompatActivity {
    public static ArrayList<SPGIOHANG> list;
    ArrayList<POSTSPGH> postspghs=new ArrayList<>();
    private ImageButton ThanhToanBack,ibDoiDiaChi,ibDoiPTThanhToan;
    private Float tongthanhtoan= Float.valueOf(0);
    private Button btnDatHang;
    private TextView tvDiaChi,tvSDT,tvHoTen,tvTongTien,tvPTTT,tvEmail,tvTTH,tvTTT;
    public List<String> strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        cnView();
        setEvent();
        getTTCN();
        Log.d("TAG", "onCreate: ");


        final ListView listView = (ListView) findViewById(R.id.lvThanhToan);
        if(getIntent().getExtras().get("ctsp")!=null){
            SPGIOHANG spgiohang= (SPGIOHANG) getIntent().getExtras().get("ctsp");
            list=new ArrayList<>();
            list.add(spgiohang);
        }
        if(getIntent().getExtras().get("list_ctsp")!=null){
            list=new ArrayList<>();
            list= (ArrayList) getIntent().getExtras().get("list_ctsp");
        }

        if(getIntent().getExtras().get("pttt")!=null){
            String pttt=(String) getIntent().getExtras().get("pttt");
            tvPTTT.setText(pttt);
        }
        for(int i=0;i<list.size();i++){
            tongthanhtoan=tongthanhtoan+Float.parseFloat(list.get(i).getSANPHAM().getGIA())*list.get(i).getSOLUONG();
        }
        listView.setAdapter(new ThanhToanAdapter(this,list));
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        tvTongTien.setText(decimalFormat.format(tongthanhtoan)+" Đ");
        tvTTH.setText(decimalFormat.format(tongthanhtoan)+" Đ");
        tvTTT.setText(decimalFormat.format(tongthanhtoan)+" Đ");
        strings = new ArrayList<String>(list.size());
        for(int i=0;i<list.size();i++){
            POSTSPGH p=new POSTSPGH(list.get(i).getSANPHAM().getIDSP(),list.get(i).getMAUSAC().getIDMS(),list.get(i).getKICHTHUOC().getIDKT(),list.get(i).getSOLUONG());
            postspghs.add(p);
            Log.d("ALO"+i, postspghs.get(i).getIDSP()+"");
            strings.add(p != null ? p.toString() : null);
        }
        Log.d("ALO", strings.toString());
    }

    private void setEvent() {
        ThanhToanBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThanhToan.this.onBackPressed();
            }
        });
        ibDoiDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DoiDiaChi.class)});
            }
        });
        ibDoiPTThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DoiPTThanhToan.class)});
            }
        });
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDonHang();
            }
        });
    }

    private void postDonHang() {
        DH dh=new DH(tvDiaChi.getText().toString(),tvHoTen.getText().toString(),tvSDT.getText().toString(),tvEmail.getText().toString(),tvPTTT.getText().toString(),strings.toString());
        ApiService.apiService.postDonHang(dh, TrangChu.accessToken).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(ThanhToan.this,"Đặt hàng thành công",Toast.LENGTH_LONG).show();
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TrangChu.class)});
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(ThanhToan.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getTTCN() {
        if(getIntent().getExtras().get("obj_diachi")!=null){
            DiaChi diachi= (DiaChi) getIntent().getExtras().get("obj_diachi");
            tvHoTen.setText(diachi.getHoten());
            tvSDT.setText(diachi.getSdt());
            tvDiaChi.setText(diachi.getDiachi());
        }else{
            ApiService.apiService.getTTCN(TrangChu.accessToken).enqueue(new Callback<TTCN_NH>() {
                @Override
                public void onResponse(Call<TTCN_NH> call, Response<TTCN_NH> response) {
                    TTCN_NH ttcn_nh=response.body();
                    tvHoTen.setText(ttcn_nh.getTENNGUOIDUNG());
                    tvSDT.setText(ttcn_nh.getSDT());
                    tvDiaChi.setText(ttcn_nh.getDIACHI());
                    tvEmail.setText(ttcn_nh.getEMAIL());
                }

                @Override
                public void onFailure(Call<TTCN_NH> call, Throwable t) {

                }
            });
        }

    }
    private void cnView() {
        ThanhToanBack=(ImageButton) findViewById(R.id.ThanhToanBack);
        ibDoiDiaChi=(ImageButton) findViewById(R.id.ibDoiDiaChi);
        ibDoiPTThanhToan=(ImageButton)findViewById(R.id.ibDoiPTThanhToan);
        tvDiaChi=(TextView) findViewById(R.id.tvDiaChi);
        tvHoTen=(TextView) findViewById(R.id.tvHoTen);
        tvTTH=(TextView) findViewById(R.id.tvTTH);
        tvTTT=(TextView)findViewById(R.id.tvTTT);
        tvSDT=(TextView) findViewById(R.id.tvSDT);
        tvEmail=(TextView)findViewById(R.id.tvEmail);
        tvTongTien=(TextView) findViewById(R.id.tvTongTien);
        tvPTTT=(TextView) findViewById(R.id.tvPTTT);
        btnDatHang=(Button) findViewById(R.id.btnDatHang);
    }

}