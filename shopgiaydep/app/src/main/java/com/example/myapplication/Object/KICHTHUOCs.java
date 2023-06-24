package com.example.myapplication.Object;

import java.io.Serializable;

public class KICHTHUOCs implements Serializable {
    int SOLUONGTON;
    int SOLUONGDABAN;
    Boolean TRANGTHAI;
    int IDKT;
    int SIZE;

    public KICHTHUOCs(int SOLUONGTON, int SOLUONGDABAN, Boolean TRANGTHAI, int IDKT, int SIZE) {
        this.SOLUONGTON = SOLUONGTON;
        this.SOLUONGDABAN = SOLUONGDABAN;
        this.TRANGTHAI = TRANGTHAI;
        this.IDKT = IDKT;
        this.SIZE = SIZE;
    }

    public int getSOLUONGTON() {
        return SOLUONGTON;
    }

    public void setSOLUONGTON(int SOLUONGTON) {
        this.SOLUONGTON = SOLUONGTON;
    }

    public int getSOLUONGDABAN() {
        return SOLUONGDABAN;
    }

    public void setSOLUONGDABAN(int SOLUONGDABAN) {
        this.SOLUONGDABAN = SOLUONGDABAN;
    }

    public Boolean getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDKT() {
        return IDKT;
    }

    public void setIDKT(int IDKT) {
        this.IDKT = IDKT;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }
}
