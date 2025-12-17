package com.ntl.th3_c5;
public class NhanVienBoPhanC extends NhanVien {
    
    public NhanVienBoPhanC(String cmnd, String hoTen, String queQuan,
                           String gioiTinh, String soDT) {
        super(cmnd, hoTen, queQuan, gioiTinh, soDT);
    }
    
    @Override
    public double tinhLuong(int soNgayCong) {
        return 2.5 * LUONG_CO_BAN * soNgayCong;
    }
    
    @Override
    public String getBoPhan() {
        return "C";
    }
}
