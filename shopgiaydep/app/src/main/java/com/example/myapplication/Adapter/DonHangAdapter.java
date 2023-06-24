package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Object.Message;
import com.example.myapplication.R;
import com.example.myapplication.Object.TTDONHANG;
import com.example.myapplication.activity.TrangChu;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonHangAdapter extends BaseAdapter {
    private static final int MY_REQUEST_CODE = 10;
    private LayoutInflater layoutInflater;
    private List<TTDONHANG> listData;

    private Context context;

    public DonHangAdapter(Context aContext,List<TTDONHANG> listData) {
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
        DonHangAdapter.ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.listview_item_donhang, null);
            holder = new DonHangAdapter.ViewHolder();
            holder.iddh = (TextView) view.findViewById(R.id.tvIDDH);
            holder.diachinhan = (TextView) view.findViewById(R.id.tvDiaChi);
            holder.ten = (TextView) view.findViewById(R.id.tvHoTen);
            holder.ngaydat = (TextView) view.findViewById(R.id.tvNgayDat);
            holder.pttt = (TextView) view.findViewById(R.id.tvPTTT);
            holder.sdt = (TextView) view.findViewById(R.id.tvSDT);
            holder.trangthai=(TextView) view.findViewById(R.id.tvTrangThai);
            holder.huydh=(Button) view.findViewById(R.id.btHuyDon);
            view.setTag(holder);
        } else {
            holder = (DonHangAdapter.ViewHolder) view.getTag();
        }
        TTDONHANG ttdonhang = this.listData.get(i);
        holder.ten.setText("Họ tên: "+ttdonhang.getTEN());
        holder.trangthai.setText("Trạng thái: "+ttdonhang.getTRANGTHAI());
        holder.iddh.setText("Đơn hàng: "+ttdonhang.getIDDH());
        holder.sdt.setText("SDT: "+ttdonhang.getSDT());
        holder.pttt.setText("PTTT: "+ttdonhang.getCreatedAt());
        holder.ngaydat.setText("Ngày đặt: "+ttdonhang.getTEN());
        holder.diachinhan.setText("Địa chỉ: "+ttdonhang.getDIACHINHAN());

        holder.huydh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.trangthai.setText("Trạng thái: Đã hủy");
                ApiService.apiService.putHuyDH(ttdonhang.getIDDH(), TrangChu.accessToken).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message message=response.body();
                        Toast.makeText(context,"Call Api Success",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(context,"Call Api Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return view;
    }


    static class ViewHolder {
        TextView iddh;
        TextView diachinhan;
        TextView ten;
        TextView sdt;
        TextView pttt;
        TextView ngaydat;
        TextView trangthai;
        Button huydh;

    }
}
