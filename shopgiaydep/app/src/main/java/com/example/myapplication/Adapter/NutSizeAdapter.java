package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Object.KICHTHUOCs;
import com.example.myapplication.R;

import java.util.List;

public class NutSizeAdapter extends BaseAdapter {

    private List<KICHTHUOCs> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public NutSizeAdapter(Context aContext,  List<KICHTHUOCs> listData) {
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
        NutSizeAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.recyclerview_item_nut, null);
            holder = new NutSizeAdapter.ViewHolder();
            holder.ten = (TextView) view.findViewById(R.id.item_nut);
            view.setTag(holder);
        } else {
            holder = (NutSizeAdapter.ViewHolder) view.getTag();
        }

        KICHTHUOCs kt = this.listData.get(i);
        holder.ten.setText(kt.getSIZE()+"");
        return view;
    }
    static class ViewHolder {
        TextView ten;
    }
}
