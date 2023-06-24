package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Object.LIST_TK;
import com.example.myapplication.Object.OTK;
import com.example.myapplication.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BieuDo extends AppCompatActivity {
    LIST_TK list_tk;
    List<OTK> listtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieu_do);
        if(getIntent().getExtras().get("list_tk")!=null){
            list_tk=(LIST_TK) getIntent().getExtras().get("list_tk");

        }
        PieChart pieChart = findViewById(R.id.pieChart);

        // Tạo danh sách các phần tử
        ArrayList<PieEntry> entries = new ArrayList<>();

        listtp=list_tk.getResult();
        for(int i=0;i<listtp.size();i++){
            Log.d("TAG", listtp.get(i).getDoanhthu());
            entries.add(new PieEntry(Float.parseFloat(listtp.get(i).getDoanhthu()),listtp.get(i).getTENSANPHAM()));
        }
//        entries.add(new PieEntry(30f, "Red"));
//        entries.add(new PieEntry(20f, "Blue"));
//        entries.add(new PieEntry(50f, "Green"));

        // Tạo dataset và cấu hình nó
        PieDataSet dataSet = new PieDataSet(entries, "Color Distribution");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        // Tạo PieData và cấu hình nó
        PieData data = new PieData(dataSet);

        // Thiết lập các thuộc tính cho PieChart
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12f);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.getDescription().setEnabled(false);

        // Đặt dữ liệu cho PieChart
        pieChart.setData(data);

        // Cập nhật giao diện
        pieChart.invalidate();
    }

}