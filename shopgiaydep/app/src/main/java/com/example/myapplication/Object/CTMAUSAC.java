package com.example.myapplication.Object;

import java.io.Serializable;

public class CTMAUSAC implements Serializable {
    private int IDSP;
    private int IDMS;
    private String THEM;
    private String HINHANH;
    private Boolean TRANGTHAI;
    private String createdAt;
    private String updatedAt;

    public CTMAUSAC(int IDSP, int IDMS, String THEM, String HINHANH, Boolean TRANGTHAI, String createdAt, String updatedAt) {
        this.IDSP = IDSP;
        this.IDMS = IDMS;
        this.THEM = THEM;
        this.HINHANH = HINHANH;
        this.TRANGTHAI = TRANGTHAI;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Boolean getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
