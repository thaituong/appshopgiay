package com.example.myapplication.Object;

import java.io.Serializable;

public class DH implements Serializable {
    String DIACHINHAN;
    String TEN;
    String SDT;
    String EMAIL;
    String PTTT;
    String CTSP;

    public DH() {
    }

    public DH(String DIACHINHAN, String TEN, String SDT, String EMAIL, String PTTT, String CTSP) {
        this.DIACHINHAN = DIACHINHAN;
        this.TEN = TEN;
        this.SDT = SDT;
        this.EMAIL = EMAIL;
        this.PTTT = PTTT;
        this.CTSP = CTSP;
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

    public String getPTTT() {
        return PTTT;
    }

    public void setPTTT(String PTTT) {
        this.PTTT = PTTT;
    }

    public String getCTSP() {
        return CTSP;
    }

    public void setCTSP(String CTSP) {
        this.CTSP = CTSP;
    }
}
