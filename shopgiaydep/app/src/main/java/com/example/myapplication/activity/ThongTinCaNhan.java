package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Object.Message;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN_SUA;
import com.example.myapplication.Object.TT_CANHAN;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinCaNhan extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    public static TTCN_SUA ttcn;
    String gioitinh;
    private ImageButton ThongTinCaNhanBack;
    private EditText etTTCNHoTen,etTTCNSDT,etTTCNEmail,etTTCNNgaySinh;
    private RadioButton rbNam,rbNu;
    private Button btnTTCN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        cnView();
        etTTCNEmail.setEnabled(false);
        ApiService.apiService.getTT_CANHAN(TrangChu.accessToken).enqueue(new Callback<TT_CANHAN>() {
            @Override
            public void onResponse(Call<TT_CANHAN> call, Response<TT_CANHAN> response) {
                Toast.makeText(ThongTinCaNhan.this,"Call Api Success",Toast.LENGTH_LONG).show();
                TT_CANHAN tt_canhan=response.body();
                etTTCNHoTen.setText(tt_canhan.getTENNGUOIDUNG());
                etTTCNSDT.setText(tt_canhan.getSDT());
                etTTCNNgaySinh.setText(tt_canhan.getNGAYSINH());
                etTTCNEmail.setText(tt_canhan.getEMAIL());
                if (tt_canhan.getGIOITINH().equals("Nam")) {
                    rbNam.setChecked(true);
                } else {
                    rbNu.setChecked(true);
                }
            }

            @Override
            public void onFailure(Call<TT_CANHAN> call, Throwable t) {
                Toast.makeText(ThongTinCaNhan.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });

        setEvent();
    }

    private void setEvent() {
        ThongTinCaNhanBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
        btnTTCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbNam.isChecked()){
                    gioitinh="Nam";
                } else if(rbNu.isChecked()){
                    gioitinh="Nữ";
                }
                ttcn=new TTCN_SUA(etTTCNHoTen.getText().toString(),etTTCNNgaySinh.getText().toString(),etTTCNSDT.getText().toString(),gioitinh);
                ApiService.apiService.putTT_CANHAN(ttcn,TrangChu.accessToken).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Toast.makeText(ThongTinCaNhan.this,"Call Api Success",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(ThongTinCaNhan.this,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
                Intent intent=new Intent(ThongTinCaNhan.this,CaNhan.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_ttcn",ttcn);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }
        });
    }

    private void cnView() {
        ThongTinCaNhanBack=(ImageButton) findViewById(R.id.ThongTinCaNhanBack);
        etTTCNHoTen=(EditText) findViewById(R.id.etTTCNHoTen);
        etTTCNSDT=(EditText) findViewById(R.id.etTTCNSDT);
        etTTCNEmail=(EditText) findViewById(R.id.etTTCNEmail);
        etTTCNNgaySinh=(EditText) findViewById(R.id.etTTCNNgaySinh);
        btnTTCN=(Button) findViewById(R.id.btnTTCN);
        rbNam=(RadioButton) findViewById(R.id.rbNam);
        rbNu=(RadioButton) findViewById(R.id.rbNu);
    }
}