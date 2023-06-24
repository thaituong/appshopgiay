package com.example.myapplication.Object;

import java.io.Serializable;

public class TT_CANHAN implements Serializable {
    String TENNGUOIDUNG;
    String NGAYSINH;
    String SDT;
    String GIOITINH;
    String EMAIL;
    String DIACHI;

    public TT_CANHAN(String TENNGUOIDUNG, String NGAYSINH, String SDT, String GIOITINH, String EMAIL, String DIACHI) {
        this.TENNGUOIDUNG = TENNGUOIDUNG;
        this.NGAYSINH = NGAYSINH;
        this.SDT = SDT;
        this.GIOITINH = GIOITINH;
        this.EMAIL = EMAIL;
        this.DIACHI = DIACHI;
    }

    public TT_CANHAN() {
    }

    public String getTENNGUOIDUNG() {
        return TENNGUOIDUNG;
    }

    public void setTENNGUOIDUNG(String TENNGUOIDUNG) {
        this.TENNGUOIDUNG = TENNGUOIDUNG;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }
}
