package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Object.SPGIOHANG;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class ThanhToanAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<SPGIOHANG> listData;


    private Context context;

    public ThanhToanAdapter(Context aContext,List<SPGIOHANG> listData) {
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
        ThanhToanAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview_item_thanhtoan, null);
            holder = new ThanhToanAdapter.ViewHolder();
            holder.hinhSP = (ImageView) view.findViewById(R.id.iv_AnhSP1);
            holder.tenSP = (TextView) view.findViewById(R.id.tv_TenSP1);
            holder.giaSP = (TextView) view.findViewById(R.id.tv_GiaSP1);
            holder.size = (TextView) view.findViewById(R.id.tv_KichCoSP1);
            holder.mausac = (TextView) view.findViewById(R.id.tv_MauSacSP1);
            holder.soluong = (TextView) view.findViewById(R.id.tvSLSanPham1);
            view.setTag(holder);
        } else {
            holder = (ThanhToanAdapter.ViewHolder) view.getTag();
        }
        SPGIOHANG spgiohang = this.listData.get(i);
        holder.tenSP.setText(spgiohang.getSANPHAM().getTENSANPHAM());
        Float giasp=Float.parseFloat(spgiohang.getSANPHAM().getGIA())*spgiohang.getSOLUONG();
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.giaSP.setText(decimalFormat.format(giasp)+" Đ");
        Picasso.get().load(spgiohang.getCT_MAUSAC().getHINHANH()).into(holder.hinhSP);
        holder.size.setText("Kích cỡ : "+spgiohang.getKICHTHUOC().getSIZE());
        holder.mausac.setText("Màu sắc : "+spgiohang.getMAUSAC().getMAU());
        holder.soluong.setText(spgiohang.getSOLUONG()+"");

        return view;
    }
    static class ViewHolder {
        ImageView hinhSP;
        TextView tenSP;
        TextView giaSP;
        TextView size;
        TextView mausac;
        TextView soluong;


    }
}
