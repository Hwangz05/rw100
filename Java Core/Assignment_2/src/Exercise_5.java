import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Exercise_5 {
    /*Question 5:
        Viết lệnh cho phép người dùng tạo account (viết thành method) Đối với property Position,
        Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
        */
    public static Position.PositionName inputPosition(Scanner sc) {
        while (true) {
            System.out.println("Chọn Position:");
            System.out.println("1. Dev");
            System.out.println("2. Test");
            System.out.println("3. ScrumMaster");
            System.out.println("4. PM");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    return Position.PositionName.DEV;
                case 2:
                    return Position.PositionName.TEST;
                case 3:
                    return Position.PositionName.SCRUM_MASTER;
                case 4:
                    return Position.PositionName.PM;
                default:
                    System.out.println("Nhập sai, chọn lại!");
            }
        }
    }

    public static void question5(Scanner sc) {
        System.out.println("=== Question 5: Tạo Account ===");
        Account acc = new Account();
        System.out.print("Nhập ID: ");
        acc.setAccountId(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập Email: ");
        acc.setEmail(sc.nextLine());
        System.out.print("Nhập Username: ");
        acc.setUserName(sc.nextLine());
        System.out.print("Nhập FullName: ");
        acc.setFullName(sc.nextLine());

        Position pos = new Position();
        pos.setPositionName(inputPosition(sc));
        acc.setPosition(pos);

        System.out.println("→ Tạo Account thành công: " + acc.getFullName());
    }
//        Question 6:
//        Viết lệnh cho phép người dùng tạo department (viết thành method)
        public static void question6(Scanner sc) {
            System.out.println("\n=== Question 6: Tạo Department ===");
            Department dep = new Department();
            System.out.print("Nhập ID Department: ");
            dep.setDepartmentId(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập tên Department: ");
            dep.setDepartmentName(sc.nextLine());
            System.out.println("→ Department: " + dep.getDepartmentName() + " đã được tạo với ID: " + dep.getDepartmentId());
        }

//        Question 7:
//        Nhập số chẵn từ console
        public static void question7(Scanner sc) {
            System.out.println("\n=== Question 7: Nhập số chẵn ===");
            int number;
            while (true) {
                System.out.print("Nhập số chẵn: ");
                number = sc.nextInt();
                if (number % 2 == 0) {
                    break;
                } else {
                    System.out.println("Sai! Phải nhập số chẵn.");
                }
            }
            System.out.println("→ Số chẵn đã nhập: " + number);
        }

     /*Question 8:
        Viết chương trình thực hiện theo flow sau:
        Bước 1:  Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
        Bước 2:  Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
        Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
        Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1*/

    public static void question8(Scanner sc) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    question5(sc);
                    break;
                case 2:
                    question6(sc);
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Mời bạn nhập lại!");
            }
        }
    }

//    Question 9:
//    Viết method cho phép người dùng thêm group vào account theo flow sau:
//    Bước 1: In ra tên các usernames của user cho người dùng xem
//    Bước 2: Yêu cầu người dùng nhập vào username của account
//    Bước 3:  In ra tên các group cho người dùng xem
//    Bước 4: Yêu cầu người dùng nhập vào tên của group
//    Bước 5:  Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó .

    public static void addAccountToGroup(Scanner sc, Account[] accounts, Group[] groups) {
        //Bước 1
        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.getUserName());
        }
        //Bước 2
        System.out.print("Nhập username: ");
        sc.nextLine();
        String usernameInput = sc.nextLine();
        Account selectedAccount = null;
        for (Account acc : accounts) {
            if (acc.getUserName().equals(usernameInput)) {
                selectedAccount = acc;
                break;
            }
        }
        if (selectedAccount == null) {
            System.out.println("Không tìm thấy account!");
            return;
        }
        //Bước 3
        System.out.println("Danh sách group:");
        for (Group g : groups) {
            System.out.println("- " + g.getGroupName());
        }
        //Bước 4
        System.out.print("Nhập tên group: ");
        String groupInput = sc.nextLine();
        Group selectedGroup = null;
        for (Group g : groups) {
            if (g.getGroupName().equals(groupInput)) {
                selectedGroup = g;
                break;
            }
        }
        if (selectedGroup == null) {
            System.out.println("Không tìm thấy group!");
            return;
        }
        //Bước 5
        Account[] oldAccounts = selectedGroup.getAccounts();
        Account[] newAccounts = new Account[oldAccounts.length + 1];
        for (int i = 0; i < oldAccounts.length; i++) {
            newAccounts[i] = oldAccounts[i];
        }
        newAccounts[newAccounts.length - 1] = selectedAccount;
        selectedGroup.setAccounts(newAccounts);
        Group[] oldGroups = selectedAccount.getGroups();
        Group[] newGroups = new Group[oldGroups.length + 1];
        for (int i = 0; i < oldGroups.length; i++) {
            newGroups[i] = oldGroups[i];
        }
        newGroups[newGroups.length - 1] = selectedGroup;
        selectedAccount.setGroups(newGroups);
        System.out.println("Thêm thành công!");
    }

   /* Question 10: Tiếp tục Question 8 và Question 9
    Bổ sung thêm vào bước 2 của Question 8 như sau:
    Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
    Bổ sung thêm Bước 3 của Question 8 như sau:
    Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để kết thúc chương trình)
    */
    public static void question10(Scanner sc, Account[] accounts, Group[] groups) {

        while (true) {
            //Bước 1
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Account vào Group");
            System.out.println("4. Thêm Account vào Group ngẫu nhiên");
            System.out.print("Mời bạn nhập chức năng: ");
            int choice = sc.nextInt();
            //Bước 2
            switch (choice) {
                case 1:
                    question5(sc);
                    break;
                case 2:
                    question6(sc);
                    break;
                case 3:
                    addAccountToGroup(sc, accounts, groups);
                    break;
                case 4:
                    addAccountToRandomGroup(sc, accounts, groups);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!");
                    continue;
            }
            //Bước 3
            sc.nextLine(); // clear buffer
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (Có/Không): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("Không")) {
                System.out.println("Kết thúc chương trình!");
                return;
            }
        }
    }

    /*Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như sau:
    Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
    Bước 1:  In ra tên các usernames của user cho người dùng xem
    Bước 2:  Yêu cầu người dùng nhập vào username của account
    Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
    Bước 4:  Thêm account vào group chương trình vừa chọn ngẫu nhiên
    */
    public static void addAccountToRandomGroup(Scanner sc, Account[] accounts, Group[] groups) {

        //Bước 1
        System.out.println("Danh sách username:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.getUserName());
        }

        //Bước 2
        sc.nextLine();
        System.out.print("Nhập username: ");
        String usernameInput = sc.nextLine();
        Account selectedAccount = null;
        for (Account acc : accounts) {
            if (acc.getUserName().equals(usernameInput)) {
                selectedAccount = acc;
                break;
            }
        }
        if (selectedAccount == null) {
            System.out.println("Không tìm thấy account!");
            return;
        }

        //Bước 3
        Random rand = new Random();
        int index = rand.nextInt(groups.length);
        Group randomGroup = groups[index];

        System.out.println("Group được chọn ngẫu nhiên: " + randomGroup.getGroupName());

        //Bước 4
        Account[] oldAcc = randomGroup.getAccounts();
        Account[] newAcc = new Account[oldAcc.length + 1];
        for (int i = 0; i < oldAcc.length; i++) {
            newAcc[i] = oldAcc[i];
        }
        newAcc[newAcc.length - 1] = selectedAccount;
        randomGroup.setAccounts(newAcc);
        Group[] oldGroups = selectedAccount.getGroups();
        Group[] newGroups = new Group[oldGroups.length + 1];

        for (int i = 0; i < oldGroups.length; i++) {
            newGroups[i] = oldGroups[i];
        }
        newGroups[newGroups.length - 1] = randomGroup;
        selectedAccount.setGroups(newGroups);
        System.out.println("Thêm vào group ngẫu nhiên thành công!");
    }

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


        //    Question 1:
        //    Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên thứ 1: ");
        int a = sc.nextInt();
        System.out.print("Nhập số nguyên thứ 2: ");
        int b = sc.nextInt();
        System.out.print("Nhập số nguyên thứ 3: ");
        int c = sc.nextInt();
        System.out.println("Bạn đã nhập: " + a + ", " + b + ", " + c);

        sc.nextLine();
        //    Question 2:
        //    Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
        System.out.print("Nhập số thực thứ 1: ");
        double x = sc.nextDouble();
        System.out.print("Nhập số thực thứ 2: ");
        double y = sc.nextDouble();
        System.out.println("Bạn đã nhập: " + x + " và " + y);

        //    Question 3:
        //    Viết lệnh cho phép người dùng nhập họ và tên
        sc.nextLine();
        System.out.print("Nhập họ và tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Họ tên của bạn là: " + hoTen);

        //    Question 4:
        //    Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String input = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(input);
        System.out.println("Ngày sinh: " + birthDate);

        // question 5 6 7 8
        question5(sc);
        question6(sc);
        question7(sc);
        question8(sc);

        // question 9
        Account[] accounts = {a1, a2};
        Group[] groups = {g1, g2};
        addAccountToGroup(sc, accounts, groups);

        // question 10
        question10(sc, accounts, groups);

    }
}
