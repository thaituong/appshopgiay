package com.example.myapplication.Object;

import com.example.myapplication.Object.BANNER;

import java.io.Serializable;
import java.util.List;

public class LIST_BANNER implements Serializable {
    List<BANNER> result;

    public LIST_BANNER(List<BANNER> result) {
        this.result = result;
    }

    public List<BANNER> getResult() {
        return result;
    }

    public void setResult(List<BANNER> result) {
        this.result = result;
    }
}
