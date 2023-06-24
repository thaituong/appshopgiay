package com.example.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Object.NH;
import com.example.myapplication.R;

import java.util.List;

public class ThuongHieuAdapter extends BaseAdapter {
    private List<NH> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public ThuongHieuAdapter(Context aContext,  List<NH> listData) {
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
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.grid_item_iconthuonghieu, null);
            holder = new ViewHolder();
            holder.hinhSP = (ImageView) view.findViewById(R.id.iviconthuonghieu);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        NH NH = this.listData.get(i);
        Glide.with(context).load(NH.getHINH()).into(holder.hinhSP);
//        int imageId = this.getMipmapResIdByName(NH.getHinhTH());
//        holder.hinhSP.setImageResource(imageId);

        return view;
    }

    private int getMipmapResIdByName(String hinhTH) {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(hinhTH , "mipmap", pkgName);
        Log.i("myapplication", "Res Name: "+ hinhTH+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView hinhSP;
    }
}
