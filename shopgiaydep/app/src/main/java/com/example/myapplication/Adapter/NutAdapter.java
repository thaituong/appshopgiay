package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Object.CT_MAUSACs;
import com.example.myapplication.R;

import java.util.List;

public class NutAdapter extends BaseAdapter {
    private List<CT_MAUSACs> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public NutAdapter(Context aContext,  List<CT_MAUSACs> listData) {
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

        NutAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.recyclerview_item_nut, null);
            holder = new NutAdapter.ViewHolder();
            holder.ten = (TextView) view.findViewById(R.id.item_nut);
            view.setTag(holder);
        } else {
            holder = (NutAdapter.ViewHolder) view.getTag();
        }

        CT_MAUSACs ctms = this.listData.get(i);
        holder.ten.setText(ctms.getMAU());
//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_DOWN){
//                    holder.ten.setBackgroundColor(Color.RED);
//                }
//                if(event.getAction() == MotionEvent.ACTION_UP){
//                    holder.ten.setBackgroundColor(Color.WHITE);
//                }
//                return false;
//            }
//        });
        return view;
    }
    static class ViewHolder {
        TextView ten;
    }
}
