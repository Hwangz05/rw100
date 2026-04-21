import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_2 {
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




        /*Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó*/
        System.out.println("========================== Question 1 =======================");
        int a = 5;
        System.out.printf("Giá trị của a là: %d\n", a);

        /*Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000*/
        System.out.println("========================== Question 2 =======================");
        int b = 100000000;
        System.out.printf("Giá trị của b là: %,d\n", b);

        /* Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau*/
        System.out.println("========================== Question 3 =======================");
        double c = 5.567098;
        System.out.printf("Giá trị của c là: %.4f\n", c);

        /*Question 4:
        Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
        Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.*/
        System.out.println("========================== Question 4 =======================");
        String fullName = "Nguyễn Văn Hoàng";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.\n", fullName);

        /*Question 5:
        Lấy thời gian bây giờ và in ra theo định dạng sau:
        24/04/2020 11h:16p:20s*/
        System.out.println("========================== Question 5 =======================");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
        System.out.println(now.format(formatter));

        /*Question 6: In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)*/
        System.out.println("========================== Question 6 =======================");
        List<Account> listAcc = new ArrayList<>(Arrays.asList(a1, a2, a3));
        System.out.printf("%-5s %-25s %-25s %-20s\n",
                "ID", "Email", "FullName", "Department");
        System.out.println("-------------------------------------------------------------------------------");
        int i = 1;
        for (Account acc : listAcc) {
            String departmentName = (acc.getDepartment() != null)
                    ? acc.getDepartment().getDepartmentName()
                    : "Chưa có phòng ban";

            System.out.printf("%-5d %-25s %-25s %-20s\n",
                    i++,
                    acc.getEmail(),
                    acc.getFullName(),
                    departmentName);
        }

    }
}
