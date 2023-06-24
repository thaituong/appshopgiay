package com.example.myapplication.Object;

import java.io.Serializable;
import java.util.List;

public class LISTSP implements Serializable {
    List<SP> result;

    public LISTSP() {
    }

    public LISTSP(List<SP> result) {
        this.result = result;
    }
    public List<SP> getResult() {
        return result;
    }

    public void setResult(List<SP> result) {
        this.result = result;
    }
}
