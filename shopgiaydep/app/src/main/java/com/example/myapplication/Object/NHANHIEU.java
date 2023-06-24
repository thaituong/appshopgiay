package com.example.myapplication.Object;

import com.example.myapplication.Object.NH;

import java.io.Serializable;
import java.util.List;

public class NHANHIEU implements Serializable {


    List<NH> result;

    public NHANHIEU(List<NH> result) {
        this.result = result;
    }
    public List<NH> getResult() {
        return result;
    }

    public void setResult(List<NH> result) {
        this.result = result;
    }
}
