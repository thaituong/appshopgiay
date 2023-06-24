package com.example.myapplication.Object;

import java.io.Serializable;

public class MKM implements Serializable {
    String email;
    String otp;
    String new_password;
    String repeat_password;

    public MKM(String email, String otp, String new_password, String repeat_password) {
        this.email = email;
        this.otp = otp;
        this.new_password = new_password;
        this.repeat_password = repeat_password;
    }

    public MKM() {
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

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getRepeat_password() {
        return repeat_password;
    }

    public void setRepeat_password(String repeat_password) {
        this.repeat_password = repeat_password;
    }
}
