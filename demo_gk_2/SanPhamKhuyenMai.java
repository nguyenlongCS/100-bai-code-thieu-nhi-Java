package com.ntl.demo_gk_2;

import java.util.Date;

public class SanPhamKhuyenMai extends SanPham {

    private int giaGiam;

    public SanPhamKhuyenMai(String tenSP, Date ngayNhap, double donGia, int soLuong, int giaGiam) {
        super(tenSP, ngayNhap, donGia, soLuong);
        this.giaGiam = giaGiam;
    }

    @Override
    public double giaTriTonKho() {
        return super.giaTriTonKho() * (1 - giaGiam / 100);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Gia giam: %d\n", giaGiam);
    }

    public int getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(int giaGiam) {
        this.giaGiam = giaGiam;
    }

}
