package com.vti.backend;

import com.vti.entity.Department;
import com.vti.entity.Position;

import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    private List<Position> listpositions = new ArrayList<>();

    public void addPosition(Position po) {
        listpositions.add(po);
        System.out.println("Đã thêm Position thành công:  " );
    }

    public void timTheoTenPB(String ten) {
        boolean check = false;
        for (Position po : listpositions) {
            if (po.getPositionName().equals(ten)) {
                System.out.println(po);
                check = true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy account cua chuc vu: " + ten);
        }
    }

    public void showPosition() {
        System.out.println("Danh sách Positions:");
        for (Position po : listpositions) {
            System.out.println(po);
        }
    }

    public List<Position> getListpositions() {
        return listpositions;
    }
}
