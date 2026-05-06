package com.vti.entity;

public class Department {
    private int departmentId;
    private String departmentName;


    /*Question 1:
    Tạo constructor cho department:
    a, không có parameters
    b, Có 1 parameter là nameDepartment và default id của Department = 0
    Khởi tạo 1 Object với mỗi constructor ở trên*/


    public Department() {
    }

    public Department(String departmentName) {
        this.departmentId = 0;
        this.departmentName = departmentName;
    }



    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}