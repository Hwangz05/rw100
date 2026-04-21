import java.time.LocalDateTime;
import java.util.List;

public class Exam {
    private int examId;
    private String code;
    private String title;
    private CategoryQuestion category;
    private int duration;
    private Account creator;
    private LocalDateTime createDate;
    private List<Question> questions;

    public Exam(int examId, String code, String title, CategoryQuestion category, int duration, Account creator, LocalDateTime createDate) {
        this.examId = examId;
        this.code = code;
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public int getExamId() {
        return examId;
    }

    public String getCode() {
        return code;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public int getDuration() {
        return duration;
    }

    public Account getCreator() {
        return creator;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}