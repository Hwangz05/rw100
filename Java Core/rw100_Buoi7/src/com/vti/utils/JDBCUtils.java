package com.vti.utils;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "252005";// mk mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
        return null;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối thành công!");
            } catch (SQLException e) {
                System.out.println("Lỗi đóng kết nối: " + e.getMessage());
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
                System.out.println("Đóng ResultSet thành công!");
            } catch (SQLException e) {
                System.out.println("Lỗi đóng ResultSet: " + e.getMessage());
            }
        }
        if(statement != null) {
            try {
                statement.close();
                System.out.println("Đóng Statement thành công!");
            } catch (SQLException e) {
                System.out.println("Lỗi đóng Statement: " + e.getMessage());
            }
        }
    }
}
