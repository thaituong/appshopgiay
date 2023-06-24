package com.example.myapplication.Object;

import java.io.Serializable;

public class CTSP implements Serializable {


    private String tenSP;
    private int hinhSP;
    private String giaSP;
    private String soluong;



    private String size;
    private String mausac;

    public CTSP(String tenSP, int hinhSP, String giaSP, String size, String mausac,String soluong) {
        this.tenSP = tenSP;
        this.hinhSP = hinhSP;
        this.giaSP = giaSP;
        this.size = size;
        this.mausac = mausac;
        this.soluong=soluong;
    }
    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(int hinhSP) {
        this.hinhSP = hinhSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }
}
