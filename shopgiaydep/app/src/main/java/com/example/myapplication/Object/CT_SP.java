package com.example.myapplication.Object;

import com.example.myapplication.Object.CT_MAUSACs;

import java.io.Serializable;
import java.util.List;

public class CT_SP implements Serializable {
    int IDSP;
    String TENSANPHAM;
    String GIA;
    List<CT_MAUSACs> CT_MAUSACs;
    String MOTA;

    public CT_SP(int IDSP, String TENSANPHAM, String GIA, List<com.example.myapplication.Object.CT_MAUSACs> CT_MAUSACs, String MOTA) {
        this.IDSP = IDSP;
        this.TENSANPHAM = TENSANPHAM;
        this.GIA = GIA;
        this.CT_MAUSACs = CT_MAUSACs;
        this.MOTA = MOTA;
    }

    public CT_SP() {
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public String getTENSANPHAM() {
        return TENSANPHAM;
    }

    public void setTENSANPHAM(String TENSANPHAM) {
        this.TENSANPHAM = TENSANPHAM;
    }

    public String getGIA() {
        return GIA;
    }

    public void setGIA(String GIA) {
        this.GIA = GIA;
    }

    public List<com.example.myapplication.Object.CT_MAUSACs> getCT_MAUSACs() {
        return CT_MAUSACs;
    }

    public void setCT_MAUSACs(List<com.example.myapplication.Object.CT_MAUSACs> CT_MAUSACs) {
        this.CT_MAUSACs = CT_MAUSACs;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }
}
