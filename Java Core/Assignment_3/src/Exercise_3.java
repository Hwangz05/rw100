public class Exercise_3 {
   public static void main(String[] args) {
      /* Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
*/
       System.out.println("Question 1:");
       Integer salary = 5000;
       float salaryFloat = salary.floatValue();
       System.out.printf("Lương: %.2f\n", salaryFloat);

       /*Question 2:
       Khai báo 1 String có value = "1234567"
       Hãy convert String đó ra số int*/
       System.out.println("Question 2:");
       String str = "1234567";
       int number = Integer.parseInt(str);
       System.out.println("Số int: " + number);

       /*Question 3:
       Khởi tạo 1 số Integer có value là chữ "1234567"
       Sau đó convert số trên thành datatype int*/

       System.out.println("Question 3:");
       Integer num = Integer.valueOf("1234567");
       int result = num.intValue();
       System.out.println("Số int: " + result);

   }
}
