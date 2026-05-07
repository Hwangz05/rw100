package com.vti.frontend;

import com.vti.backend.QLAC;
import com.vti.backend.QLDepartment;
import com.vti.backend.QLPosition;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        QLAC qlacc = new QLAC();
        QLDepartment qldepartment = new QLDepartment();
        QLPosition qlposition = new QLPosition();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm Phòng ban");
            System.out.println("2. Thêm Chức Vụ");
            System.out.println("3. Thêm Account");
            System.out.println("4. Xem danh sách phòng ban");
            System.out.println("5. Xóa danh sách chức vụ");
            System.out.println("6. xem danh sách account");
            System.out.println("7. tìm kiếm account theo tên phòng ban");
            System.out.println("8. tìm kiếm account theo tên Chức vụ");
            System.out.println("9. Xóa danh sách account theo Fullname");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Nhập  thông tin Phòng ban:  ");
                    System.out.println("Nhập id phòng ban: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tên phòng ban: ");
                    String ten = sc.nextLine();
                    qldepartment.addDepartment(new Department(id, ten));
                    break;
                case "2":
                    System.out.println("Nhập  thông tin Chức vụ:  ");
                    System.out.println("Nhập id chức vụ: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();

                    while (true) {
                        System.out.println("Tên chức vụ: 1. DEV   2. TEST   3. SCRUM_MASTER  4. PM: ");
                        String poInput = sc.nextLine();
                        Position.PositionName tencv;
                        switch (poInput) {
                            case "1":
                                tencv = Position.PositionName.DEV;
                                break;
                            case "2":
                                tencv = Position.PositionName.TEST;
                                break;
                            case "3":
                                tencv = Position.PositionName.SCRUM_MASTER;
                                break;
                            case "4":
                                tencv = Position.PositionName.PM;
                                break;
                            default:
                                System.out.println("không có phòng ban này! Vui lòng nhập lại");
                                continue;
                        }
                        qlposition.addPosition(new Position(id1, tencv));
                        break;
                    }
                    break;
                case "3":
                    System.out.println("Nhập  thông tin Account cần thêm:  ");
                    System.out.println("Nhập id account: ");
                    int accountId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập username: ");
                    String userName = sc.nextLine();
                    System.out.println("Nhập fullname: ");
                    String fullName = sc.nextLine();

                    System.out.println("Chọn phòng ban:");
                    qldepartment.showDepartment();
                    System.out.print("Nhập id phòng ban: ");
                    int depId = sc.nextInt();
                    sc.nextLine();
                    Department departmentid = null;
                    for (Department de : qldepartment.getListdpartments()) {
                        if (de.getDepartmentId() == depId) {
                            departmentid = de;
                            break;
                        }
                    }

                    if (departmentid == null) {
                        System.out.println("Không tìm thấy phòng ban!");
                        break;
                    }

                    System.out.println("Chọn chức vụ:");
                    qlposition.showPosition();
                    System.out.print("Nhập id chức vụ: ");
                    int posId = sc.nextInt();
                    sc.nextLine();

                    Position positionid = null;
                    for (Position po : qlposition.getListpositions()) {
                        if (po.getPositionId() == posId) {
                            positionid = po;
                            break;
                        }
                    }
                    if (positionid == null) {
                        System.out.println("Không tìm thấy chức vụ!");
                        break;
                    }
                    Account account = new Account( accountId, email, userName, fullName, departmentid, positionid);
                    qlacc.addAccount(account);
                    System.out.println("Thêm account thành công!");
                    break;
                case "4":
                    qldepartment.showDepartment();
                    break;
                case "5":
                    qlposition.showPosition();
                    break;
                case "6":
                    qlacc.showAccount();
                    break;
                case "7":
                    System.out.println("Nhập tên phòng ban cần tìm kiếm: ");
                    String tenpb = sc.nextLine();
                    qlacc.timTheoTenPB(tenpb);
                    break;
                case "8":
                    System.out.println("Nhập tên chức vụ cần tìm kiếm: ");
                    String tencv = sc.nextLine();
                    qlacc.timTheoTenCV(tencv);
                    break;
                case "9":
                    System.out.println("Nhập fullname của account cần xóa: ");
                    String fullname = sc.nextLine();
                    qlacc.deleteAccountByFullName(fullname);
                    break;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
