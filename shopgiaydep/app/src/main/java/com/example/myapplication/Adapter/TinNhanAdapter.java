package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Object.TN;

import java.util.List;

public class TinNhanAdapter extends BaseAdapter {
    private List<TN> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public TinNhanAdapter(Context aContext,  List<TN> listData) {
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
        TinNhanAdapter.ViewHolder holder;
        TN tn = this.listData.get(i);
        if(tn.getIskhach()==true){
            if (view == null ) {
                view = layoutInflater.inflate(R.layout.listview_itemtn_khach, null);
                holder = new TinNhanAdapter.ViewHolder();
                holder.tinnhan = (TextView) view.findViewById(R.id.tvTinNhanKhach);
                view.setTag(holder);
            } else {
                holder = (TinNhanAdapter.ViewHolder) view.getTag();
            }
            holder.tinnhan.setText(tn.getTinnhan());
        }
        else {
            if (view == null ) {
                view = layoutInflater.inflate(R.layout.listview_itemtn_shop, null);
                holder = new TinNhanAdapter.ViewHolder();
                holder.tinnhan = (TextView) view.findViewById(R.id.tvTinNhanShop);
                view.setTag(holder);
            } else {
                holder = (TinNhanAdapter.ViewHolder) view.getTag();

            }
            holder.tinnhan.setText(tn.getTinnhan());
        }

//        if (view == null) {
//            view = layoutInflater.inflate(R.layout.listview_itemtn_shop, null);
//            holder = new TinNhanAdapter.ViewHolder();
//            holder.tinnhan = (TextView) view.findViewById(R.id.tvTinNhanShop);
//            view.setTag(holder);
//        } else {
//            holder = (TinNhanAdapter.ViewHolder) view.getTag();
//            holder.tinnhan.setText(tn.getTinnhan());
//        }



        return view;
    }



    static class ViewHolder {
        TextView tinnhan;
    }
}
