package com.vti.entity;

public class CongNhan extends CanBo {
    private int bac;

    public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        if (bac >= 1 && bac <= 10) {
            this.bac = bac;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Bac: " + bac;
    }
}