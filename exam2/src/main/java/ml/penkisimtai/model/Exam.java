package ml.penkisimtai.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam")
@NoArgsConstructor
//@RequiredArgsConstructor
public class Exam{

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

    @Setter@Getter
    private Boolean isPublished = true;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                ", isPublished=" + isPublished +
                '}';
    }
}
