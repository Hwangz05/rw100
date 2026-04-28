import java.util.Scanner;

public class Exercise_4 {
    public static void main(String[] args) {

        /*Question 1:
        Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
        */
        System.out.println("Question 1:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        String[] words = str.trim().split("\\s+");
        System.out.println("Số từ: " + words.length);
        /*Question 2:
        Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;*/
        System.out.println("Question 2:");
        System.out.print("Nhập chuỗi s1: ");
        String s1 = sc.nextLine();
        System.out.print("Nhập chuỗi s2: ");
        String s2 = sc.nextLine();
        String result = s1 + s2;
        System.out.println("Chuỗi sau khi nối: " + result);
        /*Question 3:
        Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết hoa chữ cái đầu thì viết hoa lên
        */
        System.out.println("Question 3:");
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        if (name.length() > 0) {
            String newName = name.substring(0, 1).toUpperCase()
                    + name.substring(1);
            System.out.println("Tên sau khi chuẩn hóa: " + newName);
        } else {
            System.out.println("Tên không được để trống!");
        }

        /*Question 4:
        Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra VD:  Người dùng nhập vào "Nam", hệ thống sẽ in ra
        "Ký tự thứ 1 là: N"
        "Ký tự thứ 1 là: A"
        "Ký tự thứ 1 là: M"*/
        System.out.println("Question 4:");
        System.out.print("Nhập tên: ");
        String name1 = sc.nextLine();
        for (int i = 0; i < name1.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + name1.charAt(i));
        }
        /*Question 5:
        Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
        */
        System.out.println("Question 5:");
        System.out.print("Nhập họ: ");
        String ho = sc.nextLine();
        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        String fullName = ho + " " + ten;
        System.out.println("Họ và tên đầy đủ: " + fullName);

        /*Question 6:
        Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm VD:
        Người dùng nhập vào "Nguyễn Văn Nam"
        Hệ thống sẽ in ra
        "Họ là: Nguyễn"
        "Tên đệm là: Văn"
        "Tên là: Nam"*/
        System.out.println("Question 6:");
        System.out.print("Nhập họ và tên: ");
        String fullName1 = sc.nextLine();
        String[] parts = fullName1.trim().split("\\s+");
        String ho1 = parts[0];
        String ten1 = parts[parts.length - 1];
        String tenDem = "";
        for (int i = 1; i < parts.length - 1; i++) {
            tenDem += parts[i] + " ";
        }
        tenDem = tenDem.trim();
        System.out.println("Họ là: " + ho1);
        System.out.println("Tên đệm là: " + tenDem);
        System.out.println("Tên là: " + ten1);
        System.out.print("Nhập họ và tên: ");

        /*Question 7:
        Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và  chuẩn hóa họ và tên của họ như sau:
        Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
        VD: Nếu người dùng nhập vào "   nguyễn văn nam   " thì sẽ chuẩn hóa thành "nguyễn văn nam"
        Viết hoa chữ cái mỗi từ của người dùng VD: Nếu người dùng nhập vào "   nguyễn văn nam   " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"*/
        System.out.println("Question 7:");
        String fullName2 = sc.nextLine();
        fullName2 = fullName2.trim().toLowerCase();
        String[] parts1 = fullName2.split("\\s+");
        String result1 = "";
        for (String word : parts1) {
            String capitalized = word.substring(0, 1).toUpperCase()
                    + word.substring(1);
            result1 += capitalized + " ";
        }
        result1 = result1.trim();
        System.out.println("Họ tên chuẩn hóa: " + result1);

       /* Question 8:
        In ra tất cả các group có chứa chữ "Java"*/
        System.out.println("Question 8:");
        Group[] groups = new Group[5];
        groups[0] = new Group(); groups[0].setGroupName("Java");
        groups[1] = new Group(); groups[1].setGroupName("Java Core");
        groups[2] = new Group(); groups[2].setGroupName("Python");
        groups[3] = new Group(); groups[3].setGroupName("Java Advanced");
        groups[4] = new Group(); groups[4].setGroupName("C++");

        System.out.println("Group chứa 'Java':");
        for (Group g : groups) {
            if (g.getGroupName().contains("Java")) {
                System.out.println(g.getGroupName());
            }
        }

       /* Question 9:
        In ra tất cả các group "Java"*/
        System.out.println("Question 9:");
        System.out.println("\nGroup tên đúng 'Java':");
        for (Group g : groups) {
            if (g.getGroupName().equals("Java")) {
                System.out.println(g.getGroupName());
            }
        }
        /*Question 10 (Optional):
        Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
                Nếu có xuất ra “OK” ngược lại “KO”.
        Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.*/
        System.out.println("Question 10:");
        System.out.print("Nhập chuỗi 1: ");
        String st1 = sc.nextLine();
        System.out.print("Nhập chuỗi 2: ");
        String st2 = sc.nextLine();
        String reversed = new StringBuilder(st1).reverse().toString();
        if (reversed.equals(st2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
        /*Question 11 (Optional): Count special Character
        Tìm số lần xuất hiện ký tự "a" trong chuỗi*/
        System.out.println("Question 11:");
        System.out.print("Nhập chuỗi: ");
        String str1 = sc.nextLine();
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của 'a': " + count);
       /* Question 12 (Optional): Reverse String
        Đảo ngược chuỗi sử dụng vòng lặp*/
        System.out.println("Question 12:");
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();
        String reversed1 = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed1 += input.charAt(i);
        }
        System.out.println("Chuỗi đảo ngược: " + reversed);

        /*Question 13 (Optional): String not contains digit
        Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
                Ví dụ:
        "abc" => true
        "1abc", "abc1", "123", "a1bc", null => false*/
        System.out.println("Question  13:");
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();
        boolean isValid = true;
        if (s == null || s.length() == 0) {
            isValid = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
        }
        System.out.println(isValid);

       /* Question 14 (Optional): Replace character
        Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
                Ví dụ:
        "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"*/
        System.out.println("Question 14:");
        System.out.print("Nhập chuỗi: ");
        String str3 = sc.nextLine();
        System.out.print("Nhập ký tự cần thay: ");
        char oldChar = sc.next().charAt(0);
        System.out.print("Nhập ký tự thay thế: ");
        char newChar = sc.next().charAt(0);
        String result3 = str3.replace(oldChar, newChar);
        System.out.println("Chuỗi sau khi thay: " + result3);
        /*Question 15 (Optional): Revert string by word
        Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.

                Ví dụ: "    I am developer      " => "developer am I".  Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.

        Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
        */
        System.out.println("Question 15:");
        sc.nextLine(); // clear buffer nếu cần
        System.out.print("Nhập chuỗi: ");
        String input1 = sc.nextLine();
        input1 = input1.trim();
        String[] words1 = input1.split("\\s+");
        String result4 = "";
        for (int i = words1.length - 1; i >= 0; i--) {
            result4 += words1[i] + " ";
        }
        result4 = result4.trim();
        System.out.println("Chuỗi sau khi đảo: " + result4);

        /*Question 16 (Optional):
        Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
        */
        System.out.println("Question 16:");
        System.out.print("Nhập chuỗi: ");
        String str5 = sc.nextLine();
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        if (n <= 0 || str5.length() % n != 0) {
            System.out.println("KO");
        } else {
            for (int i = 0; i < str5.length(); i += n) {
                String part5 = str5.substring(i, i + n);
                System.out.println(part5);
            }
        }

    }
}

