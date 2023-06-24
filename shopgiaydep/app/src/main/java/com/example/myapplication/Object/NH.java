package com.example.myapplication.Object;

import java.io.Serializable;

public class NH implements Serializable {
    int IDNH;
    String MOTA;
    String TENNHANHIEU;
    String HINH;
    Boolean TRANGTHAI;

    public NH(int IDNH, String MOTA) {
        this.IDNH = IDNH;
        this.MOTA = MOTA;
    }

    public int getIDNH() {
        return IDNH;
    }

    public void setIDNH(int IDNH) {
        this.IDNH = IDNH;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getTENNHANHIEU() {
        return TENNHANHIEU;
    }

    public void setTENNHANHIEU(String TENNHANHIEU) {
        this.TENNHANHIEU = TENNHANHIEU;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public Boolean getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public NH(int IDNH, String MOTA, String TENNHANHIEU, String HINH, Boolean TRANGTHAI) {
        this.IDNH = IDNH;
        this.MOTA = MOTA;
        this.TENNHANHIEU = TENNHANHIEU;
        this.HINH = HINH;
        this.TRANGTHAI = TRANGTHAI;
    }
}
