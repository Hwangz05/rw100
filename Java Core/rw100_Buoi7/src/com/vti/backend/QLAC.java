package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QLAC {
    // update 1 account trong DB
    public static boolean updateAccount(int id, String newEmail) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: update account với id là id và email mới là newEmail
            String sql = "update account set email = ? where account_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newEmail);// truyền giá trị newEmail vào ? đầu tiên
            statement.setInt(2, id);// truyền giá trị id vào ? thứ hai
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // xoa 1 account trong DB
    public static boolean deleteAccount(int id) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: xóa account với id là id
            String sql = "delete from account /n" + "Where account_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);// truyền giá trị id vào ? đầu tiên
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // them 1 account vào DB
    public static boolean createAccount(int accountId, String email, String userName, String fullName, int departmentID, int positionID) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: tạo account với email, userName, fullName, departmentID, positionID là các giá trị được truyền vào
            String sql = "insert into account(accountId, email, username, full_name, department_id, position_id) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, accountId);
            statement.setString(2, email);// truyền giá trị email vào ? đầu tiên
            statement.setString(3, userName);// truyền giá trị userName vào ? thứ hai
            statement.setString(4, fullName);// truyền giá trị fullName vào ? thứ ba
            statement.setInt(5, departmentID);// truyền giá trị departmentID vào ? thứ tư
            statement.setInt(6, positionID);// truyền giá trị positionID vào ? thứ năm
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // lấy ds các account trong DB và in ra
    public static List<Account> findAllAccount() throws ClassNotFoundException {
            List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                LocalDate createDate = rs.getDate("create_date").toLocalDate();

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, Position.PositionName.valueOf(positionName));

                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                accounts.add(account);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
        return accounts;
    }

    public static List<Account> findByUserNameAndFullName(String usernameSearch, String fullNameSearch) throws ClassNotFoundException {
            List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id " +
                    "where acc.username like ? and full_name like ? ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + usernameSearch + "%");
            statement.setString(2, "%" + fullNameSearch + "%");
            ResultSet rs = statement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                LocalDate createDate = rs.getDate("create_date").toLocalDate();

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, Position.PositionName.valueOf(positionName));

                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
