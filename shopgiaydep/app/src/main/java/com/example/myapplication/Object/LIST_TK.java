package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class LIST_TK implements Serializable {
    List<OTK> result;

    public LIST_TK(List<OTK> result) {
        this.result = result;
    }

    public List<OTK> getResult() {
        return result;
    }

    public void setResult(List<OTK> result) {
        this.result = result;
    }
}
