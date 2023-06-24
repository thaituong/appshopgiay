package com.example.myapplication.Object;

import java.io.Serializable;

public class Email implements Serializable {
    String email;
    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
