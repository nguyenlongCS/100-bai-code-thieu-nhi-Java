package com.ntl.th4_c3;
import java.time.LocalDate;

public class NguoiNuocNgoai extends NguoiDan {
    
    private String soHoChieu;  // Số hộ chiếu
    private String quocTich;   // Quốc tịch
    
    public NguoiNuocNgoai(String soCCCD, String hoTen, String gioiTinh,
                          String soDienThoai, LocalDate ngaySinh,
                          String soHoChieu, String quocTich) {
        super(soCCCD, hoTen, gioiTinh, soDienThoai, ngaySinh);
        this.soHoChieu = soHoChieu;
        this.quocTich = quocTich;
    }
    
    @Override
    public void hienThi() {
        System.out.printf("Ho ten: %s - Gioi tinh: %s - Quoc tich: %s - Ho chieu: %s\n",
                hoTen, gioiTinh, quocTich, soHoChieu);
    }
    
    public String getSoHoChieu() {
        return soHoChieu;
    }
    
    public String getQuocTich() {
        return quocTich;
    }
}
