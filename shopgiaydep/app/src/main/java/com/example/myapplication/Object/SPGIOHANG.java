package com.example.myapplication.Object;

import com.example.myapplication.Object.CT_MAUSAC;
import com.example.myapplication.Object.KICHTHUOC;
import com.example.myapplication.Object.MAUSAC;
import com.example.myapplication.Object.SP;

import java.io.Serializable;

public class SPGIOHANG implements Serializable {
    private int SOLUONG;
    private SP SANPHAM;
    private KICHTHUOC KICHTHUOC;
    private MAUSAC MAUSAC;
    private CT_MAUSAC CT_MAUSAC;
    private int SOLUONGTON;

    public SPGIOHANG() {
    }

    public SPGIOHANG(int SOLUONG, SP SANPHAM, com.example.myapplication.Object.KICHTHUOC KICHTHUOC, com.example.myapplication.Object.MAUSAC MAUSAC, com.example.myapplication.Object.CT_MAUSAC CT_MAUSAC, int SOLUONGTON) {
        this.SOLUONG = SOLUONG;
        this.SANPHAM = SANPHAM;
        this.KICHTHUOC = KICHTHUOC;
        this.MAUSAC = MAUSAC;
        this.CT_MAUSAC = CT_MAUSAC;
        this.SOLUONGTON = SOLUONGTON;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public SP getSANPHAM() {
        return SANPHAM;
    }

    public void setSANPHAM(SP SANPHAM) {
        this.SANPHAM = SANPHAM;
    }

    public com.example.myapplication.Object.KICHTHUOC getKICHTHUOC() {
        return KICHTHUOC;
    }

    public void setKICHTHUOC(com.example.myapplication.Object.KICHTHUOC KICHTHUOC) {
        this.KICHTHUOC = KICHTHUOC;
    }

    public com.example.myapplication.Object.MAUSAC getMAUSAC() {
        return MAUSAC;
    }

    public void setMAUSAC(com.example.myapplication.Object.MAUSAC MAUSAC) {
        this.MAUSAC = MAUSAC;
    }

    public com.example.myapplication.Object.CT_MAUSAC getCT_MAUSAC() {
        return CT_MAUSAC;
    }

    public void setCT_MAUSAC(com.example.myapplication.Object.CT_MAUSAC CT_MAUSAC) {
        this.CT_MAUSAC = CT_MAUSAC;
    }

    public int getSOLUONGTON() {
        return SOLUONGTON;
    }

    public void setSOLUONGTON(int SOLUONGTON) {
        this.SOLUONGTON = SOLUONGTON;
    }
}
