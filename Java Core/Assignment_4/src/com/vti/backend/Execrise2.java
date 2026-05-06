package com.vti.backend;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;

import java.util.ArrayList;
import java.util.List;

public class Execrise2 {
    private List<CanBo> danhSach = new ArrayList<>();

    // Question 2: QLCB
    public void question2() {

        // Thêm cán bộ
        danhSach.add(new CongNhan("A", 30, CanBo.GioiTinh.NAM, "HN", 5));
        danhSach.add(new KySu("B", 28, CanBo.GioiTinh.NU, "HCM", "CNTT"));

        // Hiển thị
        System.out.println("Danh sách cán bộ:");
        for (CanBo cb : danhSach) {
            System.out.println(cb);
        }

        // Tìm kiếm
        System.out.println("\nTìm theo tên A:");
        for (CanBo cb : danhSach) {
            if (cb.getHoTen().equalsIgnoreCase("A")) {
                System.out.println(cb);
            }
        }

        // Xóa
        danhSach.removeIf(cb -> cb.getHoTen().equalsIgnoreCase("A"));

        System.out.println("\nSau khi xóa:");
        for (CanBo cb : danhSach) {
            System.out.println(cb);
        }
    }
}
