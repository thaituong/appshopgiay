package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Object.CHECKFOTP;
import com.example.myapplication.Object.Email;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.OTP;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPVerification extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private ImageButton OtpverificationBack;
    private EditText etvOTP;
    private Button btOtpVSubmit;
    public static Email email;
    public OTP otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        cnView();
    }
    private void cnView(){

        etvOTP=(EditText) findViewById(R.id.etvOTP);
        OtpverificationBack=(ImageButton) findViewById(R.id.OtpverificationBack);
        if (getIntent().getExtras() != null) {
            email= (Email) getIntent().getExtras().get("email");
            Log.d("ALO0000000000000",email.getEmail());
        }
        OtpverificationBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), QuenMatKhau.class)});
            }
        });
        btOtpVSubmit=(Button) findViewById(R.id.btOtpVSubmit);
        btOtpVSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CHECKFOTP checkfotp=new CHECKFOTP(email.getEmail().toString(),etvOTP.getText().toString());
                ApiService.apiService.checkFOTP(checkfotp).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                        Log.d("TB", message.getMessage().toString());
                        if(message.getMessage().toString().equals("success")==true){
                            Intent intent=new Intent(OTPVerification.this, DatMKMoi.class);
                            Bundle bundle=new Bundle();
                            bundle.putSerializable("email-otp",checkfotp);
                            intent.putExtras(bundle);
                            startActivityForResult(intent,MY_REQUEST_CODE);
                        }
                        else {
                            Toast.makeText(OTPVerification.this,"Invalid OTP",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(OTPVerification.this,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}