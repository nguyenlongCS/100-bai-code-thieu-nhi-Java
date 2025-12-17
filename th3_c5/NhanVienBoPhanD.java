package com.ntl.th3_c5;
public class NhanVienBoPhanD extends NhanVien {
    
    private double phuCap; // Phụ cấp tùy vào năng lực
    
    public NhanVienBoPhanD(String cmnd, String hoTen, String queQuan,
                           String gioiTinh, String soDT, double phuCap) {
        super(cmnd, hoTen, queQuan, gioiTinh, soDT);
        this.phuCap = phuCap;
    }
    
    @Override
    public double tinhLuong(int soNgayCong) {
        return LUONG_CO_BAN * soNgayCong + phuCap;
    }
    
    @Override
    public String getBoPhan() {
        return "D";
    }
    
    public double getPhuCap() {
        return phuCap;
    }
    
    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
}
