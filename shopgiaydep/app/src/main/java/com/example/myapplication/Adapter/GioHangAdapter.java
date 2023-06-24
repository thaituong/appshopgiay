package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.POSTSPGH;
import com.example.myapplication.R;
import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.activity.TrangChu;
import com.example.myapplication.activity.GioHang;
import com.example.myapplication.api.ApiService;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<SPGIOHANG> listData;
    private TextView btTangSP,btGiamSP;

    private Context context;

    public GioHangAdapter(Context aContext,List<SPGIOHANG> listData) {
        this.context = aContext;
        this.listData=listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview_item_giohang, null);
            holder = new ViewHolder();
            holder.hinh = (ImageView) view.findViewById(R.id.iv_AnhSP);
            holder.ten = (TextView) view.findViewById(R.id.tv_TenSP);
            holder.gia = (TextView) view.findViewById(R.id.tv_GiaSP);
            holder.size = (TextView) view.findViewById(R.id.tv_KichCoSP);
            holder.mausac = (TextView) view.findViewById(R.id.tv_MauSacSP);
            holder.soluong = (TextView) view.findViewById(R.id.tvSLSanPham);
            holder.TangSP = (TextView) view.findViewById(R.id.btTangSP);
            holder.GiamSP = (TextView) view.findViewById(R.id.btGiamSP);

            view.setTag(holder);
        } else {
            holder = (GioHangAdapter.ViewHolder) view.getTag();
        }
        SPGIOHANG csp = this.listData.get(i);
        holder.ten.setText(csp.getSANPHAM().getTENSANPHAM());
        Float giasp=Float.parseFloat(csp.getSANPHAM().getGIA())*csp.getSOLUONG();

        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.gia.setText(decimalFormat.format(giasp)+" Đ");
//        holder.hinh.setImageResource();
        Picasso.get().load(csp.getCT_MAUSAC().getHINHANH()).into(holder.hinh);
        holder.size.setText("Kích cỡ : "+csp.getKICHTHUOC().getSIZE());
        holder.mausac.setText("Màu sắc : "+csp.getMAUSAC().getMAU());
        holder.soluong.setText(""+csp.getSOLUONG());
        if(Integer.parseInt(holder.soluong.getText().toString())==1){
            holder.GiamSP.setEnabled(false);
        }
        holder.TangSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoi=Integer.parseInt(holder.soluong.getText().toString())+1;
                holder.GiamSP.setEnabled(true);
                GioHang.list.get(i).setSOLUONG(slmoi);
                holder.soluong.setText(slmoi+"");
                Float giamoisp=Float.parseFloat(csp.getSANPHAM().getGIA())*slmoi;
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                holder.gia.setText(decimalFormat.format(giamoisp)+" Đ");
                POSTSPGH postspgh=new POSTSPGH(csp.getSANPHAM().getIDSP(),csp.getMAUSAC().getIDMS(),csp.getKICHTHUOC().getIDKT(),slmoi);
                ApiService.apiService.putGioHang(postspgh, TrangChu.accessToken).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(context,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
                GioHang.eventTongTien();
            }
        });
        holder.GiamSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoi=Integer.parseInt(holder.soluong.getText().toString())-1;
                if(slmoi==1){
                    holder.GiamSP.setEnabled(false);
                }
                GioHang.list.get(i).setSOLUONG(slmoi);
                holder.soluong.setText(slmoi+"");
                Float giamoisp=Float.parseFloat(csp.getSANPHAM().getGIA())*slmoi;
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                holder.gia.setText(decimalFormat.format(giamoisp)+" Đ");
                POSTSPGH postspgh=new POSTSPGH(csp.getSANPHAM().getIDSP(),csp.getMAUSAC().getIDMS(),csp.getKICHTHUOC().getIDKT(),slmoi);
                ApiService.apiService.putGioHang(postspgh,TrangChu.accessToken).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(context,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
                GioHang.eventTongTien();
            }
        });
        return view;
    }


    static class ViewHolder {
        ImageView hinh;
        TextView ten;
        TextView gia;
        TextView size;
        TextView mausac;
        TextView soluong;
        TextView TangSP;
        TextView GiamSP;

    }
}
