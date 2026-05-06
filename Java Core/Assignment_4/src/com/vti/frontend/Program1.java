package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.util.Date;

public class Program1 {
    public static void main(String[] args) {
        System.out.println("=== question 1 ===");

        Department d1 = new Department();
        System.out.println("d1 -> id: " + d1.getDepartmentId() + ", name: " + d1.getDepartmentName());

        Department d2 = new Department("HR");
        System.out.println("d2 -> id: " + d2.getDepartmentId() + ", name: " + d2.getDepartmentName());

        System.out.println("=== question 2 ===");
        //a
        Account a1 = new Account(1, "a@gmail.com", "userA", "Nguyen", "An");
        System.out.println("a1 -> id: " + a1.getAccountId() +  ", email: " + a1.getEmail() + ", username: " + a1.getUserName() + ", fullName: " + a1.getFullName());
        // b) Có thông tin cơ bản
        Account acc2 = new Account(2, "a@gmail.com", "userA", "Nguyen", "An");

        // c) Có position, createDate = now
        Position dev = new Position(1, Position.PositionName.DEV);
        Position test = new Position(2, Position.PositionName.TEST);

        Account acc3 = new Account(3, "b@gmail.com", "userB", "Tran", "Binh", dev);

        // d) Full constructor
        Account acc4 = new Account(3, "c@gmail.com", "userC", "Le", "Cuong", test, new Date());

        System.out.println(acc2.getFullName());
        System.out.println(acc3.getCreateDate());
    }

}
