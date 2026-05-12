package com.vti.frontend;

import com.vti.backend.QLAC;
import com.vti.backend.QLDepartment;
import com.vti.entity.Account;
import com.vti.entity.Department;

import java.util.List;
import java.util.Scanner;

public class AccountFucntion {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds tài khoản");
            System.out.println("2. Thêm mới tài khoản");
            System.out.println("3. Update tài khoản");
            System.out.println("4. Xóa tài khoản");
            System.out.println("5. Tìm kiếm tài khoản bằng fullname và username");
            System.out.println("6. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Account> accounts = QLAC.findAllAccount();
                    showAccount(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    updateAccount();
                    break;
                case "4":
                    deleteAccount();
                    break;
                case "5":
                    findAccountByUserNameAndFullName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }

    public static void findAccountByUserNameAndFullName() throws ClassNotFoundException {
        System.out.println("Nhập username cần tìm: ");
        String username = scanner.nextLine()
        System.out.println("Nhập fullname  cần tìm: ");
        String name = scanner.nextLine();
        java.util.List<Account> accounts = QLAC.findByUserNameAndFullName(username, name);
        showAccount(accounts);
    }

    public static void updateAccount() throws ClassNotFoundException {
        System.out.println("Nhập ID Account cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên Account cần sửa: ");
        String name = scanner.nextLine();
        boolean check = QLAC.updateAccount(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }

    public static void deleteAccount() throws ClassNotFoundException {
        System.out.println("Nhập tên id Account cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean check = QLAC.deleteAccount(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }

    public static void insertAccount() throws ClassNotFoundException {
        System.out.println("Nhập ID Account cần thêm: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập email Account cần thêm: ");
        String email = scanner.nextLine();
        System.out.println("Nhập username Account cần thêm: ");
        String username = scanner.nextLine();
        System.out.println("Nhập fullname Account cần thêm: ");
        String fullname = scanner.nextLine();
        System.out.println("Nhập departmentID Account cần thêm: ");
        int departmentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập positionID Account cần thêm: ");
        int positionID = scanner.nextInt();
        scanner.nextLine();
        boolean check = QLAC.createAccount(id, email, username, fullname, departmentID, positionID);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }


    public static void showAccount(List<Account> accounts) {
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", "ID", "FullName", "Email", "Username", "Tên phòng ban", "Tên chức vụ");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for (Account account : accounts) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", account.getAccountId(), account.getFullName(), account.getEmail(), account.getUserName(), account.getDepartment().getDepartmentName(), account.getPosition().getPositionName());
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");

        ;
    }

}
