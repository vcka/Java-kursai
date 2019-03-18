package model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
@RequiredArgsConstructor
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private int answer;

    @NonNull
    @JoinColumn(name ="fk_question_id")
    private int question_id;

    @NonNull
    @JoinColumn(name ="fk_exam_id2")
    private int exam_id;

    private Answers(){
    }
}
