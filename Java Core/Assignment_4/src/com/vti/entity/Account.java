package com.vti.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private String firstName;
    private String lastName;
    private Department department;
    private Position position;
    private LocalDateTime createDate;

    /*Question 2:
    Tạo constructor cho Account:
    a, Không có parameters
    b, Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    c, Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và
    Position của User, default createDate = now
    d, Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
    Khởi tạo 1 Object với mỗi constructor ở trên*/

    // a
    public Account() {
    }
    // b
    public Account(int accountId, String email, String userName, String firstName, String lastName) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = firstName + " " + lastName;
    }
    // c
    public Account(int accountId, String email, String userName, String firstName, String lastName, Position position) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = LocalDateTime.now();
    }
    // d
    public Account(int accountId, String email, String userName, String firstName, String lastName, Position position, Date createDate) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate  = LocalDateTime.now();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}