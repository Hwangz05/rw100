package com.vti.frontend;

import com.vti.entity.*;

public class Program6 {
    public static void main(String[] args) {
        VietnamesePhone phone = new VietnamesePhone();
        phone.insertContact("An", "123");
        phone.insertContact("Binh", "456");

        System.out.println("Danh sách:");
        phone.hienThiDanhSach();

        System.out.println("\nTìm An:");
        phone.searchContact("An");

        System.out.println("\nUpdate An:");
        phone.updateContact("An", "999");
        phone.searchContact("An");

        System.out.println("\nXóa Bình:");
        phone.removeContact("Binh");
        phone.hienThiDanhSach();


        System.out.println("\n=======Q2-3=======");
        User e = new Employee("An", 2.5);
        User m = new Manager("Binh", 3.0);
        User w = new Waiter("Cuong", 1.8);

        System.out.println("=== Employee ===");
        e.displayInfor();

        System.out.println("\n=== Manager ===");
        m.displayInfor();

        System.out.println("\n=== Waiter ===");
        w.displayInfor();
    }
}
