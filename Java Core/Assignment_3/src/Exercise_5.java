import java.util.Arrays;

public class Exercise_5 {

    public static void question6() {
        Department[] departments = new Department[5];
        departments[0] = new Department(1, "Accounting");
        departments[1] = new Department(2, "Boss of director");
        departments[2] = new Department(3, "Marketing");
        departments[3] = new Department(4, "Sale");
        departments[4] = new Department(5, "Waiting room");

        Arrays.sort(departments, (d1, d2) ->
                d1.getDepartmentName().compareTo(d2.getDepartmentName())
        );
        System.out.println("Danh sách phòng ban sau khi sắp xếp:");
        for (Department d : departments) {
            System.out.println(d.getDepartmentName());
        }
    }

    public static void question7() {
        Department[] departments = new Department[5];
        departments[0] = new Department(1, "Accounting");
        departments[1] = new Department(2, "Boss of director");
        departments[2] = new Department(3, "Marketing");
        departments[3] = new Department(4, "Sale");
        departments[4] = new Department(5, "Waiting room");

        Arrays.sort(departments, (d1, d2) ->
                d1.getDepartmentName().compareTo(d2.getDepartmentName())
        );
        for (Department d : departments) {
            System.out.print(d.getDepartmentName() + " ");
        }
    }
    public static void main(String[] args) {

        Department[] departments = new Department[3];

        departments[0] = new Department();
        departments[0].setDepartmentId(1);
        departments[0].setDepartmentName("Sale");

        departments[1] = new Department();
        departments[1].setDepartmentId(2);
        departments[1].setDepartmentName("Marketing");

        departments[2] = new Department();
        departments[2].setDepartmentId(3);
        departments[2].setDepartmentName("IT");

        /*Question 1:
        In ra thông tin của phòng ban thứ 1 (sử dụng toString())*/
        System.out.println("\nQuestion 1:");
        System.out.println("Phòng ban thứ 1:");
        System.out.println(departments[0].toString());

        /*Question 2:
        In ra thông tin của tất cả phòng ban (sử dụng toString())*/
        System.out.println("\nQuestion 2 :");
        System.out.println("\nDanh sách phòng ban:");
        for (Department dep : departments) {
            System.out.println(dep.toString());
        }

        /*Question 3:
        In ra địa chỉ của phòng ban thứ 1*/
        System.out.println("\nQuestion 3:");
        System.out.println("\nĐịa chỉ của phòng ban thứ 1:");
        System.out.println(departments[0].getDepartmentName());

       /* Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?*/
        System.out.println("\nQuestion 4:");
        if (departments[0].getDepartmentName().equals("Phòng A")) {
            System.out.println("Phòng ban thứ 1 là Phòng A");
        } else {
            System.out.println("Phòng ban thứ 1 KHÔNG phải Phòng A");
        }

        /*Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
        */
        System.out.println("question 5:");
        if (departments[0].getDepartmentName().equals(departments[1].getDepartmentName())) {
            System.out.println("2 phòng ban giống nhau");
        } else {
            System.out.println("2 phòng ban khác nhau");
        }

        /*Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD:
        Accounting
        Boss of director
                Marketing
        Sale
        Waiting room
        */
        System.out.println("\nQuestion 6:");
        question6();
        /*Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban được sắp xếp theo tên VD:
        Accounting
        Boss of director Marketing waiting room Sale*/
        System.out.println("\nQuestion 7:");
        question7();
    }
}
