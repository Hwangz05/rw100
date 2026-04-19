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


}