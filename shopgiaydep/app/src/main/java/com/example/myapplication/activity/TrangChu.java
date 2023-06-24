package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapter.PhotoAdapter;
import com.example.myapplication.Adapter.ThuongHieuAdapter;
import com.example.myapplication.Object.BANNER;
import com.example.myapplication.Object.CT_SP;
import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.Object.LISTSP;
import com.example.myapplication.Object.LIST_BANNER;
import com.example.myapplication.Object.LIST_CT_SP;
import com.example.myapplication.Object.NH;
import com.example.myapplication.Object.NHANHIEU;
import com.example.myapplication.Object.Photo;
import com.example.myapplication.Object.SP;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrangChu extends AppCompatActivity {
    private static final int MY_REQUEST_CODER = 10;
    private TextView tvXemThemSKM,tvXemThemSPBC,tvXemThemSPM,tvXemBanDo;
    public static List<NH> thuonghieu;
    public static List<BANNER> banners;
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;
    private LinearLayout spskm1,spskm2,spbc1,spbc2,spm1,spm2;
    private ImageView spskm1_anh,spskm2_anh,spbc1_anh,spbc2_anh,spm1_anh,spm2_anh;
    private TextView spskm1_gia,spskm2_gia,spbc1_gia,spbc2_gia,spm1_gia,spm2_gia;
    private TextView spskm1_ten,spskm2_ten,spbc1_ten,spbc2_ten,spm1_ten,spm2_ten;
    private TextView spskm1_daban,spskm2_daban,spbc1_daban,spbc2_daban,spm1_daban,spm2_daban;
    private ImageView AnhSP1;
    private ScrollView scrollView;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    public GridView gridView;
    public static String accessToken;
    private static final int MY_REQUEST_CODE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        cnView();
        cnViewSP();
        setEvent();
        setEventSP();
        getBANNER();
        getSPDM();


        if (getIntent().getExtras() != null) {
            accessToken = (String) getIntent().getExtras().get("accessToken");
        }
        if(thuonghieu!=null){
            setAdapterTH();
        }
        else{
            ApiService.apiService.getNH().enqueue(new Callback<NHANHIEU>() {
                @Override
                public void onResponse(Call<NHANHIEU> call, Response<NHANHIEU> response) {
                    NHANHIEU nhanhieu=response.body();
                    thuonghieu = nhanhieu.getResult();
                    setAdapterTH();
                }
                @Override
                public void onFailure(Call<NHANHIEU> call, Throwable t) {
                    Toast.makeText(TrangChu.this,"Call Api Error",Toast.LENGTH_LONG).show();
                }
            });

        }




    }

    private void setEventSP() {
        spskm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPDM(18).enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(!litsp.getResult().isEmpty()){
                            List<SP> spList=litsp.getResult();
                            getCTSP(spList.get(0).getIDSP());
                        }

                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });
        spskm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPDM(18).enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(litsp.getResult().size()>=2){
                            List<SP> spList=litsp.getResult();
                            getCTSP(spList.get(1).getIDSP());
                        }

                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });
        spbc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPDM(21).enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(!litsp.getResult().isEmpty()){
                            List<SP> spList=litsp.getResult();
                            getCTSP(spList.get(0).getIDSP());
                        }
                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });
        spbc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPDM(21).enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(litsp.getResult().size()>=2) {
                            List<SP> spList = litsp.getResult();
                            getCTSP(spList.get(1).getIDSP());
                        }
                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });
        spm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPSKM().enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(!litsp.getResult().isEmpty()) {
                            List<SP> spList = litsp.getResult();
                            getCTSP(spList.get(0).getIDSP());
                        }
                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });
        spm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.getSPSKM().enqueue(new Callback<LISTSP>() {
                    @Override
                    public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                        LISTSP litsp=response.body();
                        if(litsp.getResult().size()>=2) {
                            List<SP> spList = litsp.getResult();
                            getCTSP(spList.get(1).getIDSP());
                        }
                    }

                    @Override
                    public void onFailure(Call<LISTSP> call, Throwable t) {
                    }
                });

            }
        });

    }
    public void getCTSP(int i) {
        ApiService.apiService.getCTSP(i).enqueue(new Callback<LIST_CT_SP>() {
            @Override
            public void onResponse(Call<LIST_CT_SP> call, Response<LIST_CT_SP> response) {
                LIST_CT_SP listCtSp=response.body();
                CT_SP ctsp= (CT_SP) listCtSp.getResult();
                Intent intent=new Intent(TrangChu.this, SanPham.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_sanpham",ctsp);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODER);

            }

            @Override
            public void onFailure(Call<LIST_CT_SP> call, Throwable t) {
                Toast.makeText(TrangChu.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }


        });
    }

    private void cnViewSP() {
        spskm1=(LinearLayout) findViewById(R.id.spskm1);
        spskm2=(LinearLayout) findViewById(R.id.spskm2);
        spbc1=(LinearLayout) findViewById(R.id.spbc1);
        spbc2=(LinearLayout) findViewById(R.id.spbc2);
        spm1=(LinearLayout) findViewById(R.id.spm1);
        spm2=(LinearLayout) findViewById(R.id.spm2);

        spskm1_anh=(ImageView) findViewById(R.id.spskm1_anh);
        spskm2_anh=(ImageView) findViewById(R.id.spskm2_anh);
        spbc1_anh=(ImageView) findViewById(R.id.spbc1_anh);
        spbc2_anh=(ImageView) findViewById(R.id.spbc2_anh);
        spm1_anh=(ImageView) findViewById(R.id.spm1_anh);
        spm2_anh=(ImageView) findViewById(R.id.spm2_anh);

        spskm1_ten=(TextView) findViewById(R.id.spskm1_ten);
        spskm2_ten=(TextView) findViewById(R.id.spskm2_ten);
        spbc1_ten=(TextView) findViewById(R.id.spbc1_ten);
        spbc2_ten=(TextView) findViewById(R.id.spbc2_ten);
        spm1_ten=(TextView) findViewById(R.id.spm1_ten);
        spm2_ten=(TextView) findViewById(R.id.spm2_ten);

        spskm1_gia=(TextView) findViewById(R.id.spskm1_gia);
        spskm2_gia=(TextView) findViewById(R.id.spskm2_gia);
        spbc1_gia=(TextView) findViewById(R.id.spbc1_gia);
        spbc2_gia=(TextView) findViewById(R.id.spbc2_gia);
        spm1_gia=(TextView) findViewById(R.id.spm1_gia);
        spm2_gia=(TextView) findViewById(R.id.spm2_gia);

        spskm1_daban=(TextView) findViewById(R.id.spskm1_daban);
        spskm2_daban=(TextView) findViewById(R.id.spskm2_daban);
        spbc1_daban=(TextView) findViewById(R.id.spbc1_daban);
        spbc2_daban=(TextView) findViewById(R.id.spbc2_daban);
        spm1_daban=(TextView) findViewById(R.id.spm1_daban);
        spm2_daban=(TextView) findViewById(R.id.spm2_daban);


    }

    private void getBANNER() {
        ApiService.apiService.getBANNER().enqueue(new Callback<LIST_BANNER>() {
            @Override
            public void onResponse(Call<LIST_BANNER> call, Response<LIST_BANNER> response) {
                LIST_BANNER banner=response.body();
                banners=banner.getResult();
                setAdapterBanner();
            }

            @Override
            public void onFailure(Call<LIST_BANNER> call, Throwable t) {
                Toast.makeText(TrangChu.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setAdapterBanner() {
        photoAdapter=new PhotoAdapter(this,banners);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    public void setAdapterTH() {
        for(int i=0;i<thuonghieu.size();i++){
            if(thuonghieu.get(i).getTRANGTHAI()==false){
                thuonghieu.remove(i);
            }
        }
        gridView.setAdapter(new ThuongHieuAdapter(this, thuonghieu));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                NH nh = (NH) o;
                getSPNH(nh.getIDNH());
            }
        });
    }


    private void cnView(){
        tvXemThemSKM=(TextView) findViewById(R.id.tvXemThemSKM);
        tvXemThemSPBC=(TextView) findViewById(R.id.tvXemThemSPBC);
        tvXemThemSPM=(TextView) findViewById(R.id.tvXemThemSPM);
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
        gridView = (GridView) findViewById(R.id.gvItemThuongHieu);
        viewPager=findViewById(R.id.viewpager);
        circleIndicator=findViewById(R.id.circle_indicator);
        scrollView=(ScrollView) findViewById(R.id.scrollView);
        tvXemBanDo=(TextView) findViewById(R.id.tvXemBanDo);

    }
    private List<Photo> getLishPhoto() {
        List<Photo> list=new ArrayList<>();
        list.add(new Photo(R.drawable.banner));
        list.add(new Photo(R.drawable.banner2));
        list.add(new Photo(R.drawable.banner3));
        list.add(new Photo(R.drawable.banner4));
        list.add(new Photo(R.drawable.banner5));
        return list;
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
//                startActivities(new Intent[]{new  Intent(getApplicationContext(), GioHang.class)});
                getGIOHANG();
            }
        });
        tvXemThemSKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSPDM(18);
            }
        });
        tvXemThemSPBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSPDM(21);
            }
        });
        tvXemThemSPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSPM();

            }
        });
        tvXemBanDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new  Intent(getApplicationContext(), MapsActivity.class)});
            }
        });

        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        scrollView.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

    }

    private void getGIOHANG() {
        ApiService.apiService.getGIOHANG(accessToken).enqueue(new Callback<LISTGIOHANG>() {
            @Override
            public void onResponse(Call<LISTGIOHANG> call, Response<LISTGIOHANG> response) {
                LISTGIOHANG listgiohang=response.body();
                Intent intent=new Intent(TrangChu.this, GioHang.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("oj_giohang",listgiohang);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTGIOHANG> call, Throwable t) {
                Toast.makeText(TrangChu.this,"Call Api Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getSPM() {
            ApiService.apiService.getSPSKM().enqueue(new Callback<LISTSP>() {
                @Override
                public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                    LISTSP litsp=response.body();
                    Intent intent=new Intent(TrangChu.this, SieuKhuyenMai.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list_spm",litsp);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,MY_REQUEST_CODE);
                }

                @Override
                public void onFailure(Call<LISTSP> call, Throwable t) {

                }
            });
    }
    private void getSPDM() {
        ApiService.apiService.getSPSKM().enqueue(new Callback<LISTSP>() {
            @Override
            public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                LISTSP litsp=response.body();
                List<SP> spList=litsp.getResult();
                if(!spList.isEmpty()){
                    Picasso.get().load(spList.get(0).getHINH()).into(spm1_anh);
                    Picasso.get().load(spList.get(1).getHINH()).into(spm2_anh);
                    spm1_ten.setText(spList.get(0).getTENSANPHAM());
                    spm2_ten.setText(spList.get(1).getTENSANPHAM());
                    DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                    spm1_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(0).getGIA()))+" Đ");
                    spm2_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(1).getGIA()))+" Đ");
                    spm1_daban.setText("Đã bán: "+spList.get(0).getDABAN());
                    spm2_daban.setText("Đã bán: "+spList.get(1).getDABAN());
                }

            }

            @Override
            public void onFailure(Call<LISTSP> call, Throwable t) {

            }
        });
        ApiService.apiService.getSPDM(18).enqueue(new Callback<LISTSP>() {
            @Override
            public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                LISTSP litsp=response.body();
                List<SP> spList=litsp.getResult();
                if(!spList.isEmpty()){
                    Picasso.get().load(spList.get(0).getHINH()).into(spskm1_anh);
                    Picasso.get().load(spList.get(1).getHINH()).into(spskm2_anh);
                    spskm1_ten.setText(spList.get(0).getTENSANPHAM());
                    spskm2_ten.setText(spList.get(1).getTENSANPHAM());
                    DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                    spskm1_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(0).getGIA()))+" Đ");
                    spskm2_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(1).getGIA()))+" Đ");
                    spskm1_daban.setText("Đã bán: "+spList.get(0).getDABAN());
                    spskm2_daban.setText("Đã bán: "+spList.get(1).getDABAN());
                }

            }

            @Override
            public void onFailure(Call<LISTSP> call, Throwable t) {

            }
        });
        ApiService.apiService.getSPDM(21).enqueue(new Callback<LISTSP>() {
            @Override
            public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                LISTSP litsp=response.body();
                List<SP> spList=litsp.getResult();
                if(!spList.isEmpty()){
                    Picasso.get().load(spList.get(0).getHINH()).into(spbc1_anh);
                    Picasso.get().load(spList.get(1).getHINH()).into(spbc2_anh);
                    spbc1_ten.setText(spList.get(0).getTENSANPHAM());
                    spbc2_ten.setText(spList.get(1).getTENSANPHAM());
                    DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                    spbc1_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(0).getGIA()))+" Đ");
                    spbc2_gia.setText(decimalFormat.format(Float.parseFloat(spList.get(1).getGIA()))+" Đ");
                    spbc1_daban.setText("Đã bán: "+spList.get(0).getDABAN());
                    spbc2_daban.setText("Đã bán: "+spList.get(1).getDABAN());
                }

            }

            @Override
            public void onFailure(Call<LISTSP> call, Throwable t) {

            }
        });
    }

    private void getSPNH(int i) {
        ApiService.apiService.getSPNH(i).enqueue(new Callback<LISTSP>() {
            @Override
            public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                LISTSP litsp=response.body();
                Intent intent=new Intent(TrangChu.this,SieuKhuyenMai.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list_spskm",litsp);
                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTSP> call, Throwable t) {

            }
        });
    }
    private void getSPDM(int i) {
        ApiService.apiService.getSPDM(i).enqueue(new Callback<LISTSP>() {
            @Override
            public void onResponse(Call<LISTSP> call, Response<LISTSP> response) {
                LISTSP litsp=response.body();
                Intent intent=new Intent(TrangChu.this,SieuKhuyenMai.class);
                Bundle bundle=new Bundle();
                if(i==18){
                    bundle.putSerializable("list_spskm",litsp);
                }
                else if(i==21){
                    bundle.putSerializable("list_spbc",litsp);
                }

                intent.putExtras(bundle);
                startActivityForResult(intent,MY_REQUEST_CODE);
            }

            @Override
            public void onFailure(Call<LISTSP> call, Throwable t) {

            }
        });
    }

}