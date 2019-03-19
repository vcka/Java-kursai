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
    @ManyToOne(cascade = CascadeType.ALL)
//    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="exam_id")
//    @MapsId
    private Exams exam_id;

    private Questions(){
    }
}
