import java.time.LocalDateTime;

public class GroupAccount {
    private Group group;
    private Account account;
    private LocalDateTime joinDate;

    public GroupAccount(Group group, Account account, LocalDateTime joinDate) {
        this.group = group;
        this.account = account;
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }
}