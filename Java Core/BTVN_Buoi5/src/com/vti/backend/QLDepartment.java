package com.vti.backend;

import com.vti.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class QLDepartment {

    private List<Department> listdpartments = new ArrayList<>();

    public void addDepartment(Department de) {
        listdpartments.add(de);
        System.out.println("Đã thêm Department thành công:  " );
    }

    public void timTheoTenPB(String ten) {
        boolean check = false;
        for (Department de : listdpartments) {
            if (de.getDepartmentName().equalsIgnoreCase(ten)) {
                System.out.println(de);
                check = true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy account cua phong ban: " + ten);
        }
    }

    public void showDepartment() {
        System.out.println("Danh sách Department:");
        for (Department de : listdpartments) {
            System.out.println(de);
        }
    }

    public List<Department> getListdpartments() {
        return listdpartments;
    }
}
