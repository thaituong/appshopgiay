package com.example.myapplication.Object;

import java.io.Serializable;

public class OTP implements Serializable {
    int success;
    String otp;

    public OTP(int success, String otp) {
        this.success = success;
        this.otp = otp;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
