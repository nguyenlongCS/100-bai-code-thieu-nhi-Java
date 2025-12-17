package com.ntl.th3_c5;
public class Test {
    
    public static void main(String[] args) {
        QuanLyNhanVien ql = new QuanLyNhanVien();
        
        // Thêm dữ liệu mẫu
        NhanVien nv1 = new NhanVienBinhThuong("123456789", "Nguyen Van A", 
                "Ha Noi", "Nam", "0901234567");
        NhanVien nv2 = new NhanVienBoPhanA("234567890", "Tran Thi B", 
                "Da Nang", "Nu", "0902345678");
        NhanVien nv3 = new NhanVienBoPhanB("345678901", "Le Van C", 
                "TP.HCM", "Nam", "0903456789");
        NhanVien nv4 = new NhanVienBoPhanC("456789012", "Pham Thi D", 
                "Hai Phong", "Nu", "0904567890");
        NhanVien nv5 = new NhanVienBoPhanD("567890123", "Hoang Van E", 
                "Can Tho", "Nam", "0905678901", 500000);
        
        ql.getDsNhanVien().add(nv1);
        ql.getDsNhanVien().add(nv2);
        ql.getDsNhanVien().add(nv3);
        ql.getDsNhanVien().add(nv4);
        ql.getDsNhanVien().add(nv5);
        
        System.out.println("=== DEMO CHUONG TRINH QUAN LY LUONG NHAN VIEN ===");
        System.out.println("Da them san 5 nhan vien mau de demo\n");
        
        // Demo hiển thị danh sách
        ql.hienThiDanhSach();
        
        // Demo tính lương (với dữ liệu cố định)
        System.out.println("\n=== DEMO TINH LUONG (SO NGAY CONG CO DINH) ===");
        System.out.printf("%-10s %-25s %-15s %-15s %-20s\n", 
                "Ma so", "Ho ten", "Bo phan", "So ngay cong", "Tien luong");
        System.out.println("-----------------------------------------------------------------------------------");
        
        int[] soNgayCong = {22, 20, 25, 18, 24};
        for (int i = 0; i < ql.getDsNhanVien().size(); i++) {
            NhanVien nv = ql.getDsNhanVien().get(i);
            double luong = nv.tinhLuong(soNgayCong[i]);
            System.out.printf("%-10d %-25s %-15s %-15d %-,20.0f VND\n", 
                    nv.getMaSo(), nv.getHoTen(), nv.getBoPhan(), 
                    soNgayCong[i], luong);
        }
        
        System.out.println("\n*** CHU Y: Tinh luong KHONG SU DUNG if/else hay switch/case ***");
        System.out.println("*** Su dung DA HINH: moi lop con co cach tinh luong rieng ***");
        
        // Chạy menu để người dùng thao tác
        System.out.println("\n\n=== BAT DAU CHUONG TRINH CHINH ===");
        ql.menu();
    }
}
