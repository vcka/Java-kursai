package ml.penkisimtai.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
@RequiredArgsConstructor
public class Question {
    @Setter@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter@Setter
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Calendar createdDate;


    @Setter@Getter
    private String question;

    @Setter@Getter
    @ManyToOne
    private Exam exam;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", orphanRemoval = true)
    private Set<Answer> answers = new HashSet<>();

    @Getter@Setter
    @OneToOne
    private Answer right_answer;

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer) {
        answer.setQuestion(null);
        this.answers.remove(answer);
    }

    public void addRightAnswer(Answer answer) {
        this.right_answer = answer;
        right_answer.setQuestion(this);
    }

    public void removeRightAnswer(Answer right_answer) {
        if (right_answer != null) {
            right_answer.setQuestion(null);
        }
        this.right_answer = null;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", question=\n'" + question + '\'' +
                ", \nanswers=" + answers +
                ", \nright_answer=" + right_answer +
                '}';
    }
}
