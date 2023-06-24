package com.example.myapplication.Object;

import com.example.myapplication.Object.CT_SP;

import java.io.Serializable;

public class LIST_CT_SP implements Serializable {
    CT_SP result;

    public LIST_CT_SP(CT_SP result) {
        this.result = result;
    }

    public CT_SP getResult() {
        return result;
    }

    public void setResult(CT_SP result) {
        this.result = result;
    }



}
