package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Object.MKM;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.CHECKFOTP;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatMKMoi extends AppCompatActivity {
    private ImageButton DatMKMoiBack;
    private Button btDatMatKhauMoi;
    private EditText etMatKhauMoi,etRepeatMatKhauMoi;
    CHECKFOTP checkfotp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mkmoi);
        cnView();
    }
    private void cnView(){
        DatMKMoiBack=(ImageButton) findViewById(R.id.DatMKMoiBack);
        etMatKhauMoi=(EditText) findViewById(R.id.etMatKhauMoi);
        etRepeatMatKhauMoi=(EditText) findViewById(R.id.etRepeatMatKhauMoi);
        if (getIntent().getExtras() != null) {
            checkfotp= (CHECKFOTP) getIntent().getExtras().get("email-otp");
            Log.d("ALO0000000000000",checkfotp.getOtp());
        }
        DatMKMoiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), OTPVerification.class)});
            }
        });
        btDatMatKhauMoi=(Button) findViewById(R.id.btDatMatKhauMoi);
        btDatMatKhauMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MKM mkm=new MKM(checkfotp.getEmail().toString(),checkfotp.getOtp().toString(),etMatKhauMoi.getText().toString(),etRepeatMatKhauMoi.getText().toString());
                ApiService.apiService.postDoiMK(mkm).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                        Log.d("TB", message.getMessage().toString());
                        if(message.getMessage().toString().equals("Update successfull")==true){
                            startActivities(new Intent[]{new  Intent(getApplicationContext(), DatMKMoiTC.class)});
                        }
                        else {
                            Toast.makeText(DatMKMoi.this,message.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(DatMKMoi.this,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}