package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "question")
@RequiredArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;

    @OneToOne
    @JoinColumn(name = "write_answer")
    private Answer wrightAnswer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getWrightAnswer() {
        return wrightAnswer;
    }

    public void setWrightAnswer(Answer wrightAnswer) {
        this.wrightAnswer = wrightAnswer;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", wrightAnswer=" + wrightAnswer +
                ", exam=" + exam +
                '}';
    }
}
