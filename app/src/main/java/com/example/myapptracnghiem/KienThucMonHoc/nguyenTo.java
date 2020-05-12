package com.example.myapptracnghiem.KienThucMonHoc;

public class nguyenTo {
    public int idngto;
    public String ten;
    public String kiHieu;
    public int sohieuNT;
    public float ngTuKhoiTB;
    public float dADien;
    public String soOxi;

    public nguyenTo(int idngto, String ten, String kiHieu, int sohieuNT, float ngTuKhoiTB, float dADien, String soOxi) {
        this.idngto = idngto;
        this.ten = ten;
        this.kiHieu = kiHieu;
        this.sohieuNT = sohieuNT;
        this.ngTuKhoiTB = ngTuKhoiTB;
        this.dADien = dADien;
        this.soOxi = soOxi;
    }

    public int getIdngto() {
        return idngto;
    }

    public void setIdngto(int idngto) {
        this.idngto = idngto;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getKiHieu() {
        return kiHieu;
    }

    public void setKiHieu(String kiHieu) {
        this.kiHieu = kiHieu;
    }

    public int getSohieuNT() {
        return sohieuNT;
    }

    public void setSohieuNT(int sohieuNT) {
        this.sohieuNT = sohieuNT;
    }

    public float getNgTuKhoiTB() {
        return ngTuKhoiTB;
    }

    public void setNgTuKhoiTB(float ngTuKhoiTB) {
        this.ngTuKhoiTB = ngTuKhoiTB;
    }

    public float getdADien() {
        return dADien;
    }

    public void setdADien(float dADien) {
        this.dADien = dADien;
    }

    public String getSoOxi() {
        return soOxi;
    }

    public void setSoOxi(String soOxi) {
        this.soOxi = soOxi;
    }
}
