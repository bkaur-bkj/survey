package q.com.example.survey;

public class Answer {
    String quesId;
    String question;
    String text;
    public Answer(){

    }

    public Answer(String quesId, String question, String text) {
        this.quesId = quesId;
        this.question = question;
        this.text=text ;
    }

    public String getQuesId() {
        return quesId;
    }

    public String getQuestion() {
        return question;
    }

    public String getText() {
        return text;
    }
}
