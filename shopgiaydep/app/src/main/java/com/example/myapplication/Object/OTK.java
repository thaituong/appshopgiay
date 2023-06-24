package com.example.myapplication.Object;

import com.example.myapplication.Object.CTTK;

import java.io.Serializable;
import java.util.List;

public class OTK implements Serializable {
    int IDSP;
    String TENSANPHAM;
    String doanhthu;
    String sum;
    List<CTTK> CT;

    public OTK() {
    }

    public OTK(int IDSP, String TENSANPHAM, String doanhthu, String sum, List<CTTK> CT) {
        this.IDSP = IDSP;
        this.TENSANPHAM = TENSANPHAM;
        this.doanhthu = doanhthu;
        this.sum = sum;
        this.CT = CT;
    }

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public String getTENSANPHAM() {
        return TENSANPHAM;
    }

    public void setTENSANPHAM(String TENSANPHAM) {
        this.TENSANPHAM = TENSANPHAM;
    }

    public String getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(String doanhthu) {
        this.doanhthu = doanhthu;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public List<CTTK> getCT() {
        return CT;
    }

    public void setCT(List<CTTK> CT) {
        this.CT = CT;
    }
}
