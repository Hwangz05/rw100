package com.vti.entity;

public class VietnamesePhone extends Phone {

    @Override
    public void insertContact(String name, String phone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact đã tồn tại!");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
    }

    @Override
    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(newPhone);
                return;
            }
        }
        System.out.println("Không tìm thấy!");
    }

    @Override
    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Không tìm thấy!");
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách liên hệ:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}