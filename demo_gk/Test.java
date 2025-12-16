package com.ntl.demo_gk;

public class Test {

    public static void main(String[] args) {
        NhanVat nv1 = new NhanVat("Doraemon");
        NhanVat nv2 = new NhanVat("Nobita");

        System.out.println("--- a) ---");
        QuanLyNhanVat ql1 = new QuanLyNhanVat();
        ql1.themNV(nv1, nv2);
        ql1.hienThi();

        System.out.println("--- b) ---");
        VatPham vp1 = new VPLuotChoi(1);
        VatPham vp3 = new VPLuotChoi(5);
        VatPham vp2 = new VPTangMau(10);
        nv1.themVP(vp1, vp2, vp3);
        ql1.hienThi();

        System.out.println("--- c) ---");
        ql1.hienThi();

        System.out.println("--- d) ---");
        int d = ql1.demLuotChoi(1);
        System.out.println(d);

        System.out.println("--- e) ---");
        ql1.sapSapGiamDan();
        ql1.hienThi();

    }
}
