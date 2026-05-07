package com.vti.frontend;

import com.vti.backend.QLCB;
import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        QLCB qlcb = new QLCB();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm cán bộ");
            System.out.println("2. Tìm theo tên");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Xóa theo tên");
            System.out.println("5. Thoát");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nhập  thông tin:  ");
                    System.out.print("Tên: ");
                    String ten = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int tuoi = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Giới tính: 1. NAM   2. NU   KHAC. KHAC ");
                    String gtInput = sc.nextLine();
                    CanBo.GioiTinh gt;
                    switch (gtInput) {
                        case "1":
                            gt = CanBo.GioiTinh.NAM;
                            break;
                        case "2":
                            gt = CanBo.GioiTinh.NU;
                            break;
                        default:
                            gt = CanBo.GioiTinh.KHAC;
                    }

                    System.out.print("Địa chỉ: ");
                    String dc = sc.nextLine();

                    System.out.print("Chọn loại cán bộ: 1. Công nhân   2. Kỹ sư   3. Nhân viên: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    switch (type) {
                        case 1:
                            System.out.print("Bậc: ");
                            int bac = sc.nextInt();
                            sc.nextLine();
                            qlcb.themCanBo(new CongNhan(ten, tuoi, gt, dc, bac));
                            System.out.println("Thêm công nhân thành công!");
                            break;
                        case 2:
                            System.out.print("Ngành: ");
                            String nganh = sc.nextLine();
                            qlcb.themCanBo(new KySu(ten, tuoi, gt, dc, nganh));
                            System.out.println("Thêm kỹ sư thành công!");
                            break;
                        case 3:
                            System.out.print("Công việc: ");
                            String cv = sc.nextLine();
                            qlcb.themCanBo(new NhanVien(ten, tuoi, gt, dc, cv));
                            System.out.println("Thêm nhân viên thành công!");
                            break;
                        default:
                            System.out.println("Loại cán bộ không hợp lệ!");
                    }
                case "2":
                    System.out.print("Nhập tên cần tìm: ");
                    qlcb.timTheoTen(sc.nextLine());
                    break;

                case "3":
                    qlcb.hienThiDanhSach();
                    break;

                case "4":
                    System.out.print("Nhập tên cần xóa: ");
                    qlcb.xoaTheoTen(sc.nextLine());
                    break;

                case "5":
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
