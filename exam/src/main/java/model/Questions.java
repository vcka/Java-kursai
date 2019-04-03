package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "questions")
//@Data
@RequiredArgsConstructor
public class Questions {
    @Setter@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter@Getter
    @NonNull
    private String question;

    @Getter@Setter
//    @NonNull
//    @ManyToOne(cascade = CascadeType.ALL)
////    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="exam_id")
//    @MapsId
    private int exam_id;

    public Questions(){
    }

//    public void setExam_id(int exam) {
//        this.exam_id.setId(exam);
//    }
}
