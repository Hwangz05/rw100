import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exercise_2 {
    public static void question1() {

        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {

            accounts[i] = new Account();

            accounts[i].setEmail("Email " + (i + 1));
            accounts[i].setUserName("User name " + (i + 1));
            accounts[i].setFullName("Full name " + (i + 1));
            accounts[i].setCreateDate(LocalDateTime.now());
        }
        for (Account acc : accounts) {
            System.out.println(acc.getEmail() + " | "
                    + acc.getUserName() + " | "
                    + acc.getFullName() + " | "
                    + acc.getCreateDate());
        }
    }
        public static void main(String[] args) {
            question1();
        }
}
