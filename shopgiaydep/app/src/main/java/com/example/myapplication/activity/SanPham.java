package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapter.NutAdapter;
import com.example.myapplication.Adapter.NutSizeAdapter;
import com.example.myapplication.Object.CTSP;
import com.example.myapplication.Object.CT_MAUSAC;
import com.example.myapplication.Object.CT_MAUSACs;
import com.example.myapplication.Object.CT_SP;
import com.example.myapplication.Object.KICHTHUOC;
import com.example.myapplication.Object.KICHTHUOCs;
import com.example.myapplication.Object.MAUSAC;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.POSTSPGH;
import com.example.myapplication.R;
import com.example.myapplication.Object.SP;
import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.api.ApiService;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPham extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    private ImageButton SanPhamBack;
    private Button btTangSP,btGiamSP,size39,size40,size41,size42,btMuaNgay,btThenVaoGioHang;
    private Button mau_xanh,mau_den,mau_trang,mau_do;
    private TextView tvSLSanPham,tvTongTien,tv_TenSP,tv_GiaSP,tv_SoLuongBan,tvMoTa;
    private ImageView iv_AnhSP;
    public String size,mausac,soluong,mamau,hinh;
    public int idsp,idms,idkt,sl=1,kichthuoc,soluongton;
    CT_SP ctsp;

    public int counter,counter1,prevPosition1,prevPosition,currentPosition,currentPosition1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        counter=0;
        counter1=0;
        cnView();
        setEvent();

        if(getIntent().getExtras()!=null){
            ctsp= (CT_SP) getIntent().getExtras().get("oj_sanpham");}
            tv_TenSP.setText(ctsp.getTENSANPHAM());
            Picasso.get().load(ctsp.getCT_MAUSACs().get(0).getHINHANH()).into(iv_AnhSP);
            Float giasp=Float.parseFloat(ctsp.getGIA());
            DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
            tv_GiaSP.setText(decimalFormat.format(giasp)+" Đ");
            tv_SoLuongBan.setText("Đã bán ");
            tvMoTa.setText(ctsp.getMOTA());
            idsp=ctsp.getIDSP();
            tvTongTien.setText(decimalFormat.format(giasp)+" Đ");
            final GridView gridView = (GridView) findViewById(R.id.gvItemMauSac);
            gridView.setAdapter(new NutAdapter(this, ctsp.getCT_MAUSACs()));
            // When the user clicks on the GridItem
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    if(counter==0) {
                        prevPosition = position;
                    }
                    else if (counter ==1) {
                        currentPosition = position;
                    }
                    else {
                        prevPosition = currentPosition;
                        currentPosition = position;
                    }
                    gridView.getChildAt(prevPosition).setBackgroundColor(Color.TRANSPARENT);
                    v.setBackgroundResource(R.drawable.bttronsizexanh);
                    counter++;
                Object o = gridView.getItemAtPosition(position);
                CT_MAUSACs ctms = (CT_MAUSACs) o;
                Picasso.get().load(ctms.getHINHANH()).into(iv_AnhSP);
                idms=ctms.getIDMS();
                mausac=ctms.getMAU();
                mamau=ctms.getMAMAU();
                hinh=ctms.getHINHANH();
                final GridView gvkt = (GridView) findViewById(R.id.gvItemSize);
                gvkt.setAdapter(new NutSizeAdapter(SanPham.this, ctms.getCT_KICHTHUOCs()));
                gvkt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        if(counter1==0) {
                            prevPosition1 = position;
                        }
                        else if (counter1 ==1) {
                            currentPosition1 = position;
                        }
                        else {
                            prevPosition1 = currentPosition1;
                            currentPosition1 = position;
                        }
                        gvkt.getChildAt(prevPosition1).setBackgroundColor(Color.TRANSPARENT);
                        v.setBackgroundResource(R.drawable.bttronsizexanh);
                        counter1++;
                        Object o = gvkt.getItemAtPosition(position);
                        KICHTHUOCs kts = (KICHTHUOCs) o;
                        idkt=kts.getIDKT();
                        soluongton=kts.getSOLUONGTON();

                        kichthuoc=kts.getSIZE();
                        tv_SoLuongBan.setText("Đã bán: "+kts.getSOLUONGDABAN());
                    }
                });

                }
            });

            btThenVaoGioHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(soluongton<sl){
                        Toast.makeText(SanPham.this,"Chỉ còn "+soluongton+" sản phẩm",Toast.LENGTH_LONG).show();
                    } else{
                        Log.d("ALO", idsp+" "+idms+" "+idkt+" "+sl);
                        POSTSPGH postspgh=new POSTSPGH(idsp,idms,idkt,sl);
                        ApiService.apiService.sendSPGH(postspgh, TrangChu.accessToken).enqueue(new Callback<Message>() {
                            @Override
                            public void onResponse(Call<Message> call, Response<Message> response) {
                                Toast.makeText(SanPham.this,"Thêm vào giỏ hàng thành công",Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onFailure(Call<Message> call, Throwable t) {
                                Toast.makeText(SanPham.this,"Call Api Error",Toast.LENGTH_LONG).show();
                            }
                        });
                    }


                }
            });
            btMuaNgay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(soluongton<sl){
                        Toast.makeText(SanPham.this,"Chỉ còn "+soluongton+" sản phẩm",Toast.LENGTH_LONG).show();
                    } else{
                        setEventMuaNgay();
                    }
                }
            });

        }
    private int getMipmapResIdByName(String hinhSP) {
        String pkgName = this.getPackageName();
        int resID = this.getResources().getIdentifier(hinhSP , "mipmap", pkgName);
        Log.i("myapplication", "Res Name: "+ hinhSP+"==> Res ID = "+ resID);
        return resID;
    }
    private void setEventGioHang(String tensp,String giasp,String slbsp,int anhsp,String size,String mausac,String soluong) {
        Intent intent=new Intent(SanPham.this, GioHang.class);
        Bundle bundle=new Bundle();
        CTSP ctsp=new CTSP(tensp,anhsp,giasp,size,mausac,soluong);
        bundle.putSerializable("oj_ctsp",ctsp);
        intent.putExtras(bundle);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }
    private void setEventMuaNgay() {
        SP sp=new SP();
        sp.setTENSANPHAM(ctsp.getTENSANPHAM());
        sp.setGIA(ctsp.getGIA());
        sp.setIDSP(idsp);

        MAUSAC mausac1=new MAUSAC(idms,mausac,mamau);

        KICHTHUOC kichthuoc1=new KICHTHUOC(idkt,kichthuoc);

        SPGIOHANG spgiohang=new SPGIOHANG();
        spgiohang.setSOLUONG(sl);
        spgiohang.setKICHTHUOC(kichthuoc1);
        spgiohang.setMAUSAC(mausac1);
        spgiohang.setSANPHAM(sp);
        CT_MAUSAC ct_mausac=new CT_MAUSAC();
        ct_mausac.setHINHANH(hinh);
        spgiohang.setCT_MAUSAC(ct_mausac);

        Intent intent=new Intent(SanPham.this, ThanhToan.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("ctsp",spgiohang);
        intent.putExtras(bundle);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }

    private void cnView(){
        SanPhamBack=(ImageButton) findViewById(R.id.SanPhamBack);
        btTangSP=(Button) findViewById(R.id.btTangSP);
        btMuaNgay=(Button)findViewById(R.id.btMuaNgay);
        btGiamSP=(Button) findViewById(R.id.btGiamSP);
        tvSLSanPham=(TextView) findViewById(R.id.tvSLSanPham);
        tvTongTien=(TextView) findViewById(R.id.tvTongTien);
        tv_TenSP=(TextView) findViewById(R.id.tv_TenSP);
        tv_GiaSP=(TextView) findViewById(R.id.tv_GiaSP);
        tv_SoLuongBan=(TextView) findViewById(R.id.tv_SoLuongBan);
        tvMoTa=(TextView) findViewById(R.id.tvMoTa);
        iv_AnhSP=(ImageView) findViewById(R.id.iv_AnhSP);
        btThenVaoGioHang=(Button) findViewById(R.id.btThenVaoGioHang);
    }
    private void setEvent(){
        SanPhamBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham.this.onBackPressed();
            }
        });
        if(Integer.parseInt(tvSLSanPham.getText().toString())==1){
            btGiamSP.setEnabled(false);
        }
        btTangSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer kq=Integer.parseInt(tvSLSanPham.getText().toString())+1;
                Float tt=Float.parseFloat(ctsp.getGIA())*kq;
                tvSLSanPham.setText(kq+"");
                soluong=tvSLSanPham.getText().toString().trim();
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                tvTongTien.setText(decimalFormat.format(tt)+" Đ");
                sl=kq;
                btGiamSP.setEnabled(true);
            }
        });

        btGiamSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer kq=Integer.parseInt(tvSLSanPham.getText().toString())-1;
                if(kq==1){
                    btGiamSP.setEnabled(false);
                }
                Float tt=Float.parseFloat(ctsp.getGIA())*kq;
                tvSLSanPham.setText(kq+"");
                soluong=tvSLSanPham.getText().toString().trim();
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                tvTongTien.setText(decimalFormat.format(tt)+" Đ");
                sl=kq;

            }
        });

    }

}