package com.ntl.demo_gk_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SanPham {

    private static int dem = 0;
    private String maSP;
    private String tenSP;
    private Date ngayNhap;
    private double donGia;
    private int soLuong;

    {
        dem++;
        if (dem > 9999) {
            throw new IllegalStateException("San pham da day");
        }
        maSP = String.format("SP-%04d", dem);
    }

    public SanPham(String tenSP, Date ngayNhap, double donGia, int soLuong) {
        this.tenSP = tenSP;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public double giaTriTonKho() {
        return soLuong * donGia;
    }

    public int soSanh(SanPham sp) {
        return Double.compare(this.giaTriTonKho(), sp.giaTriTonKho());
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Ma sp: %s\nTen: %s\nNgay nhap kho: %s\n"
                + "Don gia: %.1f\nSo luong: %d\n", maSP, tenSP, df.format(ngayNhap),
                 donGia, soLuong);
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
