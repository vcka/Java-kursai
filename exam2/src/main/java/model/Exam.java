package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exam")
@RequiredArgsConstructor
public class Exam {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter@Getter
    private String name;

    @Setter
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "exam", orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

    public void addQuestion(Question question) {
        questions.add(question);
        question.setExam(this);
    }

    public void removeQuestion(Question question) {
        question.setExam(null);
        this.questions.remove(question);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questions=\n" + questions +
                '}';
    }
}
