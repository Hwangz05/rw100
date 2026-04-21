import java.time.LocalDateTime;
import java.util.List;

public class Group {
    private int groupId;
    private String groupName;
    private Account creator;
    private LocalDateTime createDate;
    private List<Account> accounts;

    public Group(int groupId, String groupName, Account creator, LocalDateTime createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    public String getGroupName() {
        return groupName;
    }



}