package server;

import model.SinhVien;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private boolean success;
    private String message;
    private SinhVien sinhVien;
    private List<SinhVien> list;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, SinhVien sinhVien) {
        this.success = success;
        this.message = message;
        this.sinhVien = sinhVien;
    }

    public Response(boolean success, String message, List<SinhVien> list) {
        this.success = success;
        this.message = message;
        this.list = list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public List<SinhVien> getList() {
        return list;
    }
}