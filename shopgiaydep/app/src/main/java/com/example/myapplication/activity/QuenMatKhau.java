package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Object.Email;
import com.example.myapplication.Object.OTP;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuenMatKhau extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private ImageButton QuenMKBack;
    private Button btnQuenMatKhau;
    private EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
        cnView();
    }
    private void cnView(){
        QuenMKBack=(ImageButton) findViewById(R.id.QuenMKBack);
        btnQuenMatKhau=(Button) findViewById(R.id.btnQuenMatKhau);
        etEmail=(EditText) findViewById(R.id.etEmail);
        QuenMKBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DangNhap.class)});
            }
        });
        btnQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email email=new Email(etEmail.getText().toString());
                Intent intent=new Intent(QuenMatKhau.this, OTPVerification.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("email",email);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
                ApiService.apiService.sendFOTP(email).enqueue(new Callback<OTP>() {
                    @Override
                    public void onResponse(Call<OTP> call, Response<OTP> response) {
                        OTP otp=response.body();
                        Toast.makeText(QuenMatKhau.this,"Call Api Success",Toast.LENGTH_LONG).show();
                        startActivities(new Intent[]{new  Intent(getApplicationContext(), OTPVerification.class)});
                    }

                    @Override
                    public void onFailure(Call<OTP> call, Throwable t) {
                        Toast.makeText(QuenMatKhau.this,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
    }
}