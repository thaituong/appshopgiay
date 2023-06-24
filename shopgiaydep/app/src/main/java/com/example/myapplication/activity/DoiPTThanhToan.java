package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.example.myapplication.R;

public class DoiPTThanhToan extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private ImageButton DoiPTThanhToanBack;
    private Button btnDoiPTTT;
    RadioButton rbmomo,rbzalo,rbbanking,rbtienmat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_ptthanh_toan);
        cnView();
        setEvent();
    }

    private void setEvent() {
        DoiPTThanhToanBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoiPTThanhToan.this.onBackPressed();
            }
        });
        btnDoiPTTT.setOnClickListener(new View.OnClickListener() {
            String phuongthuc;
            @Override
            public void onClick(View view) {
                if (rbmomo.isChecked())
                {
                    phuongthuc="Thanh toán bằng MoMo";
                }
                else if (rbzalo.isChecked())
                {
                    phuongthuc="Thanh toán bằng ZaloPay";
                }
                else if (rbbanking.isChecked())
                {
                    phuongthuc="Thanh toán bằng Banking";
                }
                else if (rbtienmat.isChecked())
                {
                    phuongthuc="Thanh toán khi nhận hàng";
                }
                Intent intent=new Intent(DoiPTThanhToan.this, ThanhToan.class);
                intent.putExtra("pttt",phuongthuc);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }
        });
    }

    private void cnView() {
        DoiPTThanhToanBack=(ImageButton) findViewById(R.id.DoiPTThanhToanBack);
        btnDoiPTTT=(Button) findViewById(R.id.btnDoiPTTT);
        rbmomo=(RadioButton) findViewById(R.id.rbmomo);
        rbzalo=(RadioButton) findViewById(R.id.rbzalo);
        rbbanking=(RadioButton) findViewById(R.id.rbbanking);
        rbtienmat=(RadioButton) findViewById(R.id.rbtienmat);
    }
}