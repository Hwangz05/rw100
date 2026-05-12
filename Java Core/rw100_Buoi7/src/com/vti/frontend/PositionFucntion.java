package com.vti.frontend;

import com.vti.backend.QLDepartment;
import com.vti.backend.QLPosition;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.util.List;
import java.util.Scanner;

public class PositionFucntion {
    private static Scanner scanner = new Scanner(System.in);

        public static void run() throws ClassNotFoundException {
            while (true) {
                System.out.println("=== Mời bạn chọn chức năng ===");
                System.out.println("1. Xem danh sach chu vu");
                System.out.println("2. Thêm mới chu vu moi");
                System.out.println("3. Update chuc vu");
                System.out.println("4. Xóa xoa chuc vu");
                System.out.println("5. Tìm kiếm chuc vu theo ten");
                System.out.println("6. Thoát");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        List<Position> positions = QLPosition.findAllPosition();
                        showPosition(positions);
                        break;
                    case "2":
                        insertPosition();
                        break;
                    case "3":
                        updatePosition();
                        break;
                    case "4":
                        deletePosition();
                        break;
                    case "5":
                        findPositionByName();
                        break;
                    case "6":
                        return;
                    default:
                        System.out.println("Chọn sai, chọn lại!");

                }
            }
        }

    public static void showPosition(List<Position> positions){
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position po : positions) {
            System.out.printf("|%5s|%20s|\n", po.getPositionId(), po.getPositionName());
        }
        System.out.println("+-----+--------------------+");
    }

    public static void findPositionByName() throws ClassNotFoundException {
        System.out.println("Nhập tên Chuc vu cần tìm: ");
        String name = scanner.nextLine();
        java.util.List<Position> positions = QLPosition.findByName(name);
        showPosition(positions);
    }

    public static void updatePosition() throws ClassNotFoundException {
        System.out.println("Nhập ID Chu vu cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên Chuc vu cần sửa: ");
        String name = scanner.nextLine();
        boolean check = QLPosition.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }

    public static void deletePosition() throws ClassNotFoundException {
        System.out.println("Nhập tên Chuc vu cần xóa: ");
        String name = scanner.nextLine();
        boolean check = QLPosition.deletePosition(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }

    public static void insertPosition() throws ClassNotFoundException {
        System.out.println("Nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = QLPosition.createPosition(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }

    public static void showDepartment(List<Department> departments) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (Department department : departments) {
            System.out.printf("|%5s|%20s|\n", department.getDepartmentId(), department.getDepartmentName());
        }
        if (departments.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
}
