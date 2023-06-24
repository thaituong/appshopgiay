package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class CT_MAUSACs implements Serializable {

    String THEM;
    String HINHANH;
    Boolean TRANGTHAI;
    int IDMS;
    String MAU;
    String MAMAU;
    List<KICHTHUOCs> CT_KICHTHUOCs;

    public CT_MAUSACs() {
    }

    public CT_MAUSACs(String THEM, String HINHANH, Boolean TRANGTHAI, int IDMS, String MAU, String MAMAU, List<KICHTHUOCs> CT_KICHTHUOCs) {
        this.THEM = THEM;
        this.HINHANH = HINHANH;
        this.TRANGTHAI = TRANGTHAI;
        this.IDMS = IDMS;
        this.MAU = MAU;
        this.MAMAU = MAMAU;
        this.CT_KICHTHUOCs = CT_KICHTHUOCs;
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

    public Boolean getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
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

    public String getMAMAU() {
        return MAMAU;
    }

    public void setMAMAU(String MAMAU) {
        this.MAMAU = MAMAU;
    }

    public List<KICHTHUOCs> getCT_KICHTHUOCs() {
        return CT_KICHTHUOCs;
    }

    public void setCT_KICHTHUOCs(List<KICHTHUOCs> CT_KICHTHUOCs) {
        this.CT_KICHTHUOCs = CT_KICHTHUOCs;
    }
}
