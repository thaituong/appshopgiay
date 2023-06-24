package com.example.myapplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Object.SP;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    private List<SP> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public SanPhamAdapter(Context aContext,  List<SP> listData) {
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
            view = layoutInflater.inflate(R.layout.grid_item_sp, null);
            holder = new ViewHolder();
            holder.hinhSP = (ImageView) view.findViewById(R.id.iv_AnhSP);
            holder.tenSP = (TextView) view.findViewById(R.id.tv_TenSP);
            holder.giaSP = (TextView) view.findViewById(R.id.tv_GiaSP);
            holder.slbSP = (TextView) view.findViewById(R.id.tv_SoLuongBan);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SP sp = this.listData.get(i);
        holder.tenSP.setText(sp.getTENSANPHAM());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.giaSP.setText(decimalFormat.format(Float.parseFloat(sp.getGIA()))+" Đ");
        holder.slbSP.setText("Đã bán "+sp.getDABAN());
        Picasso.get().load(sp.getHINH()).into(holder.hinhSP);

        return view;
    }

    private int getMipmapResIdByName(String hinhSP) {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(hinhSP , "mipmap", pkgName);
        Log.i("myapplication", "Res Name: "+ hinhSP+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView hinhSP;
        TextView tenSP;
        TextView giaSP;
        TextView slbSP;
    }
}
