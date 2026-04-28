public class Answer {
    private int answerId;
    private String content;
    private Question question;
    private boolean isCorrect;

    public Answer(int answerId, String content, Question question, boolean isCorrect) {
        this.answerId = answerId;
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public String getContent() {
        return content;
    }
}
