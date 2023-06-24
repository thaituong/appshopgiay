package com.example.myapplication.Object;

import java.io.Serializable;

public class DiaChi implements Serializable {
    private String hoten;
    private String sdt;
    private String diachi;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public DiaChi(String diachi) {
        this.diachi = diachi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public DiaChi(String hoten, String sdt, String diachi) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
    }
}
