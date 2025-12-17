package com.ntl.th3_c5;
public abstract class NhanVien {
    
    private static int dem = 0;
    protected int maSo;         // Mã số tự tăng
    protected String cmnd;      // Chứng minh nhân dân
    protected String hoTen;     // Họ tên
    protected String queQuan;   // Quê quán
    protected String gioiTinh;  // Giới tính
    protected String soDT;      // Số điện thoại
    
    public static final double LUONG_CO_BAN = 100000; // Lương cơ bản 100,000 VNĐ/ngày
    
    public NhanVien(String cmnd, String hoTen, String queQuan, 
                    String gioiTinh, String soDT) {
        this.maSo = ++dem;
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
    }
    
    // Phương thức trừu tượng tính lương - mỗi loại nhân viên tính khác nhau
    public abstract double tinhLuong(int soNgayCong);
    
    // Phương thức trừu tượng lấy tên bộ phận
    public abstract String getBoPhan();
    
    public void hienThi() {
        System.out.printf("Ma so: %d - Ho ten: %s - CMND: %s - Gioi tinh: %s - Que quan: %s - SDT: %s - Bo phan: %s\n",
                maSo, hoTen, cmnd, gioiTinh, queQuan, soDT, getBoPhan());
    }
    
    // Getters
    public int getMaSo() {
        return maSo;
    }
    
    public String getCmnd() {
        return cmnd;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public String getQueQuan() {
        return queQuan;
    }
    
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public String getSoDT() {
        return soDT;
    }
}
