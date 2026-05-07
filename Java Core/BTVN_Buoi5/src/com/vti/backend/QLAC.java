package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Position;

import java.util.ArrayList;
import java.util.List;

public class QLAC {

    private List<Account> listaccounts = new ArrayList<>();

    public void addAccount(Account ac) {
        listaccounts.add(ac);
        System.out.println("Đã thêm Account thành công:  " );
    }

    public void timTheoTenPB(String ten) {
        boolean check = false;
        for (Account ac : listaccounts) {
            if (ac.getDepartment().getDepartmentName().equalsIgnoreCase(ten)) {
                System.out.println(ac);
                check = true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy account cua chuc vu: " + ten);
        }
    }

    public void timTheoTenCV(String ten) {
        boolean check = false;
        for (Account ac : listaccounts) {
            if (ac.getPosition().getPositionName().toString().equalsIgnoreCase(ten)) {
                System.out.println(ac);
                check = true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy account cua chuc vu: " + ten);
        }
    }

    public void showAccount() {
        System.out.println("Danh sách Acount:");
        for (Account ac : listaccounts) {
            System.out.println(ac);
        }
    }

    public void deleteAccountByFullName(String fullName) {
        boolean check = false;

        for (int i = 0; i < listaccounts.size(); i++) {
            if (listaccounts.get(i).getFullName().equalsIgnoreCase(fullName)) {
                listaccounts.remove(i);
                i--;
                check = true;
            }
        }
        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

}
