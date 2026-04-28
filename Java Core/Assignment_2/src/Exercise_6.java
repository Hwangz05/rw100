import java.time.LocalDateTime;

public class Exercise_6 {

//    Question 1:
//    Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10

    public static void question1() {
        System.out.println("Các số chẵn < 10:");
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

//    Question 2:
//    Tạo method để in thông tin các account

    public static void question2(Account[] accounts) {
        System.out.println("Danh sách Account:");
        int count = 0;
        for (Account acc : accounts) {
            System.out.println("Thông tin acc cout thú: " + count++);
            System.out.println("ID: " + acc.getAccountId());
            System.out.println("Username: " + acc.getUserName());
            System.out.println("FullName: " + acc.getFullName());
            System.out.println("Email: " + acc.getEmail());
            System.out.println("----------------------");
        }
    }

//    Question 3:
//    Tạo method để in ra các số nguyên dương nhỏ hơn 10

    public static void question3() {
        System.out.println("Các số nguyên dương < 10:");

        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
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

        Account[] accounts = {a1, a2, a3};


        question1();
        question2(accounts);
        question3();
    }
}
