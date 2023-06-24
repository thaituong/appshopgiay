package com.example.myapplication.Object;

import java.io.Serializable;

public class TTCN implements Serializable {


    String tennguoidung;
    String ngaysinh;
    String sdt;
    String gioitinh;
    String email;



    public TTCN(String hoten, String ngaysinh, String sdt, String gioitinh, String email) {
        this.tennguoidung = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.email = email;
    }

    String otp;
    String diachi;


    String password;
    String repeat_password;
    public TTCN(String hoten, String ngaysinh, String sdt, String gioitinh, String email, String password, String xnpassword) {
        this.tennguoidung = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.email = email;
        this.password = password;
        this.repeat_password = xnpassword;
    }

    public TTCN(String hoten, String ngaysinh, String sdt, String gioitinh, String email, String otp, String diachi, String password, String xnpassword) {
        this.tennguoidung = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.email = email;
        this.otp = otp;
        this.diachi = diachi;
        this.password = password;
        this.repeat_password = xnpassword;
    }


    public String getHoten() {
        return tennguoidung;
    }

    public void setHoten(String hoten) {
        this.tennguoidung = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXnpassword() {
        return repeat_password;
    }

    public void setXnpassword(String xnpassword) {
        this.repeat_password = xnpassword;
    }
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
