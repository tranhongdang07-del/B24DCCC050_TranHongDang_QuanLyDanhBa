package com.example.quanlydanhba;

public class Contact {

    private String hoTen;
    private String soDienThoai;
    private String nhom;
    private String gioiTinh;
    private boolean yeuThich;
    private String ghiChu;

    public Contact(String hoTen, String soDienThoai,
                   String nhom, String gioiTinh,
                   boolean yeuThich, String ghiChu) {

        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.nhom = nhom;
        this.gioiTinh = gioiTinh;
        this.yeuThich = yeuThich;
        this.ghiChu = ghiChu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isYeuThich() {
        return yeuThich;
    }

    public void setYeuThich(boolean yeuThich) {
        this.yeuThich = yeuThich;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}