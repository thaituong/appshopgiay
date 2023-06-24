package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.Email;
import com.example.myapplication.Object.OTP;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTCN;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private TextView selection;
    private Context context;
    private static final int MY_REQUEST_CODE = 10;
    private TTCN ttcn;
    private Button btnRegister;
    String gioitinh;
    private EditText etRgHoTen,etRgDate,etRgSDT,etRgEmail,etRgPassword,etRgRePassword;
    private RadioButton rbRgNam,rbRgNu;
    private ImageButton RgBack;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        cnView();
        setEvent();
    }

    private void setEvent() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbRgNam.isChecked()){
                    gioitinh="Nam";
                } else if(rbRgNu.isChecked()){
                    gioitinh="Nữ";
                }
                ttcn=new TTCN(etRgHoTen.getText().toString(),etRgDate.getText().toString(),etRgSDT.getText().toString(),gioitinh,etRgEmail.getText().toString(),etRgPassword.getText().toString(),etRgRePassword.getText().toString());
                Intent intent=new Intent(RegisterActivity.this, XnotpActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_ttcn",ttcn);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
                sendOTP();
            }
        });
        RgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), DangNhap.class)});
            }
        });
    }

    private void sendOTP() {
        Email email=new Email(etRgEmail.getText().toString());
        ApiService.apiService.sendOTP(email).enqueue(new Callback<OTP>() {
            @Override
            public void onResponse(Call<OTP> call, Response<OTP> response) {
                OTP otp=response.body();
                Toast.makeText(RegisterActivity.this,"Call Api Success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<OTP> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Call Api Error",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void cnView(){
        btnRegister=(Button) findViewById(R.id.btnRegister);
        RgBack=(ImageButton) findViewById(R.id.RgBack);
        etRgHoTen=(EditText) findViewById(R.id.etRgHoTen);
        etRgDate=(EditText) findViewById(R.id.etRgDate);
        etRgSDT=(EditText) findViewById(R.id.etRgSDT);
        etRgEmail=(EditText) findViewById(R.id.etRgEmail);
        etRgPassword=(EditText) findViewById(R.id.etRgPassword);
        etRgRePassword=(EditText) findViewById(R.id.etRgRePassword);
        rbRgNam=(RadioButton) findViewById(R.id.rbRgNam);
        rbRgNu=(RadioButton) findViewById(R.id.rbRgNu);
    }


}