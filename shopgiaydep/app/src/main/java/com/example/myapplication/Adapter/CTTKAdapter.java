package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Object.CTTK;
import com.example.myapplication.R;

import java.text.DecimalFormat;
import java.util.List;

public class CTTKAdapter extends BaseAdapter {
    private List<CTTK> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public CTTKAdapter(Context aContext,  List<CTTK> listData) {
        this.context = aContext;
        this.listData = listData;
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
        CTTKAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview_item_thongke, null);
            holder = new CTTKAdapter.ViewHolder();
            holder.ten = (TextView) view.findViewById(R.id.tvTen);
            holder.doanhthu = (TextView) view.findViewById(R.id.tvDoanhThu);
            holder.sl = (TextView) view.findViewById(R.id.tvSoLuong);
            view.setTag(holder);
        } else {
            holder = (CTTKAdapter.ViewHolder) view.getTag();
        }

        CTTK tk = this.listData.get(i);
        holder.ten.setText(tk.getMAU());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.doanhthu.setText(decimalFormat.format(Float.parseFloat(tk.getDoanhthu())));
        holder.sl.setText(tk.getSl());

        return view;
    }


    static class ViewHolder {
        TextView ten;
        TextView doanhthu;
        TextView sl;
    }
}
