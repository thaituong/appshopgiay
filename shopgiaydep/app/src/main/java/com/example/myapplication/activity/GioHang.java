
package com.example.myapplication.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.GioHangAdapter;
import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.DELSPGH;
import com.example.myapplication.R;
import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.api.ApiService;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHang extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;
    public Button btDatHang;
    public static List<SPGIOHANG> list=new ArrayList<>();
    private ImageButton ibTrangChu,ibThongBao,ibTinNhan,ibCaNhan,ibGioHang;
    public static TextView tvTongTien;
    public ListView listView;
    private GioHangAdapter giohangAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        if (getIntent().getExtras() != null) {
            LISTGIOHANG listgiohang = (LISTGIOHANG) getIntent().getExtras().get("oj_giohang");
            list=listgiohang.getResult();
        }
        cnView();
        setEvent();
        chechData();
        eventTongTien();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object o = listView.getItemAtPosition(position);
                SPGIOHANG spgh = (SPGIOHANG) o;
                AlertDialog.Builder builder=new AlertDialog.Builder(GioHang.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(list.size()<=0){
                        }
                        else {
                            Log.d("ALO", spgh.getSANPHAM().getIDSP()+" "+spgh.getCT_MAUSAC().getIDMS()+" "+spgh.getKICHTHUOC().getIDKT());
                            DELSPGH delspgh=new DELSPGH(spgh.getSANPHAM().getIDSP(),spgh.getCT_MAUSAC().getIDMS(),spgh.getKICHTHUOC().getIDKT());
                            ApiService.apiService.delSPGH(TrangChu.accessToken,delspgh).enqueue(new Callback<Message>() {
                                @Override
                                public void onResponse(Call<Message> call, Response<Message> response) {
                                    Message message=response.body();
                                    Toast.makeText(GioHang.this,"Xóa sản phẩm thành công",Toast.LENGTH_LONG).show();
                                    Log.d("TB",message.getMessage()+"");
                                    list.remove(position);
                                    giohangAdapter.notifyDataSetChanged();
                                    eventTongTien();
                                }

                                @Override
                                public void onFailure(Call<Message> call, Throwable t) {
                                    Toast.makeText(GioHang.this,"Call Api Error",Toast.LENGTH_LONG).show();
                                }
                            });

                            eventTongTien();
                        }
                    }

                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        giohangAdapter.notifyDataSetChanged();
                        eventTongTien();
                    }
                });
                builder.show();
                return true;
            }
        });


    }

    private void chechData() {
        if(list.size()<=0){
            giohangAdapter.notifyDataSetChanged();
        }else{
            giohangAdapter.notifyDataSetChanged();
        }
    }

    public static void eventTongTien() {
        Float tongtien= Float.valueOf(0);
        for(int i=0;i<list.size();i++){
            tongtien=tongtien+Float.parseFloat(list.get(i).getSANPHAM().getGIA())*list.get(i).getSOLUONG();
        }
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        tvTongTien.setText(decimalFormat.format(tongtien)+" Đ");
    }

    private void setEvent() {
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
                startActivities(new Intent[]{new  Intent(getApplicationContext(), GioHang.class)});
            }
        });
        
        btDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean kt=true;
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getSOLUONGTON()<list.get(i).getSOLUONG()){
                        Toast.makeText(GioHang.this,"Sản phẩm màu "+list.get(i).getMAUSAC().getMAU()+" size "+list.get(i).getKICHTHUOC().getSIZE()+" chỉ còn "+list.get(i).getSOLUONGTON()+" sản phẩm.",Toast.LENGTH_LONG).show();
                        kt=false;
                        break;
                    }
                }
                if(kt==true) {
                    Intent intent = new Intent(GioHang.this, ThanhToan.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list_ctsp", (Serializable) list);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, MY_REQUEST_CODE);
                }
            }
        });
    }


    private void cnView() {
        ibTrangChu=(ImageButton) findViewById(R.id.ibTrangChu);
        ibThongBao=(ImageButton) findViewById(R.id.ibThongBao);
        ibTinNhan=(ImageButton) findViewById(R.id.ibTinNhan);
        ibCaNhan=(ImageButton) findViewById(R.id.ibCaNhan);
        ibGioHang=(ImageButton) findViewById(R.id.ibGioHang);
        tvTongTien=(TextView) findViewById(R.id.tvTongTien);
        btDatHang=(Button) findViewById(R.id.btDatHang);
        giohangAdapter=new GioHangAdapter(this,list);
        listView = (ListView) findViewById(R.id.lvGioHang);
        listView.setAdapter(giohangAdapter);
    }
}