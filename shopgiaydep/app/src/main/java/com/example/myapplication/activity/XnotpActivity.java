package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.TTCN;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XnotpActivity extends AppCompatActivity {
    private ImageButton OtpBack;
    private Button btOtpSubmit;
    private TTCN ttcn;
    private EditText etOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xnotp);

        if (getIntent().getExtras() != null) {
            ttcn= (TTCN) getIntent().getExtras().get("oj_ttcn");
            Log.d("TAG",ttcn.getHoten().toString());
        }
        cnView();


        setEvent();
    }

    private void setEvent() {
        OtpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), RegisterActivity.class)});
            }
        });
        btOtpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttcn.setOtp(etOTP.getText().toString());
                ttcn.setDiachi("Thu Duc, HCM");
                sendTTDK();
            }
        });
    }

    private void sendTTDK() {
        ApiService.apiService.sendTTDK(ttcn).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message=response.body();
                Log.d("TB", message.getMessage().toString());
                if(message.getMessage().toString().equals("Create successfull")==true){
                    startActivities(new Intent[]{new  Intent(getApplicationContext(), xacthucthanhcong.class)});
                }
                else if(message.getMessage().toString().equals("Invalid OTP")==true){
                    Toast.makeText(XnotpActivity.this,"Invalid OTP",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(XnotpActivity.this,"Call Api Error",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void cnView(){
        etOTP=(EditText) findViewById(R.id.etOTP);
        OtpBack=(ImageButton) findViewById(R.id.OtpBack);
        btOtpSubmit=(Button) findViewById(R.id.btOtpSubmit);

    }
}