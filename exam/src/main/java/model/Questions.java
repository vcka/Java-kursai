package model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Data
@RequiredArgsConstructor
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String question;

    @NonNull
    @JoinColumn(name ="fk_exam_id")
    private int exam_id;

    private Questions(){
    }
}
