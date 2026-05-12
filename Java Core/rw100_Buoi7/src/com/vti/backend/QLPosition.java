package com.vti.backend;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {


    // xóa chức vụ với tên là deletname
    public static boolean deletePosition(String deletname) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: xóa chức vụ với tên là deletname
            String sql = "delete from position /n" + "Where position_name like ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, deletname);// truyền giá trị id vào ? đầu tiên
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    // tạo chức vụ vói tên từ bên ngoài
    public static boolean createPosition(String name) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: tạo chức vụ với tên là name
            String sql = "insert into position(position_name) values (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);// truyền giá trị name vào ? đầu tiên
            int c = statement.executeUpdate();// thực thi câu lệnh sql và trả về số dòng bị ảnh hưởng
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    // update chức vụ với id là id
    public static boolean updatePosition(int id, String newName) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: update chức vụ với id là id và tên mới là newName
            String sql = "update position set position_name = ? where position_id = ?;";
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


    // lấy ds các chuc vu trong DB và in ra
    public static List<Position> findAllPosition() throws ClassNotFoundException {
        List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn position_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn position_name
                Position po = new Position(id, Position.PositionName.valueOf(name));
                positions.add(po);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }


    public static List<Position> findByName(String searchName) throws ClassNotFoundException {
        List<Position> positions = new ArrayList<>();
        try {
            // b1: kết nối đến DB
            Connection connection = new JDBCUtils().getConnection();
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from position where position_name like ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);// truyền giá trị searchName vào ? đầu tiên
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn position_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn position_name
                Position po = new Position(id, Position.PositionName.valueOf(name));
                positions.add(po);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }
}
