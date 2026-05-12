package dao;

import model.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    public boolean insert(SinhVien sv) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO sinhvien(maSV, hoTen, ngaySinh, gioiTinh, ngheNghiep) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getNgaySinh());
            ps.setString(4, sv.getGioiTinh());
            ps.setString(5, sv.getNgheNghiep());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("[SERVER] Kết nối DB: " + con);  // thêm dòng này
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("[SERVER] Đọc được: " + rs.getString("maSV")); // thêm dòng này
                list.add(new SinhVien(
                        rs.getString("hoTen"),
                        rs.getString("maSV"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("ngheNghiep")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // phải có dòng này để thấy lỗi
        }
        return list;
    }

    public boolean delete(String maSV) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "DELETE FROM sinhvien WHERE maSV=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    // ================= UPDATE =================
    public boolean update(SinhVien sv) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "UPDATE sinhvien SET hoTen=?, ngaySinh=?, gioiTinh=?, ngheNghiep=? WHERE maSV=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getNgaySinh());
            ps.setString(3, sv.getGioiTinh());
            ps.setString(4, sv.getNgheNghiep());
            ps.setString(5, sv.getMaSV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public SinhVien findById(String maSV) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM sinhvien WHERE maSV=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSV);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SinhVien(
                        rs.getString("hoTen"),
                        rs.getString("maSV"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("ngheNghiep")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}