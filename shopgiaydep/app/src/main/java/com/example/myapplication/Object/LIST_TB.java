package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class LIST_TB implements Serializable {
    List<TB> result;

    public LIST_TB(List<TB> result) {
        this.result = result;
    }

    public List<TB> getResult() {
        return result;
    }

    public void setResult(List<TB> result) {
        this.result = result;
    }
}
