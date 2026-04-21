import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_1 {
    public static void main(String[] args) {
        // Department
        Department d1 = new Department(1, "sale");
        Department d2 = new Department(2, "Marketing");
        Department d3 = new Department(3, "IT");

        //  Position
        Position p1 = new Position(1, Position.PositionName.DEV);
        Position p2 = new Position(2, Position.PositionName.TEST);
        Position p3 = new Position(3, Position.PositionName.PM);

        //  Account
        Account a1 = new Account(1, "a@gmail.com", "user1", "Nguyen Van A", d1, p1, LocalDateTime.now());
        Account a2 = new Account(2, "b@gmail.com", "user2", "Tran Van B", d2, p2, LocalDateTime.now());
        Account a3 = new Account(3, "c@gmail.com", "user3", "Le Van C", d3, p3, LocalDateTime.now());

        //  Group
        Group g1 = new Group(1, "Group Java", a1, LocalDateTime.now());
        Group g2 = new Group(2, "Group SQL", a2, LocalDateTime.now());
        Group g3 = new Group(3, "Group Test", a3, LocalDateTime.now());

        // Group Account
        GroupAccount ga1 = new GroupAccount(g1, a1, LocalDateTime.now());
        GroupAccount ga2 = new GroupAccount(g2, a2, LocalDateTime.now());
        GroupAccount ga3 = new GroupAccount(g3, a3, LocalDateTime.now());

        //  TypeQuestion
        TypeQuestion tq1 = new TypeQuestion(1, TypeQuestion.TypeName.ESSAY);
        TypeQuestion tq2 = new TypeQuestion(2, TypeQuestion.TypeName.MULTIPLE_CHOICE);
        TypeQuestion tq3 = new TypeQuestion(3, TypeQuestion.TypeName.ESSAY);

        //  CategoryQuestion
        CategoryQuestion c1 = new CategoryQuestion(1, "Java");
        CategoryQuestion c2 = new CategoryQuestion(2, "SQL");
        CategoryQuestion c3 = new CategoryQuestion(3, "Test");

        //  Question
        Question q1 = new Question(1, "Java là gì?", c1, tq1, a1, LocalDateTime.now());
        Question q2 = new Question(2, "SQL dùng để làm gì?", c2, tq2, a2, LocalDateTime.now());
        Question q3 = new Question(3, "Test case là gì?", c3, tq1, a3, LocalDateTime.now());

        //  Answer
        Answer ans1 = new Answer(1, "Ngôn ngữ lập trình", q1, true);
        Answer ans2 = new Answer(2, "Hệ quản trị DB", q2, true);
        Answer ans3 = new Answer(3, "Kịch bản test", q3, true);

        //  Exam
        Exam e1 = new Exam(1, "EX01", "Java Basic", c1, 60, a1, LocalDateTime.now());
        Exam e2 = new Exam(2, "EX02", "SQL Basic", c2, 45, a2, LocalDateTime.now());
        Exam e3 = new Exam(3, "EX03", "Test Basic", c3, 30, a3, LocalDateTime.now());

        // Exam Question
        ExamQuestion eq1 = new ExamQuestion(e1, q1);
        ExamQuestion eq2 = new ExamQuestion(e2, q2);
        ExamQuestion eq3 = new ExamQuestion(e3, q3);





        /*Question 1:
        Kiểm tra account thứ 2
        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
        "Nhân viên này chưa có phòng ban"
        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"*/
        System.out.println("========================== Question 1 =======================");
        if (a2.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + a2.getDepartment().getDepartmentName());
        }

        /*Question 2:
        Kiểm tra account thứ 2
        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
        */
        System.out.println("========================== Question 2 =======================");
        if (ga2.getGroup() == null) {
            System.out.println("Nhân viên này chưa có group");
        } else if (ga2.getGroup() != null && ga2.getGroup().getGroupName().equals("Group Java")) {
            System.out.println("Group của nhân viên này là Java Fresher");
        } else if (ga2.getGroup() != null && ga2.getGroup().getGroupName().equals("Group SQL")) {
            System.out.println("Group của nhân viên này là SQL Fresher");
        } else if (ga2.getGroup() != null && ga2.getGroup().getGroupName().equals("Group Test")) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        /* Question 3: Sử dụng toán tử ternary để làm Question 1*/
        System.out.println("========================== Question 3 =======================");
        String departmentName = (a2.getDepartment() == null) ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là " + a2.getDepartment().getDepartmentName();
        System.out.println(departmentName);

        /*Question 4:
        Sử dụng toán tử ternary để làm yêu cầu sau:
        Kiểm tra Position của account thứ 1
        Nếu Position = Dev thì in ra text "Đây là Developer"
        Nếu không phải thì in ra text "Người này không phải là Developer"*/
        System.out.println("========================== Question 4 =======================");
        String positionName = (a1.getPosition() != null && a1.getPosition().getPositionName() == Position.PositionName.DEV) ? "Đây là Developer" : "Người này không phải là Developer";
        System.out.println(positionName);

        /*Question 5:
        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
        Còn lại in ra "Nhóm có nhiều thành viên"*/
        System.out.println("========================== Question 5 =======================");
        List<Group> groups = new ArrayList<>(Arrays.asList(g1, g2, g3));
        List<GroupAccount> groupAccounts = new ArrayList<>(Arrays.asList(ga1, ga2, ga3));
        Group group1 = groups.get(0);

        int soLuong = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.getGroup().equals(group1)) {
                soLuong++;
            }
        }
        switch (soLuong) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }

//      Question 6: Sử dụng switch case để làm lại Question 2
        System.out.println("========================== Question 6 =======================");
        var checkName = ga2.getGroup().getGroupName();
        switch (checkName) {
            case "Group Java":
                System.out.println("Group của nhân viên này là Java Fresher");
                break;
            case "Group SQL":
                System.out.println("Group của nhân viên này là SQL Fresher");
                break;
            case "Group Test":
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }

//      Question 7: Sử dụng switch case để làm lại Question 4
        System.out.println("========================== Question 7 =======================");
        var checkPosition = a1.getPosition().getPositionName();
        switch (checkPosition) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;

        }

//      Question 8:In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        System.out.println("========================== Question 8 =======================");
        List<Account> listAcc1 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int count1 = 1;
        for (Account acc : listAcc1) {
            System.out.println("Thông tin của account " + count1++);
            System.out.println("Email: " + acc.getEmail());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Phòng ban: " + (acc.getDepartment() != null ? acc.getDepartment().getDepartmentName() : "Chưa có phòng ban"));
            System.out.println("-----------------------------");
        }

//      Question 9: In ra thông tin các phòng ban bao gồm: Id và Name
        System.out.println("========================== Question 8 =======================");
        List<Department> listDpm = new ArrayList<>(Arrays.asList(d1, d2, d3));
        int count2 = 1;
        for (Department dpm : listDpm) {
            System.out.println("Thông tin của phòng ban 1 " + count2++);
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");
        }

        /*Question 10:
        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
        Thông tin account thứ 1 là:
        Email: NguyenVanA@gmail.com
        Full name: Nguyễn Văn A
        Phòng ban: Sale

        Thông tin account thứ 2 là:
        Email: NguyenVanB@gmail.com
        Full name: Nguyễn Văn B
        Phòng ban: Marketting*/
        System.out.println("========================== Question 10 =======================");
        List<Account> listAcc2 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        for (int i = 0; i < listAcc2.size(); i++) {
            Account acc = listAcc2.get(i);
            System.out.println("Thông tin của account " + (i + 1) + ":");
            System.out.println("Email: " + acc.getEmail());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Phòng ban: " +
                    (acc.getDepartment() != null
                            ? acc.getDepartment().getDepartmentName()
                            : "Chưa có phòng ban"));
            System.out.println("-----------------------------");
        }

        /*Question 11:
        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
        Thông tin department thứ 1 là:
        Id: 1
        Name: Sale
        Thông tin department thứ 2 là:
        Id: 2
        Name: Marketing*/
        System.out.println("========================== Question 11 =======================");
        List<Department> listDpm2 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        for (int i = 0; i < listDpm2.size(); i++) {
            Department dpm = listDpm2.get(i);
            System.out.println("Thông tin của phòng ban " + (i + 1) + ":");
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");
        }

        /*   Question 12:  Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10*/
        System.out.println("========================== Question 12 =======================");
        //C1
        List<Department> listDpm3 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        for (int i = 0; i < 2; i++) {
            Department dpm = listDpm3.get(i);
            System.out.println("Thông tin của phòng ban " + (i + 1) + ":");
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");
        }
        //C2
        int count = 0;
        for (Department dpm : listDpm3) {
            if (count == 2) break;
            System.out.println("Thông tin của phòng ban " + count + ":");
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");
            count++;
        }

//        Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
        System.out.println("========================== Question 13 =======================");
        List<Account> listAcc3 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        for (int i = 0; i < listAcc3.size(); i++) {
            if (i == 1) continue;
            Account acc = listAcc3.get(i);
            System.out.println("Thông tin của account " + (i + 1) + ":");
            System.out.println("Email: " + acc.getEmail());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Phòng ban: " +
                    (acc.getDepartment() != null
                            ? acc.getDepartment().getDepartmentName()
                            : "Chưa có phòng ban"));
            System.out.println("-----------------------------");
        }

//        Question 14: In ra thông tin tất cả các account có id < 4
        System.out.println("========================== Question 14 =======================");
        List<Account> listAcc4 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        for (Account acc : listAcc4) {
            if (acc.getAccountId() < 4) {
                System.out.println("Thông tin của account " + acc.getAccountId() + ":");
                System.out.println("Email: " + acc.getEmail());
                System.out.println("FullName: " + acc.getFullName());
                System.out.println("Phòng ban: " +
                        (acc.getDepartment() != null
                                ? acc.getDepartment().getDepartmentName()
                                : "Chưa có phòng ban"));
                System.out.println("-----------------------------");
            }
        }
//        Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("========================== Question 15 =======================");
        System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20 la: ");
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

//        Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue

        System.out.println("========================== Question 10 WITH WHILE =======================");
        List<Account> listAcc5 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int i = 0;
        while (i < listAcc5.size()) {
            Account acc = listAcc5.get(i);
            System.out.println("Thông tin của account " + (i + 1) + ":");
            System.out.println("Email: " + acc.getEmail());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Phòng ban: " +
                    (acc.getDepartment() != null
                            ? acc.getDepartment().getDepartmentName()
                            : "Chưa có phòng ban"));
            System.out.println("-----------------------------");

            i++;
        }

        System.out.println("========================== Question 11 WITH WHILE  =======================");
        List<Department> listDpm4 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        int j = 0;
        while (j < listDpm4.size()) {
            Department dpm = listDpm4.get(j);
            System.out.println("Thông tin của phòng ban " + (j + 1) + ":");
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");

            j++;
        }

        System.out.println("========================== Question 12 WITH WHILE  =======================");
        List<Department> listDpm5 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        int k = 0;
        while (k < 2) {
            Department dpm = listDpm5.get(k);
            System.out.println("Thông tin của phòng ban " + (k + 1) + ":");
            System.out.println("ID: " + dpm.getDepartmentId());
            System.out.println("DepartmentName: " + dpm.getDepartmentName());
            System.out.println("-----------------------------");

            k++;
        }

        System.out.println("========================== Question 13 WITH WHILE  =======================");
        List<Account> listAcc6 = new ArrayList<>(Arrays.asList(a1, a2, a3));

        int m = 0;
        while (m < listAcc6.size()) {
            if (m == 1) {
                m++;
                continue;
            }
            Account acc = listAcc6.get(m);
            System.out.println("Thông tin của account " + (m + 1) + ":");
            System.out.println("Email: " + acc.getEmail());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Phòng ban: " +
                    (acc.getDepartment() != null
                            ? acc.getDepartment().getDepartmentName()
                            : "Chưa có phòng ban"));
            System.out.println("-----------------------------");
            m++;
        }

        System.out.println("========================== Question 14 WITH WHILE  =======================");
        List<Account> listAcc7 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int n = 0;
        while (n < listAcc4.size()) {
            Account acc = listAcc7.get(n);
            if (acc.getAccountId() < 4) {
                System.out.println("Thông tin của account " + acc.getAccountId() + ":");
                System.out.println("Email: " + acc.getEmail());
                System.out.println("FullName: " + acc.getFullName());
                System.out.println("Phòng ban: " +
                        (acc.getDepartment() != null
                                ? acc.getDepartment().getDepartmentName()
                                : "Chưa có phòng ban"));
                System.out.println("-----------------------------");
            }
            n++;
        }

        System.out.println("========================== Question 15 WITH WHILE =======================");
        System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20 là:");
        int x = 0;
        while (x <= 20) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
            }
            x++;
        }


     /*   Question 17: Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue*/
        System.out.println("========================== Question 10 WITH DO_WHILE =======================");
        List<Account> listAcc8 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int ind = 0;
        if (!listAcc8.isEmpty()) {
            do {
                Account acc = listAcc8.get(ind);
                System.out.println("Thông tin của account " + (ind + 1) + ":");
                System.out.println("Email: " + acc.getEmail());
                System.out.println("FullName: " + acc.getFullName());
                System.out.println("Phòng ban: " +
                        (acc.getDepartment() != null
                                ? acc.getDepartment().getDepartmentName()
                                : "Chưa có phòng ban"));
                System.out.println("-----------------------------");
                ind++;
            } while (ind < listAcc8.size());
        }

        System.out.println("========================== Question 11 WITH DO_WHILE =======================");
        List<Department> listDpm6 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        int l = 0;
        if (!listDpm6.isEmpty()) {
            do {
                Department dpm = listDpm6.get(l);
                System.out.println("Thông tin của phòng ban " + (l + 1) + ":");
                System.out.println("ID: " + dpm.getDepartmentId());
                System.out.println("DepartmentName: " + dpm.getDepartmentName());
                System.out.println("-----------------------------");

                l++;
            } while (l < listDpm6.size());
        }

        System.out.println("========================== Question 12 WITH DO_WHILE =======================");
        List<Department> listDpm8 = new ArrayList<>(Arrays.asList(d1, d2, d3));
        int z = 0;
        if (listDpm8.size() >= 1) {
            do {
                Department dpm = listDpm8.get(z);
                System.out.println("Thông tin của phòng ban " + (z + 1) + ":");
                System.out.println("ID: " + dpm.getDepartmentId());
                System.out.println("DepartmentName: " + dpm.getDepartmentName());
                System.out.println("-----------------------------");

                z++;
            } while (z < 2);
        }

        System.out.println("========================== Question 13 WITH DO_WHILE =======================");
        List<Account> listAcc9 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int c = 0;
        if (!listAcc9.isEmpty()) {
            do {
                if (c == 1) {
                    c++;
                    continue;
                }
                Account acc = listAcc9.get(c);
                System.out.println("Thông tin của account " + (c + 1) + ":");
                System.out.println("Email: " + acc.getEmail());
                System.out.println("FullName: " + acc.getFullName());
                System.out.println("Phòng ban: " +
                        (acc.getDepartment() != null
                                ? acc.getDepartment().getDepartmentName()
                                : "Chưa có phòng ban"));
                System.out.println("-----------------------------");

                c++;
            } while (c < listAcc9.size());
        }

        System.out.println("========================== Question 14 WITH DO_WHILE =======================");
        List<Account> listAcc10 = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int f = 0;
        if (!listAcc10.isEmpty()) {
            do {
                Account acc = listAcc10.get(f);
                if (acc.getAccountId() < 4) {
                    System.out.println("Thông tin của account " + acc.getAccountId() + ":");
                    System.out.println("Email: " + acc.getEmail());
                    System.out.println("FullName: " + acc.getFullName());
                    System.out.println("Phòng ban: " +
                            (acc.getDepartment() != null
                                    ? acc.getDepartment().getDepartmentName()
                                    : "Chưa có phòng ban"));
                    System.out.println("-----------------------------");
                }

                f++;
            } while (f < listAcc10.size());
        }

        System.out.println("========================== Question 15 WITH DO_WHILE =======================");
        System.out.println("Các số chẵn nhỏ hơn hoặc bằng 20 là:");
        int g = 0;
        do {
            if (g % 2 == 0) {
                System.out.print(g + " ");
            }
            g++;
        } while (g <= 20);

    }
}


