package com.example.myapplication.Object;

import java.io.Serializable;

public class CTTK implements Serializable {
    int IDSP;
    int IDMS;
    String MAU;
    String doanhthu;
    String sl;

    public CTTK() {
    }

    public CTTK(int IDSP, int IDMS, String MAU, String doanhthu, String sl) {
        this.IDSP = IDSP;
        this.IDMS = IDMS;
        this.MAU = MAU;
        this.doanhthu = doanhthu;
        this.sl = sl;
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

    public String getMAU() {
        return MAU;
    }

    public void setMAU(String MAU) {
        this.MAU = MAU;
    }

    public String getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(String doanhthu) {
        this.doanhthu = doanhthu;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
}
