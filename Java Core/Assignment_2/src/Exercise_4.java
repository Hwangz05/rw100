import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Exercise_4 {
    public static void main(String[] args) {
    //        Question 1:
    //        In ngẫu nhiên ra 1 số nguyên
                Random rand = new Random();
                int soNguyen = rand.nextInt(); // số nguyên bất kỳ
                System.out.println("Số nguyên ngẫu nhiên: " + soNguyen);
    //        Question 2:
    //        In ngẫu nhiên ra 1 số thực
                double soThuc = rand.nextDouble(); // từ 0.0 đến 1.0
                System.out.println("Số thực ngẫu nhiên: " + soThuc);
    //        Question 3:  Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
                String[] tenLop = {"Nguyen Van A", "Tran Van B", "Le Van C", "Pham Thi D", "Hoang Van E"};
                int index = rand.nextInt(tenLop.length); // lấy index ngẫu nhiên
                System.out.println("Tên ngẫu nhiên trong lớp: " + tenLop[index]);
    //        Question 4:
    //        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-121995
                LocalDate start = LocalDate.of(1995, 7, 24);
                LocalDate end = LocalDate.of(1995, 12, 20);

                long days = ChronoUnit.DAYS.between(start, end);
                LocalDate randomDate = start.plusDays(rand.nextInt((int) days + 1));
                System.out.println("Ngày ngẫu nhiên: " + randomDate);
    //        Question 5:
    //        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
                LocalDate today = LocalDate.now();
                LocalDate oneYearAgo = today.minusYears(1);

                long days2 = ChronoUnit.DAYS.between(oneYearAgo, today);
                LocalDate randomDate2 = oneYearAgo.plusDays(rand.nextInt((int) days2 + 1));

                System.out.println("Ngày trong 1 năm qua: " + randomDate2);
    //        Question 6:
    //        Lấy ngẫu nhiên 1 ngày trong quá khứ
                LocalDate past = LocalDate.of(1900, 1, 1);
                LocalDate now = LocalDate.now();

                long days3 = ChronoUnit.DAYS.between(past, now);
                LocalDate randomDate3 = past.plusDays(rand.nextInt((int) days3 + 1));

                System.out.println("Ngày trong quá khứ: " + randomDate3);
    //        Question 7:
    //        Lấy ngẫu nhiên 1 số có 3 chữ số
                int so3ChuSo = 100 + rand.nextInt(900); // từ 100 đến 999
                System.out.println("Số có 3 chữ số: " + so3ChuSo);

    }
}
