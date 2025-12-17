package com.ntl.th4_c3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QuanLyTiemChung {
    
    private List<NguoiDan> dsNguoiDan;
    private List<VacXin> dsVacXin;
    
    public QuanLyTiemChung() {
        this.dsNguoiDan = new ArrayList<>();
        this.dsVacXin = new ArrayList<>();
    }
    
    // Thêm người dân
    public void themNguoiDan(NguoiDan... a) {
        dsNguoiDan.addAll(Arrays.asList(a));
    }
    
    // Thêm vắc xin
    public void themVacXin(VacXin... a) {
        dsVacXin.addAll(Arrays.asList(a));
    }
    
    // 1. Hiển thị danh sách các loại vắc xin
    public void hienThiDSVacXin() {
        System.out.println("=== DANH SACH VAC XIN ===");
        dsVacXin.forEach(vx -> vx.hienThi());
    }
    
    // 2. Hiển thị danh sách người nước ngoài
    public void hienThiNguoiNuocNgoai() {
        System.out.println("\n=== DANH SACH NGUOI NUOC NGOAI ===");
        dsNguoiDan.stream()
                .filter(nd -> nd instanceof NguoiNuocNgoai)
                .forEach(nd -> nd.hienThi());
    }
    
    // 3. Nhập thông tin tiêm chủng cho người dân
    public void ghiNhanTiemChung(String soCCCD, int maVacXin, 
                                 LocalDate ngayTiem, String diaDiem) {
        // Tìm người dân theo CCCD
        NguoiDan nd = dsNguoiDan.stream()
                .filter(n -> n.getSoCCCD().equals(soCCCD))
                .findFirst()
                .orElse(null);
        
        if (nd == null) {
            System.out.println("Khong tim thay nguoi dan voi CCCD: " + soCCCD);
            return;
        }
        
        // Tìm vắc xin theo mã
        VacXin vx = dsVacXin.stream()
                .filter(v -> v.getMaVacXin() == maVacXin)
                .findFirst()
                .orElse(null);
        
        if (vx == null) {
            System.out.println("Khong tim thay vac xin voi ma: " + maVacXin);
            return;
        }
        
        if (vx.getSoLuong() <= 0) {
            System.out.println("Vac xin da het!");
            return;
        }
        
        // Thêm mũi tiêm
        if (nd.themMuiTiem(vx, ngayTiem, diaDiem)) {
            System.out.println("Ghi nhan tiem chung thanh cong!");
        }
    }
    
    // 4. Hiển thị người dân đã tiêm >= 2 mũi
    public void hienThiNguoiDaTiem2Mui() {
        System.out.println("\n=== NGUOI DAN DA TIEM >= 2 MUI ===");
        dsNguoiDan.stream()
                .filter(nd -> nd.getDsMuiTiem().size() >= 2)
                .forEach(nd -> nd.hienThi());
    }
    
    // 5. Kiểm tra điều kiện tiêm mũi tiếp theo
    public void kiemTraDieuKienTiem(String soCCCD) {
        NguoiDan nd = dsNguoiDan.stream()
                .filter(n -> n.getSoCCCD().equals(soCCCD))
                .findFirst()
                .orElse(null);
        
        if (nd == null) {
            System.out.println("Khong tim thay nguoi dan voi CCCD: " + soCCCD);
            return;
        }
        
        System.out.printf("\n=== KIEM TRA DIEU KIEN TIEM CHO %s ===\n", nd.getHoTen());
        if (nd.kiemTraDieuKienTiemTiep()) {
            System.out.println("Du dieu kien tiem mui tiep theo!");
        } else {
            System.out.println("Chua du dieu kien tiem!");
        }
    }
    
    // 6. Sắp xếp vắc xin tăng dần theo xuất xứ, 
    //    cùng xuất xứ thì giảm dần theo số lượng người tiêm
    public void sapXepVacXin() {
        dsVacXin.sort((v1, v2) -> {
            int cmp = v1.getXuatXu().compareTo(v2.getXuatXu());
            if (cmp != 0) {
                return cmp;
            }
            return v2.getSoLuong() - v1.getSoLuong(); // Giảm dần theo số lượng
        });
    }
    
    public List<VacXin> getDsVacXin() {
        return dsVacXin;
    }
    
    public List<NguoiDan> getDsNguoiDan() {
        return dsNguoiDan;
    }
}
