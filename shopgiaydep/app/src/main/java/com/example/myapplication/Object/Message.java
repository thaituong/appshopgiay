package com.example.myapplication.Object;

import com.example.myapplication.Object.DATA;

import java.io.Serializable;

public class Message implements Serializable {

    String message;
    DATA data;
    public Message(String message) {
        this.message = message;
    }

    public Message(String message, DATA data) {
        this.message = message;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

}
