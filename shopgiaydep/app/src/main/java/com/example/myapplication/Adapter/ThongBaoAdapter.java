package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Object.TB;
import com.example.myapplication.R;

import java.util.List;

public class ThongBaoAdapter extends BaseAdapter {
    private List<TB> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public ThongBaoAdapter(Context aContext,  List<TB> listData) {
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
        ThongBaoAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview_item_thongbao, null);
            holder = new ThongBaoAdapter.ViewHolder();
            holder.tieude = (TextView) view.findViewById(R.id.tvTieuDeTB);
            holder.noidung = (TextView) view.findViewById(R.id.tvNoiDungTB);
            holder.ngaydang = (TextView) view.findViewById(R.id.tvNgayTB);
            view.setTag(holder);
        } else {
            holder = (ThongBaoAdapter.ViewHolder) view.getTag();
        }

        TB tb = this.listData.get(i);
        holder.tieude.setText(tb.getTIEUDE());
        holder.noidung.setText(tb.getNOIDUNG());
        holder.ngaydang.setText(tb.getCreatedAt());

        return view;
    }



    static class ViewHolder {
        TextView tieude;
        TextView noidung;
        TextView ngaydang;
    }
}
