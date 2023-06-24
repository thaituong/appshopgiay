package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.SanPhamAdapter;
import com.example.myapplication.Object.CT_SP;
import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.Object.LISTSP;
import com.example.myapplication.Object.LIST_CT_SP;
import com.example.myapplication.R;
import com.example.myapplication.Object.SP;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SieuKhuyenMai extends AppCompatActivity {
    private static final int MY_REQUEST_CODER = 10;
    private static final int MY_REQUEST_CODE = 10;
    private ImageButton SieuKMBack,ibLocSP;
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;

    private TextView tvtieude;
    LISTSP listsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sieu_khuyen_mai);
        cnView();
        setEvent();
        List<SP> sanpham=new ArrayList<>();


        if (getIntent().getExtras() != null) {
            listsp = (LISTSP) getIntent().getExtras().get("list_spskm");

            if(listsp!=null){
                sanpham=listsp.getResult();
                tvtieude.setText("SIÊU KHUYẾN MÃI");
            }

        }
        if (getIntent().getExtras() != null) {
            listsp = (LISTSP) getIntent().getExtras().get("list_spm");

            if(listsp!=null){
                sanpham=listsp.getResult();
                tvtieude.setText("SẢN PHẨM MỚI");
            }
        }
        if (getIntent().getExtras() != null) {
            listsp = (LISTSP) getIntent().getExtras().get("list_spbc");

            if(listsp!=null){
                sanpham=listsp.getResult();
                tvtieude.setText("SẢN PHẨM BÁN CHẠY");
            }
        }

        final GridView gridView = (GridView) findViewById(R.id.gvSanPham);
        gridView.setAdapter(new SanPhamAdapter(this, sanpham));
        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Object o = gridView.getItemAtPosition(position);
                SP sp = (SP) o;
                getCTSP(sp.getIDSP());
//                Intent intent=new Intent(SieuKhuyenMai.this,SanPham.class);
//                Bundle bundle=new Bundle();
////                int imageId = getMipmapResIdByName(sp.getHinhSP());
//                bundle.putSerializable("oj_sanpham",sp);
//                intent.putExtras(bundle);
//                startActivityForResult(intent,MY_REQUEST_CODER);

            }
        });


    }

    private void getCTSP(int i) {
        ApiService.apiService.getCTSP(i).enqueue(new Callback<LIST_CT_SP>() {
            @Override
            public void onResponse(Call<LIST_CT_SP> call, Response<LIST_CT_SP> response) {
                LIST_CT_SP listCtSp=response.body();
                CT_SP ctsp= (CT_SP) listCtSp.getResult();
                Intent intent=new Intent(SieuKhuyenMai.this, SanPham.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_sanpham",ctsp);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODER);

            }

            @Override
            public void onFailure(Call<LIST_CT_SP> call, Throwable t) {
                Toast.makeText(SieuKhuyenMai.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }


        });
    }

    private void cnView(){
        SieuKMBack=(ImageButton) findViewById(R.id.SieuKMBack);
        tvtieude=(TextView) findViewById(R.id.tvtieude);
        ibLocSP=(ImageButton)findViewById(R.id.ibLocSP);
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
    }
    private void getGIOHANG() {
        ApiService.apiService.getGIOHANG(TrangChu.accessToken).enqueue(new Callback<LISTGIOHANG>() {
            @Override
            public void onResponse(Call<LISTGIOHANG> call, Response<LISTGIOHANG> response) {
                LISTGIOHANG listgiohang=response.body();
                Intent intent=new Intent(SieuKhuyenMai.this, GioHang.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_giohang",listgiohang);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTGIOHANG> call, Throwable t) {
                Toast.makeText(SieuKhuyenMai.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setEvent(){
        ibTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TrangChu.class)});
            }
        });
        ibThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), ThongBao.class)});
            }
        });
        ibTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TinNhan.class)});
            }
        });
        ibCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), CaNhan.class)});
            }
        });
        ibGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGIOHANG();
            }
        });
        SieuKMBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), TrangChu.class)});
            }
        });
        ibLocSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), BoLoc.class)});
            }
        });
    }
    private int getMipmapResIdByName(String hinhSP) {
        String pkgName = this.getPackageName();

        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(hinhSP , "mipmap", pkgName);
        Log.i("myapplication", "Res Name: "+ hinhSP+"==> Res ID = "+ resID);
        return resID;
    }

//    public static   List<SP> getListDataSKM() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("Air Jordan 1","giay1","685000","999");
//        SP sp2 = new SP("Air Jordan 1 Mid SE","giay2","885000","999");
//        SP sp3 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp4 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp5 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//
//        list.add(sp1);
//        list.add(sp2);
//        list.add(sp3);
//        list.add(sp4);
//        list.add(sp5);
//
//        return list;
//    }
//    public static  List<SP> getListDataSPBC() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("Air Jordan 2","giay1","885000","999");
//        SP sp2 = new SP("Air Jordan 1 Mid SE","giay2","885000","999");
//        SP sp3 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp4 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp5 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//
//        list.add(sp1);
//        list.add(sp2);
//        list.add(sp3);
//        list.add(sp4);
//        list.add(sp5);
//
//        return list;
//    }
//    private  List<SP> getListDataSPM() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("Air Jordan 3","giay1","985000","999");
//        SP sp2 = new SP("Air Jordan 1 Mid SE","giay2","885000","999");
//        SP sp3 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp4 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//        SP sp5 = new SP("Air Jordan 1 Mid SE","giay1","685000","999");
//
//        list.add(sp1);
//        list.add(sp2);
//        list.add(sp3);
//        list.add(sp4);
//        list.add(sp5);
//
//        return list;
//    }
//    private  List<SP> getListDataNike() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("NIKE","giay1","685000","999");
//        list.add(sp1);
//        return list;
//    }
//    private  List<SP> getListDataAdidas() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("ADIDAS","adidas","685000","999");
//        list.add(sp1);
//        return list;
//    }
//    private  List<SP> getListDataConverse() {
//        List<SP> list = new ArrayList<SP>();
//        SP sp1 = new SP("CONVERSE", "converse", "685000", "999");
//        list.add(sp1);
//        return list;
//    }
}