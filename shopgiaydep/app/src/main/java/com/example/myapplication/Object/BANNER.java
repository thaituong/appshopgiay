package com.example.myapplication.Object;

import java.io.Serializable;

public class BANNER implements Serializable {
    int ID;
    String HINHANH;
    Boolean TRANGTHAI;

    public BANNER(int ID, String HINHANH, Boolean TRANGTHAI) {
        this.ID = ID;
        this.HINHANH = HINHANH;
        this.TRANGTHAI = TRANGTHAI;
    }

    public BANNER() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}
