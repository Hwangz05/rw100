package server;

import model.SinhVien;

import java.io.Serializable;

public class Request implements Serializable {

    private String action;
    private SinhVien sinhVien;
    private String maSV;

    public Request(String action, SinhVien sinhVien) {
        this.action = action;
        this.sinhVien = sinhVien;
    }

    public Request(String action, String maSV) {
        this.action = action;
        this.maSV = maSV;
    }

    public String getAction() {
        return action;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public String getMaSV() {
        return maSV;
    }
}