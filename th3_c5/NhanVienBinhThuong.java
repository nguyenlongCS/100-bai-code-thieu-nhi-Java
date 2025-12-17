package com.ntl.th3_c5;
public class NhanVienBinhThuong extends NhanVien {
    
    public NhanVienBinhThuong(String cmnd, String hoTen, String queQuan,
                              String gioiTinh, String soDT) {
        super(cmnd, hoTen, queQuan, gioiTinh, soDT);
    }
    
    @Override
    public double tinhLuong(int soNgayCong) {
        return LUONG_CO_BAN * soNgayCong;
    }
    
    @Override
    public String getBoPhan() {
        return "Binh thuong";
    }
}
