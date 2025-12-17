package com.ntl.th3_c5;
public class NhanVienBoPhanB extends NhanVien {
    
    public NhanVienBoPhanB(String cmnd, String hoTen, String queQuan,
                           String gioiTinh, String soDT) {
        super(cmnd, hoTen, queQuan, gioiTinh, soDT);
    }
    
    @Override
    public double tinhLuong(int soNgayCong) {
        return 1.5 * LUONG_CO_BAN * soNgayCong;
    }
    
    @Override
    public String getBoPhan() {
        return "B";
    }
}
