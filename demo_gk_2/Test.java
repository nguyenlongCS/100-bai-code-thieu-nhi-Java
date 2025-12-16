package com.ntl.demo_gk_2;
// File SanPham.txt đặt tại: src/main/source/SanPham.txt hoặc D:\\SanPham.txt

import java.text.SimpleDateFormat;

public class Test {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Đọc file
        QLSP qlsp = new QLSP("src/main/source/SanPham.txt");
        System.out.println(qlsp);

        // Thêm sản phẩm
        qlsp.themSP(new SanPham("May in", df.parse("10/12/2024"), 3000000, 20));
        qlsp.themSP(new SanPhamKhuyenMai("Chuot", df.parse("11/12/2024"), 200000, 50, 10));
        System.out.println("\nSau khi them san pham: ");
        System.out.println(qlsp);
        
        // Sắp xếp
        qlsp.sapXep();
        System.out.println("\nSau khi sap xep: ");
        System.out.println(qlsp);

        // Lọc
        System.out.println("\nLoc theo ki tu: ");
        qlsp.locTheoTen('C');

        System.out.println("\nLoc so luong >50: ");
        qlsp.locTheoSoLuong(50);

        // Top 5
        qlsp.top5();
        System.out.println("\nDa ghi Top5.txt");
    }
}
