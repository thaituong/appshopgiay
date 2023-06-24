package com.example.myapplication.Object;

import java.io.Serializable;

public class KICHTHUOC implements Serializable {
    private int IDKT;
    private int SIZE;

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

    public KICHTHUOC(int IDKT, int SIZE) {
        this.IDKT = IDKT;
        this.SIZE = SIZE;
    }
}
