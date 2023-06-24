package com.example.myapplication.Object;

import java.io.Serializable;

public class DELSPGH implements Serializable {
    int IDSP;
    int IDMS;
    int IDKT;

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

    public DELSPGH(int IDSP, int IDMS, int IDKT) {
        this.IDSP = IDSP;
        this.IDMS = IDMS;
        this.IDKT = IDKT;
    }
}
