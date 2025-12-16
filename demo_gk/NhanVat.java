package com.ntl.demo_gk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NhanVat {

    private static int dem;
    private int id = ++dem;   // So nguyen tang dan
    private String tenNV;     // Ten nhan vat
    private List<VatPham> vp; // Danh sach <vat pham>

    public NhanVat(String tenNV) {
        this.tenNV = tenNV;
        this.vp = new ArrayList<>(); // Tạo danh sách rỗng để lưu vật phẩm
        // Mỗi nhân vật có danh sách vật phẩm riêng
    }

    public void hienThi() {
        System.out.printf("%d - %s\n", this.id, this.tenNV);
        // &d: so nguyen
        // %s: chuoi
        if (!this.vp.isEmpty()) {   // Nếu danh sách vật phẩm không rỗng
            this.vp.forEach(v -> v.hienThi());
            // forEach duyệt từng phần tử trong vp
            // v.hienthi() hàm hiển thị của từng vật phẩm trong lớp vật phẩm
        }
    }

    public void themVP(VatPham... a) {
        // VatPham... a tương tự VatPham[] a
        // Cho phép truyền 0,1 và nhiều tham số
        // themVP(vp1, vp2, vp3);
        this.vp.addAll(Arrays.asList(a));
        // Arrays.asList(a)): Chuyển mảng a thành một List<VatPham>
        // addAll(...) thêm toàn bộ phần tử từ danh sách truyền vào
    }

//    public void themVP(VatPham... a) {
//        for (VatPham v : a) {
//            this.vp.add(v);
//        }
//    }

    public int demLuotChoi() {
        int d = 0;
        for (VatPham v : this.vp) { //var
            if (v instanceof VPLuotChoi) {
                d += ((VPLuotChoi) v).getSoLuotTang();
                // (VPLuotChoi) v: ép kiểu
                // Gọi hàm getSoLuotTang() để lấy số lượt được tăng
                // Cộng dồn vào d
            }
        }
        return d;
    }

    public int getId() {
        return id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public List<VatPham> getVp() {
        return vp;
    }

    public void setVp(List<VatPham> vp) {
        this.vp = vp;
    }

}
