package com.ntl.demo_gk;

public abstract class VatPham {

    protected String maVP;

    public void hienThi() {
        System.out.printf("Ma vp: %s\n", this.maVP);
    }

    public String getMaVP() {
        return maVP;
    }

    public void setMaVP(String maVP) {
        this.maVP = maVP;
    }

}
