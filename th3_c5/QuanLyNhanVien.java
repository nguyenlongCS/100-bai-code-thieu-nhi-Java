package com.ntl.th3_c5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    
    private List<NhanVien> dsNhanVien;
    private Scanner sc;
    
    public QuanLyNhanVien() {
        this.dsNhanVien = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }
    
    // 1. Thêm nhân viên
    public void themNhanVien() {
        System.out.println("\n=== THEM NHAN VIEN ===");
        System.out.print("Nhap CMND: ");
        String cmnd = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhap que quan: ");
        String queQuan = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDT = sc.nextLine();
        
        System.out.println("Chon bo phan:");
        System.out.println("1. Binh thuong");
        System.out.println("2. Bo phan A");
        System.out.println("3. Bo phan B");
        System.out.println("4. Bo phan C");
        System.out.println("5. Bo phan D");
        System.out.print("Lua chon: ");
        int chon = Integer.parseInt(sc.nextLine());
        
        NhanVien nv = null;
        switch (chon) {
            case 1:
                nv = new NhanVienBinhThuong(cmnd, hoTen, queQuan, gioiTinh, soDT);
                break;
            case 2:
                nv = new NhanVienBoPhanA(cmnd, hoTen, queQuan, gioiTinh, soDT);
                break;
            case 3:
                nv = new NhanVienBoPhanB(cmnd, hoTen, queQuan, gioiTinh, soDT);
                break;
            case 4:
                nv = new NhanVienBoPhanC(cmnd, hoTen, queQuan, gioiTinh, soDT);
                break;
            case 5:
                System.out.print("Nhap phu cap: ");
                double phuCap = Double.parseDouble(sc.nextLine());
                nv = new NhanVienBoPhanD(cmnd, hoTen, queQuan, gioiTinh, soDT, phuCap);
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }
        
        dsNhanVien.add(nv);
        System.out.println("Them nhan vien thanh cong! Ma so: " + nv.getMaSo());
    }
    
    // 2. Xóa nhân viên theo mã số
    public void xoaNhanVien() {
        System.out.println("\n=== XOA NHAN VIEN ===");
        System.out.print("Nhap ma so nhan vien can xoa: ");
        int maSo = Integer.parseInt(sc.nextLine());
        
        NhanVien nv = dsNhanVien.stream()
                .filter(n -> n.getMaSo() == maSo)
                .findFirst()
                .orElse(null);
        
        if (nv != null) {
            dsNhanVien.remove(nv);
            System.out.println("Xoa nhan vien thanh cong!");
        } else {
            System.out.println("Khong tim thay nhan vien voi ma so: " + maSo);
        }
    }
    
    // 3. Tra cứu nhân viên
    public void traCuuNhanVien() {
        System.out.println("\n=== TRA CUU NHAN VIEN ===");
        System.out.println("1. Tim theo CMND");
        System.out.println("2. Tim theo ho ten");
        System.out.println("3. Tim theo que quan");
        System.out.print("Lua chon: ");
        int chon = Integer.parseInt(sc.nextLine());
        
        System.out.print("Nhap thong tin can tim: ");
        String tuKhoa = sc.nextLine().toLowerCase();
        
        List<NhanVien> ketQua = new ArrayList<>();
        
        switch (chon) {
            case 1:
                ketQua = dsNhanVien.stream()
                        .filter(nv -> nv.getCmnd().toLowerCase().contains(tuKhoa))
                        .toList();
                break;
            case 2:
                ketQua = dsNhanVien.stream()
                        .filter(nv -> nv.getHoTen().toLowerCase().contains(tuKhoa))
                        .toList();
                break;
            case 3:
                ketQua = dsNhanVien.stream()
                        .filter(nv -> nv.getQueQuan().toLowerCase().contains(tuKhoa))
                        .toList();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay nhan vien nao!");
        } else {
            System.out.println("Tim thay " + ketQua.size() + " nhan vien:");
            ketQua.forEach(nv -> nv.hienThi());
        }
    }
    
    // 4. Hiển thị danh sách nhân viên
    public void hienThiDanhSach() {
        System.out.println("\n=== DANH SACH NHAN VIEN ===");
        if (dsNhanVien.isEmpty()) {
            System.out.println("Danh sach rong!");
        } else {
            dsNhanVien.forEach(nv -> nv.hienThi());
        }
    }
    
    // 5. Tính lương nhân viên
    public void tinhLuong() {
        System.out.println("\n=== TINH LUONG NHAN VIEN ===");
        if (dsNhanVien.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        
        System.out.printf("%-10s %-25s %-15s %-20s\n", 
                "Ma so", "Ho ten", "So ngay cong", "Tien luong");
        System.out.println("-----------------------------------------------------------------------");
        
        for (NhanVien nv : dsNhanVien) {
            System.out.print("Nhap so ngay cong cua " + nv.getHoTen() + ": ");
            int soNgayCong = Integer.parseInt(sc.nextLine());
            
            // Đa hình: Gọi phương thức tinhLuong() của từng lớp con
            // Không cần if/else hay switch/case
            double tienLuong = nv.tinhLuong(soNgayCong);
            
            System.out.printf("%-10d %-25s %-15d %-,20.0f VND\n", 
                    nv.getMaSo(), nv.getHoTen(), soNgayCong, tienLuong);
        }
    }
    
    // Menu chương trình
    public void menu() {
        int chon;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Tra cuu nhan vien");
            System.out.println("4. Hien thi danh sach nhan vien");
            System.out.println("5. Tinh luong nhan vien");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            chon = Integer.parseInt(sc.nextLine());
            
            switch (chon) {
                case 1:
                    themNhanVien();
                    break;
                case 2:
                    xoaNhanVien();
                    break;
                case 3:
                    traCuuNhanVien();
                    break;
                case 4:
                    hienThiDanhSach();
                    break;
                case 5:
                    tinhLuong();
                    break;
                case 6:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 6);
    }
    
    public List<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }
}
