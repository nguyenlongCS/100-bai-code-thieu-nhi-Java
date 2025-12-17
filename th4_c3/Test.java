package com.ntl.th4_c3;
import java.time.LocalDate;


public class Test {
    
    public static void main(String[] args) {
        QuanLyTiemChung ql = new QuanLyTiemChung();
        
        // Thêm vắc xin
        VacXin vx1 = new VacXin("Pfizer", "My", 1000);
        VacXin vx2 = new VacXin("Moderna", "My", 800);
        VacXin vx3 = new VacXin("AstraZeneca", "Anh", 1200);
        VacXin vx4 = new VacXin("Sinopharm", "Trung Quoc", 1500);
        VacXin vx5 = new VacXin("Sputnik V", "Nga", 900);
        ql.themVacXin(vx1, vx2, vx3, vx4, vx5);
        
        // Thêm người dân Việt Nam
        NguoiDan nd1 = new NguoiDan("001200012345", "Nguyen Van A", "Nam", 
                "0901234567", LocalDate.of(1990, 5, 15));
        NguoiDan nd2 = new NguoiDan("001200023456", "Tran Thi B", "Nu", 
                "0902345678", LocalDate.of(1985, 8, 20));
        NguoiDan nd3 = new NguoiDan("001200034567", "Le Van C", "Nam", 
                "0903456789", LocalDate.of(1995, 12, 10));
        
        // Thêm người nước ngoài
        NguoiNuocNgoai nn1 = new NguoiNuocNgoai("001200045678", "John Smith", "Nam",
                "0904567890", LocalDate.of(1988, 3, 25), "P123456", "My");
        NguoiNuocNgoai nn2 = new NguoiNuocNgoai("001200056789", "Emma Watson", "Nu",
                "0905678901", LocalDate.of(1992, 7, 8), "P234567", "Anh");
        
        ql.themNguoiDan(nd1, nd2, nd3, nn1, nn2);
        
        // 1. Hiển thị danh sách vắc xin
        ql.hienThiDSVacXin();
        
        // 2. Hiển thị người nước ngoài
        ql.hienThiNguoiNuocNgoai();
        
        // 3. Ghi nhận tiêm chủng
        System.out.println("\n=== GHI NHAN TIEM CHUNG ===");
        ql.ghiNhanTiemChung("001200012345", 1, LocalDate.of(2024, 1, 15), "BV Cho Ray");
        ql.ghiNhanTiemChung("001200012345", 1, LocalDate.of(2024, 5, 20), "BV Cho Ray");
        ql.ghiNhanTiemChung("001200012345", 2, LocalDate.of(2024, 9, 25), "BV Cho Ray");
        
        ql.ghiNhanTiemChung("001200023456", 3, LocalDate.of(2024, 2, 10), "TYT Quan 1");
        ql.ghiNhanTiemChung("001200023456", 3, LocalDate.of(2024, 6, 15), "TYT Quan 1");
        
        ql.ghiNhanTiemChung("001200034567", 4, LocalDate.of(2024, 3, 5), "BV Quan 7");
        
        ql.ghiNhanTiemChung("001200045678", 5, LocalDate.of(2024, 4, 20), "BV Thu Duc");
        ql.ghiNhanTiemChung("001200045678", 1, LocalDate.of(2024, 8, 25), "BV Thu Duc");
        
        // 4. Hiển thị người đã tiêm >= 2 mũi
        ql.hienThiNguoiDaTiem2Mui();
        
        // 5. Kiểm tra điều kiện tiêm mũi tiếp theo
        ql.kiemTraDieuKienTiem("001200012345"); // Đã đủ 3 mũi
        ql.kiemTraDieuKienTiem("001200034567"); // Mới 1 mũi, chưa đủ 3 tháng
        ql.kiemTraDieuKienTiem("001200056789"); // Chưa tiêm mũi nào
        
        // 6. Sắp xếp vắc xin
        System.out.println("\n=== SAP XEP VAC XIN (TANG DAN THEO XUAT XU) ===");
        ql.sapXepVacXin();
        ql.hienThiDSVacXin();
    }
}
