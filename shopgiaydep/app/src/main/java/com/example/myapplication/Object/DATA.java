package com.example.myapplication.Object;

import java.io.Serializable;

public class DATA implements Serializable {
    String accessToken;

    public DATA(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
