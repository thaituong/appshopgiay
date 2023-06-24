package com.example.myapplication.Object;

import java.io.Serializable;

public class MAUSAC implements Serializable {
    private int IDMS;
    private String MAU;
    private String MAMAU;

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

    public MAUSAC(int IDMS, String MAU, String MAMAU) {
        this.IDMS = IDMS;
        this.MAU = MAU;
        this.MAMAU = MAMAU;
    }

    public MAUSAC() {
    }
}
