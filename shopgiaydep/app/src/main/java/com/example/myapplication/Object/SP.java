package com.example.myapplication.Object;

import com.example.myapplication.Object.CTMAUSAC;

import java.io.Serializable;
import java.util.List;

public class SP implements Serializable {

    private int IDSP;
    private String MOTA;
    private String NHANHIEU;
    private Boolean TRANGTHAI;
    private List<CTMAUSAC> CT_MAUSACs;
    private String TENSANPHAM;
    private String GIA;
    private String DABAN;
    private String HINH;

    public SP(int IDSP, String MOTA, String NHANHIEU, Boolean TRANGTHAI, List<CTMAUSAC> CT_MAUSACs, String TENSANPHAM, String GIA, String DABAN, String HINH) {
        this.IDSP = IDSP;
        this.MOTA = MOTA;
        this.NHANHIEU = NHANHIEU;
        this.TRANGTHAI = TRANGTHAI;
        this.CT_MAUSACs = CT_MAUSACs;
        this.TENSANPHAM = TENSANPHAM;
        this.GIA = GIA;
        this.DABAN = DABAN;
        this.HINH = HINH;
    }

    public SP() {
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getNHANHIEU() {
        return NHANHIEU;
    }

    public void setNHANHIEU(String NHANHIEU) {
        this.NHANHIEU = NHANHIEU;
    }

    public Boolean getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public List<CTMAUSAC> getCT_MAUSACs() {
        return CT_MAUSACs;
    }

    public void setCT_MAUSACs(List<CTMAUSAC> CT_MAUSACs) {
        this.CT_MAUSACs = CT_MAUSACs;
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

    public String getDABAN() {
        return DABAN;
    }

    public void setDABAN(String DABAN) {
        this.DABAN = DABAN;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }
}
