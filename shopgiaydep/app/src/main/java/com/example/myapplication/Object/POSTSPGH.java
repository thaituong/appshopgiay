package com.example.myapplication.Object;

import java.io.Serializable;

public class POSTSPGH implements Serializable {
    int IDSP;
    int IDMS;
    int IDKT;
    int SOLUONG;

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

    public int getIDKT() {
        return IDKT;
    }

    public void setIDKT(int IDKT) {
        this.IDKT = IDKT;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public POSTSPGH(int IDSP, int IDMS, int IDKT, int SOLUONG) {
        this.IDSP = IDSP;
        this.IDMS = IDMS;
        this.IDKT = IDKT;
        this.SOLUONG = SOLUONG;
    }

    @Override
    public String toString() {
        return "{" +
                "\"IDSP\": " + IDSP +
                ", \"IDMS\": " + IDMS +
                ", \"IDKT\":" + IDKT +
                ", \"SOLUONG\":" + SOLUONG +
                '}';
    }
}
