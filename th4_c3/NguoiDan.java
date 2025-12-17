package com.ntl.th4_c3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NguoiDan {
    
    protected String soCCCD;           // Số căn cước công dân
    protected String hoTen;            // Họ tên
    protected String gioiTinh;         // Giới tính
    protected String soDienThoai;      // Số điện thoại
    protected LocalDate ngaySinh;      // Ngày sinh
    protected List<MuiTiem> dsMuiTiem; // Danh sách mũi tiêm
    
    public NguoiDan(String soCCCD, String hoTen, String gioiTinh, 
                    String soDienThoai, LocalDate ngaySinh) {
        this.soCCCD = soCCCD;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.dsMuiTiem = new ArrayList<>();
    }
    
    // Kiểm tra tuổi >= 18
    public boolean kiemTraTuoi() {
        LocalDate now = LocalDate.now();
        int tuoi = now.getYear() - ngaySinh.getYear();
        // Nếu chưa qua sinh nhật năm nay thì trừ 1
        if (now.getMonthValue() < ngaySinh.getMonthValue() ||
            (now.getMonthValue() == ngaySinh.getMonthValue() && 
             now.getDayOfMonth() < ngaySinh.getDayOfMonth())) {
            tuoi--;
        }
        return tuoi >= 18;
    }
    
    // Thêm mũi tiêm
    public boolean themMuiTiem(VacXin vx, LocalDate ngayTiem, String diaDiem) {
        // Kiểm tra số mũi tiêm tối đa
        if (dsMuiTiem.size() >= 3) {
            System.out.println("Da tiem du 3 mui!");
            return false;
        }
        
        // Kiểm tra khoảng cách 3 tháng với mũi trước
        if (!dsMuiTiem.isEmpty()) {
            LocalDate ngayTiemCuoi = dsMuiTiem.get(dsMuiTiem.size() - 1).getNgayTiem();
            // Tính số tháng chênh lệch
            int thangCachNhau = (ngayTiem.getYear() - ngayTiemCuoi.getYear()) * 12 
                              + (ngayTiem.getMonthValue() - ngayTiemCuoi.getMonthValue());
            
            if (thangCachNhau < 3) {
                System.out.println("Chua du 3 thang ke tu mui truoc!");
                return false;
            }
        }
        
        // Thêm mũi tiêm mới
        dsMuiTiem.add(new MuiTiem(vx, ngayTiem, diaDiem));
        vx.giamSoLuong(); // Giảm số lượng vắc xin
        return true;
    }
    
    // Kiểm tra điều kiện tiêm mũi tiếp theo
    public boolean kiemTraDieuKienTiemTiep() {
        if (!kiemTraTuoi()) {
            System.out.println("Chua du 18 tuoi!");
            return false;
        }
        
        if (dsMuiTiem.size() >= 3) {
            System.out.println("Da tiem du 3 mui!");
            return false;
        }
        
        if (!dsMuiTiem.isEmpty()) {
            LocalDate ngayTiemCuoi = dsMuiTiem.get(dsMuiTiem.size() - 1).getNgayTiem();
            LocalDate now = LocalDate.now();
            // Tính số tháng chênh lệch
            int thangCachNhau = (now.getYear() - ngayTiemCuoi.getYear()) * 12 
                              + (now.getMonthValue() - ngayTiemCuoi.getMonthValue());
            
            if (thangCachNhau < 3) {
                System.out.println("Chua du 3 thang ke tu mui truoc!");
                return false;
            }
        }
        
        return true;
    }
    
    public void hienThi() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("CCCD: %s - %s - %s\n", soCCCD, hoTen, gioiTinh);
        if (!dsMuiTiem.isEmpty()) {
            dsMuiTiem.forEach(m -> m.hienThi());
        }
    }
    
    // Getters and Setters
    public String getSoCCCD() {
        return soCCCD;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public List<MuiTiem> getDsMuiTiem() {
        return dsMuiTiem;
    }
}