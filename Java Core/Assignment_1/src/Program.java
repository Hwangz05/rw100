import java.time.LocalDateTime;
import java.util.Arrays;

public class Program {
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

        // Out
        System.out.println("Phòng ban 1: " + d1.getDepartmentName());
        System.out.println("Chức vụ 1: " + p1.getPositionName());
        System.out.println("Tên đầy đủ của tài khoản 1: " + a1.getFullName());
        System.out.println("Nhóm 1: " + g1.getGroupName());
        System.out.println("GroupAccount 1: Group = " + ga1.getGroup().getGroupName());
        System.out.println("Loại câu hỏi 1: " + tq1.getTypeName());
        System.out.println("Danh mục câu hỏi 1: " + c1.getCategoryName());
        System.out.println("Câu hỏi 1: " + q1.getContent());
        System.out.println("Câu trả lời 1: " + ans1.getContent());
        System.out.println("Đề thi 1: " + e1.getTitle());
        System.out.println("ExamQuestion 1: Exam = " + eq1.getExam().getTitle());



    }
}