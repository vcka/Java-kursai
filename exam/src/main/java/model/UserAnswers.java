package model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_answer",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"user_id", "answer_id", "question_id"}))

@Data
@RequiredArgsConstructor
public class UserAnswers implements Serializable {

//    @NonNull
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
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="exam_id")
    private int exam_id;

    @NonNull
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private int user_id;

    private UserAnswers(){
    }
}
