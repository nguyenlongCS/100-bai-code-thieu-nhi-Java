package com.ntl.demo_gk;

public class VPTangMau extends VatPham {

    private static int dem;
    protected int soMauTang;

    public VPTangMau(int soMauTang) {
        this.maVP = String.format("B%02d", ++dem);
        // A%02d với 2 là tổng độ dài, 0 nếu thiếu thêm vào bên trái
        this.soMauTang = soMauTang;
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("So mau tang: %d\n", this.getSoMauTang());
    }

    public int getSoMauTang() {
        return soMauTang;
    }

    public void setSoMauTang(int soMauTang) {
        this.soMauTang = soMauTang;
    }

}
