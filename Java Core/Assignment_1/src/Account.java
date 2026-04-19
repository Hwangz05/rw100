import java.time.LocalDateTime;

public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDateTime createDate;

    public Account(int accountId, String email, String userName, String fullName, Department department, Position position, LocalDateTime createDate) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    public String getFullName() {
        return fullName;
    }
}