package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Object.DN;
import com.example.myapplication.Object.Message;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhap extends AppCompatActivity {
    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";

    public static final String KEY_USER_FROM_REGISTER = "KEY_USER_FROM_REGISTER";

    public static final int REQUEST_CODE_REGISTER = 1;
    private static final int MY_REQUEST_CODER = 10;

    private Context context;
    private TextView tvQuenMatKhau,tvDangky;
    private static final int MY_REQUEST_CODE = 10;
    private ImageView ivGG,ivFB;
    private EditText etEmail,etPassword;
    private Button btDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        cnView();
        setEvent();
    }

    private void setEvent() {
        tvDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), RegisterActivity.class)});
            }
        });
        tvQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), QuenMatKhau.class)});
            }
        });
        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etEmail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    startActivities(new Intent[]{new  Intent(getApplicationContext(), ThongKe.class)});
                }
                else{
                    DN dn=new DN(etEmail.getText().toString(),etPassword.getText().toString());
                    sendDN(dn);
                }

            }
        });
    }



    private void sendDN(DN dn) {
        ApiService.apiService.sendDN(dn).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message=response.body();
                if(message.getMessage().toString().equals("Logged in")==true){
                    String accessToken=message.getData().getAccessToken();
                    Intent intent=new Intent(DangNhap.this, TrangChu.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("accessToken",accessToken);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,MY_REQUEST_CODER);
                }
                else {
                    Toast.makeText(DangNhap.this,message.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(DangNhap.this,"Call Api Error",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void cnView(){
        tvDangky = (TextView) findViewById(R.id.tvDangKy);
        tvQuenMatKhau = (TextView) findViewById(R.id.tvQuenMatKhau);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btDangNhap = (Button) findViewById(R.id.btDangNhap);
        ivGG = (ImageView) findViewById(R.id.ivIconGG);
        ivFB = (ImageView) findViewById(R.id.ivIconFB);
    }

}