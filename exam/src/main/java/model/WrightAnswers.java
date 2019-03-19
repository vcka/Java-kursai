package model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "wright_answer")
@Data
@RequiredArgsConstructor
public class WrightAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private int answer_id;

    @NonNull
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="question_id")
    private int question_id;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="exam_id")
    private Exams exam_id;

    private WrightAnswers(){
    }
}
