package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class LIST_TTDH implements Serializable {
    List<TTDONHANG> donhang;

    public LIST_TTDH(List<TTDONHANG> donhang) {
        this.donhang = donhang;
    }

    public LIST_TTDH() {
    }

    public List<TTDONHANG> getDonhang() {
        return donhang;
    }

    public void setDonhang(List<TTDONHANG> donhang) {
        this.donhang = donhang;
    }
}
