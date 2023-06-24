package com.example.myapplication.Object;

import java.io.Serializable;

public class TB implements Serializable {
    private String TIEUDE;
    private String NOIDUNG;
    private String createdAt;

    public TB(String TIEUDE, String NOIDUNG, String createdAt) {
        this.TIEUDE = TIEUDE;
        this.NOIDUNG = NOIDUNG;
        this.createdAt = createdAt;
    }

    public TB() {
    }

    public String getTIEUDE() {
        return TIEUDE;
    }

    public void setTIEUDE(String TIEUDE) {
        this.TIEUDE = TIEUDE;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
