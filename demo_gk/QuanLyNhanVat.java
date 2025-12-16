package com.ntl.demo_gk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyNhanVat {

    protected List<NhanVat> ds = new ArrayList<>(); // Danh sách nhân vật

    public void themNV(NhanVat... a) {
        this.ds.addAll(Arrays.asList(a));
    }

//    public void themNV(NhanVat... a) {
//        for (NhanVat nv : a) {
//            ds.add(nv);
//        }
//    }
    public void hienThi() {
        this.ds.forEach(n -> n.hienThi());
        // Duyệt từng NhanVat trong ds
    }

//    public void hienThi() {
//        for (NhanVat nv : ds) {
//            nv.hienThi();
//        }
//    }
    public int demLuotChoi(int id) {
        NhanVat n = this.ds.stream().filter(nv -> nv.getId() == id).findFirst().get();
        // stream() → tạo luồng dữ liệu
        // filter() → lọc nhân vật có id trùng
        // findFirst() → lấy nhân vật đầu tiên tìm được
        // get() → lấy đối tượng
        if (n != null) {
            return n.demLuotChoi();
        }
        return 0;
    }

//    public int demLuotChoi(int id) {
//        for (NhanVat nv : ds) {
//            if (nv.getId() == id) {
//                return nv.demLuotChoi();
//            }
//        }
//        return 0; // không tìm thấy
//    }
    public void sapSapGiamDan() {
        this.ds.sort((h1, h2) -> -(h1.getVp().size() - h2.getVp().size()));
    }

    public void sapXepTangDan() {
        ds.sort((h1, h2) -> h1.getVp().size() - h2.getVp().size());
    }

    public List<NhanVat> getDs() {
        return ds;
    }

    public void setDs(List<NhanVat> ds) {
        this.ds = ds;
    }

}
