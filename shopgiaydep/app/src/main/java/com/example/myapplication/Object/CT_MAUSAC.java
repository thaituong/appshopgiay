package com.example.myapplication.Object;

import java.io.Serializable;

public class CT_MAUSAC implements Serializable {
    private int IDSP;
    private int IDMS;
    private String THEM;
    private String HINHANH;

    public CT_MAUSAC(int IDSP, int IDMS, String THEM, String HINHANH) {
        this.IDSP = IDSP;
        this.IDMS = IDMS;
        this.THEM = THEM;
        this.HINHANH = HINHANH;
    }

    public CT_MAUSAC() {
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public int getIDMS() {
        return IDMS;
    }

    public void setIDMS(int IDMS) {
        this.IDMS = IDMS;
    }

    public String getTHEM() {
        return THEM;
    }

    public void setTHEM(String THEM) {
        this.THEM = THEM;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }
}
