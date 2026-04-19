import java.time.LocalDateTime;
import java.util.List;

public class Question {
    private int questionId;
    private String content;
    private CategoryQuestion category;
    private TypeQuestion type;
    private Account creator;
    private LocalDateTime createDate;
    private List<Answer> answers;

    public Question(int questionId, String content, CategoryQuestion category, TypeQuestion type, Account creator, LocalDateTime createDate) {
        this.questionId = questionId;
        this.content = content;
        this.category = category;
        this.type = type;
        this.creator = creator;
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }
}