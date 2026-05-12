package com.vti.backend;

import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;


public class QLDepartment {

    //update department với id là id và tên mới là newName
    public static boolean updateDepartment(int id, String newName) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: update phòng ban với id là id và tên mới là newName
            String sql = "update department set department_name = ? where department_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);// truyền giá trị newName vào ? đầu tiên
            statement.setInt(2, id);// truyền giá trị id vào ? thứ hai
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // xóa phòng ban
    public static boolean deleteDepartment(String deletname) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: xóa phòng ban với id là id
            String sql = "delete from department /n" + "Where department_name like ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, deletname);// truyền giá trị id vào ? đầu tiên
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }


    // tạo phòng ban vói tên từ bên ngoài
    public static boolean createDepartment(String name) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: tạo phòng ban với tên là name
            String sql = "insert into department(department_name) values (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);// truyền giá trị name vào ? đầu tiên
            int rowsAffected = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            int c = statement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // lấy ds các phòng ban trong DB và in ra
    public static List<Department> findAllDepartment() throws ClassNotFoundException{
        List<Department> departments = new ArrayList<>();
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
        return departments;
    }

    // tìm các phòng ban có chữ xyz  chưa biết trước
    //  select * from department where department_name like '...';

    public static List<Department> findByNameAndId(String searchName, int searchId) throws ClassNotFoundException{
        List<Department> departments = new ArrayList<>();
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from department where department_name like ? and department_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);// truyền giá trị searchName vào ? đầu tiên
            statement.setInt(2, searchId);// truyền giá trị 2 vào ? thứ2
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return departments;
    }

    public static List<Department> showDepartmentGreaterOrEqualsTo2() throws ClassNotFoundException{
        List<Department> departments = new ArrayList<>();
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select de.*\n" +
                    "from department de\n" +
                    "join account acc on de.department_id = acc.department_id\n" +
                    "group by de.department_id\n" +
                    "having count(de.department_id) >= 2;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  departments;
    }
}
