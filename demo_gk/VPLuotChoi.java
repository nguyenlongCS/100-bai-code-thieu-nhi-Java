package com.ntl.demo_gk;

public class VPLuotChoi extends VatPham {

    private static int dem;
    protected int soLuotTang;

    public VPLuotChoi(int soLuotTang) {
        this.maVP = String.format("A%02d", ++dem);
        // A%02d với 2 là tổng độ dài, 0 nếu thiếu thêm vào bên trái
        this.soLuotTang = soLuotTang;
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("So luot tang: %d\n", this.getSoLuotTang());
    }

    public int getSoLuotTang() {
        return soLuotTang;
    }

    public void setSoLuotTang(int soLuotTang) {
        this.soLuotTang = soLuotTang;
    }

}
