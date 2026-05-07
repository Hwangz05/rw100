package com.vti.backend;

import com.vti.entity.*;
import java.util.ArrayList;
import java.util.List;

public class QLCB {
    private List<CanBo> danhSachCanBo = new ArrayList<>();

    public void themCanBo(CanBo cb) {
        danhSachCanBo.add(cb);
        System.out.println("Đã thêm cán bộ thành công:  " );
    }

    public void timTheoTen(String ten) {
        boolean check = false;
        for (CanBo cb : danhSachCanBo) {
            if (cb.getHoTen().equalsIgnoreCase(ten)) {
                System.out.println(cb);
                check = true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy cán bộ có tên: " + ten);
        }
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách cán bộ:");
        for (CanBo cb : danhSachCanBo) {
            System.out.println(cb);
        }
    }

    public void xoaTheoTen(String ten) {
        List<CanBo> canBoToRemove = new ArrayList<>();
        for (CanBo cb : danhSachCanBo) {
            if (cb.getHoTen().equalsIgnoreCase(ten)) {
                canBoToRemove.add(cb);
            }
        }
        if (!canBoToRemove.isEmpty()) {
            danhSachCanBo.removeAll(canBoToRemove);
            System.out.println("Đã xóa " + canBoToRemove.size() + " cán bộ có tên: " + ten);
        } else {
            System.out.println("Không tìm thấy cán bộ có tên: " + ten);
        }
    }
}