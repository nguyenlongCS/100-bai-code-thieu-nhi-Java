package com.ntl.th4_c3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MuiTiem {
    
    private VacXin vacXin;      // Loại vắc xin
    private LocalDate ngayTiem; // Ngày tiêm
    private String diaDiem;     // Địa điểm tiêm
    
    public MuiTiem(VacXin vacXin, LocalDate ngayTiem, String diaDiem) {
        this.vacXin = vacXin;
        this.ngayTiem = ngayTiem;
        this.diaDiem = diaDiem;
    }
    
    public void hienThi() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("  - Vac xin: %s - Ngay tiem: %s - Dia diem: %s\n",
                vacXin.getTenVacXin(), ngayTiem.format(df), diaDiem);
    }
    
    public VacXin getVacXin() {
        return vacXin;
    }
    
    public LocalDate getNgayTiem() {
        return ngayTiem;
    }
    
    public String getDiaDiem() {
        return diaDiem;
    }
}
