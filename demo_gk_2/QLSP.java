package com.ntl.demo_gk_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class QLSP {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<SanPham> ds;

    public QLSP(String path) {
        ds = new ArrayList<>();
        df.setLenient(false);

        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.trim().split(", ");
                SanPham sp = null;
                if (info.length == 4) {
                    sp = new SanPham(
                            info[0],
                            df.parse(info[1]),
                            Double.parseDouble(info[2]),
                            Integer.parseInt(info[3])
                    );
                } else {
                    sp = new SanPhamKhuyenMai(
                            info[0],
                            df.parse(info[1]),
                            Double.parseDouble(info[2]),
                            Integer.parseInt(info[3]),
                            Integer.parseInt(info[4])
                    );
                }
                ds.add(sp);
            }
            sc.close();
        } catch (FileNotFoundException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (SanPham sp : ds) {
            s += sp;
            s += "\n";
        }
        return s;
    }

    public void themSP(SanPham sp) {
        ds.add(sp);
        try {
            FileWriter f = new FileWriter("D:\\SanPham.txt", true);
            PrintWriter writer = new PrintWriter(f);
            writer.printf("\n%s, %s, %.0f, %d", sp.getTenSP(), df.format(sp.getNgayNhap()),
                    sp.getDonGia(), sp.getSoLuong());
            if (sp instanceof SanPhamKhuyenMai) {
                SanPhamKhuyenMai sp2 = (SanPhamKhuyenMai) sp;
                writer.printf(", %d", sp2.getGiaGiam());
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sapXep() {
        ds.sort((SanPham s1, SanPham s2) -> -s1.soSanh(s2));
    }

    public void locTheoTen(char k) {
        ds.stream().filter(sp -> sp.getTenSP().charAt(0) == k)
                .forEach(sp -> System.out.println(sp));
    }

    public void locTheoSoLuong(int n) {
        ds.stream().filter(sp -> sp.getSoLuong() > n)
                .forEach(sp -> System.out.println(sp));
    }

    public void top5() {
        sapXep();
        try {
            FileWriter f = new FileWriter("src/main/source/Top5.txt");
            PrintWriter writer = new PrintWriter(f);
            for (int i = 0; i < 5; i++) {
                writer.println(ds.get(i));
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

