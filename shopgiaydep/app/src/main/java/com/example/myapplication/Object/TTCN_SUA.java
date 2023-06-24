package com.example.myapplication.Object;

import java.io.Serializable;

public class TTCN_SUA implements Serializable {
    String tennguoidung;
    String ngaysinh;
    String sdt;
    String gioitinh;

    public TTCN_SUA(String tennguoidung, String ngaysinh, String sdt, String gioitinh) {
        this.tennguoidung = tennguoidung;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
    }

    public TTCN_SUA() {
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
}
