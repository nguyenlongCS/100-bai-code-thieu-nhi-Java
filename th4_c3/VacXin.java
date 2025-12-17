package com.ntl.th4_c3;
public class VacXin {
    
    private static int dem = 0;
    private int maVacXin;     // Mã vắc xin tự tăng
    private String tenVacXin; // Tên vắc xin
    private String xuatXu;    // Xuất xứ (quốc gia)
    private int soLuong;      // Số lượng
    
    public VacXin(String tenVacXin, String xuatXu, int soLuong) {
        this.maVacXin = ++dem;
        this.tenVacXin = tenVacXin;
        this.xuatXu = xuatXu;
        this.soLuong = soLuong;
    }
    
    public void hienThi() {
        System.out.printf("Ma: %d - Ten: %s - Xuat xu: %s - So luong: %d\n",
                maVacXin, tenVacXin, xuatXu, soLuong);
    }
    
    // Giảm số lượng khi tiêm
    public void giamSoLuong() {
        if (soLuong > 0) {
            soLuong--;
        }
    }
    
    // Getters and Setters
    public int getMaVacXin() {
        return maVacXin;
    }
    
    public String getTenVacXin() {
        return tenVacXin;
    }
    
    public String getXuatXu() {
        return xuatXu;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
