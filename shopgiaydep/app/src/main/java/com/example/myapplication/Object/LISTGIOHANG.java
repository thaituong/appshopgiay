package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class LISTGIOHANG implements Serializable {
    List<SPGIOHANG> result;

    public List<SPGIOHANG> getResult() {
        return result;
    }

    public void setResult(List<SPGIOHANG> result) {
        this.result = result;
    }

    public LISTGIOHANG(List<SPGIOHANG> result) {
        this.result = result;
    }
}
