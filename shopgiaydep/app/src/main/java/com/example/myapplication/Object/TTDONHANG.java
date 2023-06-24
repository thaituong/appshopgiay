package com.example.myapplication.Object;

import com.example.myapplication.Object.SPGIOHANG;

import java.io.Serializable;
import java.util.List;

public class TTDONHANG implements Serializable {
    String IDDH;
    String DIACHINHAN;
    String TEN;
    String SDT;
    String EMAIL;
    String PT_THANHTOAN;
    String createdAt;
    String TRANGTHAI;
    List<SPGIOHANG> CT_DONHANGs;

    public TTDONHANG(String IDDH, String DIACHINHAN, String TEN, String SDT, String EMAIL, String PT_THANHTOAN, String createdAt, String TRANGTHAI, List<SPGIOHANG> CT_DONHANGs) {
        this.IDDH = IDDH;
        this.DIACHINHAN = DIACHINHAN;
        this.TEN = TEN;
        this.SDT = SDT;
        this.EMAIL = EMAIL;
        this.PT_THANHTOAN = PT_THANHTOAN;
        this.createdAt = createdAt;
        this.TRANGTHAI = TRANGTHAI;
        this.CT_DONHANGs = CT_DONHANGs;
    }

    public TTDONHANG() {
    }

    public String getIDDH() {
        return IDDH;
    }

    public void setIDDH(String IDDH) {
        this.IDDH = IDDH;
    }

    public String getDIACHINHAN() {
        return DIACHINHAN;
    }

    public void setDIACHINHAN(String DIACHINHAN) {
        this.DIACHINHAN = DIACHINHAN;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPT_THANHTOAN() {
        return PT_THANHTOAN;
    }

    public void setPT_THANHTOAN(String PT_THANHTOAN) {
        this.PT_THANHTOAN = PT_THANHTOAN;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public List<SPGIOHANG> getCT_DONHANGs() {
        return CT_DONHANGs;
    }

    public void setCT_DONHANGs(List<SPGIOHANG> CT_DONHANGs) {
        this.CT_DONHANGs = CT_DONHANGs;
    }
}
