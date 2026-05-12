package client;

import model.SinhVien;
import server.Request;
import server.Response;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener {

    // ================= COMPONENT =================
    private JTextField txtHoTen;
    private JTextField txtMaSV;
    private JTextField txtNgaySinh;

    private JRadioButton rdNam;
    private JRadioButton rdNu;

    private JCheckBox chkGiaoVien;
    private JCheckBox chkLapTrinhVien;

    private JLabel lblStatus;

    private JButton btnConnect;
    private JButton btnGui;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnKetThuc;

    private JTable table;
    private DefaultTableModel tableModel;

    private ClientConnection clientConnection;
    private boolean isEditing = false;
    private String maSVDangSua = null;

    // ================= CONSTRUCTOR =================
    public MainFrame() {

        setTitle("QUẢN LÝ SINH VIÊN CLIENT");
        setSize(820, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        setVisible(true);
    }

    // ================= UI =================
    private void initUI() {

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font btnFont   = new Font("Segoe UI", Font.PLAIN, 13);

        // ── ROOT ──
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(root);

        // ══════════════ LEFT: FORM ══════════════
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(12, 14, 12, 14)
        ));
        formPanel.setPreferredSize(new Dimension(270, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets  = new Insets(6, 4, 6, 4);
        gbc.anchor  = GridBagConstraints.WEST;
        gbc.fill    = GridBagConstraints.HORIZONTAL;

        // Họ tên
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        JLabel lbHoTen = new JLabel("Họ tên:");
        lbHoTen.setFont(labelFont);
        formPanel.add(lbHoTen, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        txtHoTen = new JTextField();
        txtHoTen.setFont(fieldFont);
        formPanel.add(txtHoTen, gbc);

        // Mã SV
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        JLabel lbMaSV = new JLabel("Mã sinh viên:");
        lbMaSV.setFont(labelFont);
        formPanel.add(lbMaSV, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        txtMaSV = new JTextField();
        txtMaSV.setFont(fieldFont);
        formPanel.add(txtMaSV, gbc);

        // Ngày sinh
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        JLabel lbNgaySinh = new JLabel("Ngày sinh:");
        lbNgaySinh.setFont(labelFont);
        formPanel.add(lbNgaySinh, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        txtNgaySinh = new JTextField();
        txtNgaySinh.setFont(fieldFont);
        formPanel.add(txtNgaySinh, gbc);

        // Giới tính
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        JLabel lbGioiTinh = new JLabel("Giới tính:");
        lbGioiTinh.setFont(labelFont);
        formPanel.add(lbGioiTinh, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        genderPanel.setOpaque(false);
        rdNam = new JRadioButton("Nam");
        rdNu  = new JRadioButton("Nữ");
        rdNam.setFont(fieldFont);
        rdNu.setFont(fieldFont);
        ButtonGroup group = new ButtonGroup();
        group.add(rdNam);
        group.add(rdNu);
        rdNam.setSelected(true);
        genderPanel.add(rdNam);
        genderPanel.add(rdNu);
        formPanel.add(genderPanel, gbc);

        // Nghề nghiệp
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        JLabel lbNghe = new JLabel("Nghề nghiệp:");
        lbNghe.setFont(labelFont);
        formPanel.add(lbNghe, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        JPanel jobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        jobPanel.setOpaque(false);
        chkGiaoVien     = new JCheckBox("Giáo viên");
        chkLapTrinhVien = new JCheckBox("Lập trình viên");
        chkGiaoVien.setFont(fieldFont);
        chkLapTrinhVien.setFont(fieldFont);
        jobPanel.add(chkGiaoVien);
        jobPanel.add(chkLapTrinhVien);
        formPanel.add(jobPanel, gbc);

        // Status
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0;
        JLabel lbStatus = new JLabel("Status:");
        lbStatus.setFont(labelFont);
        formPanel.add(lbStatus, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        lblStatus = new JLabel("Chưa kết nối");
        lblStatus.setFont(fieldFont);
        lblStatus.setForeground(new Color(180, 60, 60));
        formPanel.add(lblStatus, gbc);

        // ── Spacer ──
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(Box.createVerticalGlue(), gbc);

        // ── Buttons ──
        gbc.gridy = 7; gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel btnPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        btnPanel.setOpaque(false);

        btnConnect  = new JButton("Connect");
        btnGui      = new JButton("Gửi thông tin");
        btnThem     = new JButton("Thêm");
        btnSua      = new JButton("Sửa");
        btnXoa      = new JButton("Xóa");
        btnKetThuc  = new JButton("Kết thúc");

        for (JButton btn : new JButton[]{btnConnect, btnGui, btnThem, btnSua, btnXoa, btnKetThuc}) {
            btn.setFont(btnFont);
            btn.setFocusPainted(false);
            btn.addActionListener(this);
        }

        btnPanel.add(btnConnect);
        btnPanel.add(btnGui);
        btnPanel.add(btnThem);
        btnPanel.add(btnSua);
        btnPanel.add(btnXoa);
        btnPanel.add(btnKetThuc);

        formPanel.add(btnPanel, gbc);

        // ══════════════ RIGHT: TABLE ══════════════
        String[] cols = {"Mã SV", "Họ tên", "Ngày sinh", "Giới tính", "Nghề nghiệp"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

        table = new JTable(tableModel);
        table.setFont(fieldFont);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(184, 207, 229));

        table.getColumnModel().getColumn(0).setPreferredWidth(85);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(65);
        table.getColumnModel().getColumn(4).setPreferredWidth(130);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        // ══════════════ ASSEMBLE ══════════════
        root.add(formPanel,  BorderLayout.WEST);
        root.add(scrollPane, BorderLayout.CENTER);
    }

    // ================= LẤY THÔNG TIN =================
    private SinhVien getSinhVienFromForm() {

        String hoTen = txtHoTen.getText();
        String maSV = txtMaSV.getText();
        String ngaySinh = txtNgaySinh.getText();

        String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";

        String nghe = "";

        if (chkGiaoVien.isSelected()) {
            nghe += "Giáo viên ";
        }

        if (chkLapTrinhVien.isSelected()) {
            nghe += "Lập trình viên";
        }

        return new SinhVien(
                hoTen,
                maSV,
                ngaySinh,
                gioiTinh,
                nghe
        );
    }

    // ================= RESET FORM =================
    private void resetForm() {

        txtHoTen.setText("");
        txtMaSV.setText("");
        txtNgaySinh.setText("");

        rdNam.setSelected(true);

        chkGiaoVien.setSelected(false);
        chkLapTrinhVien.setSelected(false);

        txtHoTen.requestFocus();
    }

    // ================= HIỂN THỊ =================
    private void setForm(SinhVien sv) {

        txtHoTen.setText(sv.getHoTen());
        txtMaSV.setText(sv.getMaSV());
        txtNgaySinh.setText(sv.getNgaySinh());

        if (sv.getGioiTinh().equalsIgnoreCase("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }

        chkGiaoVien.setSelected(
                sv.getNgheNghiep().contains("Giáo viên")
        );

        chkLapTrinhVien.setSelected(
                sv.getNgheNghiep().contains("Lập trình viên")
        );
    }

    // ================= TABLE HELPERS =================
    private void loadTable() {
        tableModel.setRowCount(0);
        try {
            Request req = new Request("LIST", (String) null);
            System.out.println("[DEBUG] Gui LIST request...");
            Response resp = clientConnection.sendRequest(req);
            System.out.println("[DEBUG] Response: " + resp);
            if (resp == null) {
                System.out.println("[DEBUG] Response la NULL!");
                return;
            }
            System.out.println("[DEBUG] getList() = " + resp.getList());
            if (resp.getList() != null) {
                System.out.println("[DEBUG] So luong SV: " + resp.getList().size());
                for (SinhVien sv : resp.getList()) {
                    addRowToTable(sv);
                }
            } else {
                System.out.println("[DEBUG] getList() tra ve NULL");
            }
        } catch (Exception ex) {
            System.out.println("[DEBUG] Exception trong loadTable: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void addRowToTable(SinhVien sv) {
        tableModel.addRow(new Object[]{
                sv.getMaSV(), sv.getHoTen(),
                sv.getNgaySinh(), sv.getGioiTinh(),
                sv.getNgheNghiep()
        });
    }

    private void updateRowInTable(SinhVien sv) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(sv.getMaSV())) {
                tableModel.setValueAt(sv.getHoTen(),      i, 1);
                tableModel.setValueAt(sv.getNgaySinh(),   i, 2);
                tableModel.setValueAt(sv.getGioiTinh(),   i, 3);
                tableModel.setValueAt(sv.getNgheNghiep(), i, 4);
                break;
            }
        }
    }

    private void removeRowFromTable(String maSV) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(maSV)) {
                tableModel.removeRow(i);
                break;
            }
        }
    }

    // ================= EVENT =================
    @Override
    public void actionPerformed(ActionEvent e) {

        // CONNECT
        if (e.getSource() == btnConnect) {

            clientConnection = new ClientConnection();

            boolean connected =
                    clientConnection.connect();

            if (connected) {

                lblStatus.setText("Đã kết nối server");
                lblStatus.setForeground(new Color(40, 140, 40));

                loadTable();

                JOptionPane.showMessageDialog(
                        this,
                        "Kết nối thành công!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Kết nối thất bại!"
                );
            }
        }

        // GỬI
        if (e.getSource() == btnGui) {

            SinhVien sv = getSinhVienFromForm();

            Request request =
                    new Request("INSERT", sv);

            Response response =
                    clientConnection.sendRequest(request);

            if (response != null && response.isSuccess()) {

                addRowToTable(sv);

                JOptionPane.showMessageDialog(
                        this,
                        "Gửi thông tin thành công!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Gửi thất bại!"
                );
            }
        }

        // THÊM
        if (e.getSource() == btnThem) {

            resetForm();
        }

        // SỬA
        if (e.getSource() == btnSua) {

            if (!isEditing) {

                // ── Lần 1: nhập mã SV, load dữ liệu lên form ──
                String maSV =
                        JOptionPane.showInputDialog(
                                this,
                                "Nhập mã SV cần sửa:"
                        );

                if (maSV != null && !maSV.trim().isEmpty()) {

                    Request request =
                            new Request("FIND", maSV.trim());

                    Response response =
                            clientConnection.sendRequest(request);

                    if (response != null &&
                            response.getSinhVien() != null) {

                        setForm(response.getSinhVien());

                        maSVDangSua = maSV.trim();
                        isEditing   = true;

                        btnSua.setText("Cập nhật");
                        btnSua.setBackground(new Color(255, 200, 0));

                        JOptionPane.showMessageDialog(
                                this,
                                "Đã load thông tin sinh viên. Bạn có thể sửa và nhấn 'Cập nhật' để lưu thay đổi."
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                this,
                                "Không tìm thấy sinh viên!"
                        );
                    }
                }

            } else {

                // ── Lần 2: xác nhận cập nhật ──
                int choose =
                        JOptionPane.showConfirmDialog(
                                this,
                                "Có cập nhật không?",
                                "Xác nhận",
                                JOptionPane.YES_NO_OPTION
                        );

                if (choose == JOptionPane.YES_OPTION) {

                    SinhVien newSV = getSinhVienFromForm();
                    newSV.setMaSV(maSVDangSua);

                    Request updateRequest =
                            new Request("UPDATE", newSV);

                    Response updateResponse =
                            clientConnection.sendRequest(updateRequest);

                    if (updateResponse != null &&
                            updateResponse.isSuccess()) {

                        updateRowInTable(newSV);

                        JOptionPane.showMessageDialog(
                                this,
                                "Cập nhật thành công!"
                        );
                    }
                }

                // Reset trạng thái dù Yes hay No
                isEditing   = false;
                maSVDangSua = null;
                btnSua.setText("Sửa");
                btnSua.setBackground(null);
                resetForm();
            }
        }

        // XÓA
        if (e.getSource() == btnXoa) {

            String maSV =
                    JOptionPane.showInputDialog(
                            this,
                            "Nhập mã SV cần xóa:"
                    );

            int choose =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Bạn có muốn xóa không?",
                            "Xóa",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choose == JOptionPane.YES_OPTION) {

                Request request =
                        new Request("DELETE", maSV);

                Response response =
                        clientConnection.sendRequest(request);

                if (response.isSuccess()) {

                    removeRowFromTable(maSV);

                    JOptionPane.showMessageDialog(
                            this,
                            "Xóa thành công!"
                    );

                    resetForm();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Xóa thất bại!"
                    );
                }
            }
        }

        // KẾT THÚC
        if (e.getSource() == btnKetThuc) {

            int choose =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Bạn có muốn kết thúc?",
                            "Thoát",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choose == JOptionPane.YES_OPTION) {

                if (clientConnection != null) {
                    clientConnection.closeConnection();
                }

                System.exit(0);
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        new MainFrame();
    }
}