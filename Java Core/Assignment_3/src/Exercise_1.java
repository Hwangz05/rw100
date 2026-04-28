import java.util.Random;
import java.util.Scanner;

public class Exercise_1 {

    public static int question4(Scanner sc) {

        System.out.print("Nhập số a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số b: ");
        int b = sc.nextInt();

        if (b == 0) {
            System.out.println("Không thể chia cho 0!");
            return 0; // hoặc xử lý khác
        }

        return a / b; // chia nguyên
    }
    public static void main(String[] args) {
        /*Question 1:
        Khai báo 2 số lương có kiểu dữ liệu là float.
                Khởi tạo Lương của Account 1 là 5240.5 $
        Khởi tạo Lương của Account 2 là 10970.055$

        Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
        Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra*/

        float salary1 = 5240.5f;
        float salary2 = 10970.055f;
        int roundSalary1 = (int) salary1;
        int roundSalary2 = (int) salary2;
        System.out.println("Lương Account 1 (int): " + roundSalary1);
        System.out.println("Lương Account 2 (int): " + roundSalary2);

        /*Question 2:
        Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
*/
        Random rand = new Random();
        int number = rand.nextInt(100000);
        String result = String.format("%05d", number);
        System.out.println("Số ngẫu nhiên 5 chữ số: " + result);

        /*Question 3:
        Lấy 2 số cuối của số ở Question 2 và in ra.Gợi ý:
        Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
        Cách 2: chia lấy dư số đó cho 1000*/

        int number1 = new java.util.Random().nextInt(100000);
        String formatted = String.format("%05d", number1);
        System.out.println("Số ban đầu: " + formatted);
        // cách 1
        String lastTwoDigits1 = formatted.substring(formatted.length() - 2);
        System.out.println("2 số cuối (cách String): " + lastTwoDigits1);

        // cách 2
        String lastTwoDigits2 = formatted.substring(formatted.length() - 2);
        System.out.println("2 số cuối (cách String): " + lastTwoDigits2);

        /*Question 4:
        Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng*/
        Scanner sc = new Scanner(System.in);
        int result1 = question4(sc);
        System.out.println("Thương: " + result1);

    }
}
