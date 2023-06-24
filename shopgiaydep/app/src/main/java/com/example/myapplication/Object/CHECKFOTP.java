package com.example.myapplication.Object;

import java.io.Serializable;

public class CHECKFOTP implements Serializable {
    String email;
    String otp;

    public CHECKFOTP(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public CHECKFOTP() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
