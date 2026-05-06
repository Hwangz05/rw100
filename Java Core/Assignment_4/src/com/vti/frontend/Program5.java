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
                    System.out.print("Nhập loại (1: CN, 2: KS, 3: NV): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tên: ");
                    String ten = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int tuoi = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Giới tính (NAM/NU/KHAC): ");
                    CanBo.GioiTinh gt = CanBo.GioiTinh.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Địa chỉ: ");
                    String dc = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Bậc: ");
                        int bac = sc.nextInt();
                        sc.nextLine();
                        qlcb.themCanBo(new CongNhan(ten, tuoi, gt, dc, bac));
                    } else if (type == 2) {
                        System.out.print("Ngành: ");
                        String nganh = sc.nextLine();
                        qlcb.themCanBo(new KySu(ten, tuoi, gt, dc, nganh));
                    } else {
                        System.out.print("Công việc: ");
                        String cv = sc.nextLine();
                        qlcb.themCanBo(new NhanVien(ten, tuoi, gt, dc, cv));
                    }
                    break;

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
