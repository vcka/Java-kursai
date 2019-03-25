package model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @NonNull
    private String userName;

    @Getter
    @Setter
    @NonNull
    private String email;

    @Getter
    @Setter
    @NonNull
    private String password;

    @Getter
    @Setter
    @NonNull
    private boolean isAdmin = false;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private Set<UserAnswer> userAnswers = new HashSet<>();

//    @OneToOne
//    @Getter@Setter
//    private UserAnswer userAnswer;

    public void addUserAnswer(UserAnswer userAnswer) {
        userAnswers.add(userAnswer);
        userAnswer.setUser(this);
    }

    public void removeUserAnswer(UserAnswer userAnswer) {
        userAnswer.setAnswer(null);
        this.userAnswers.remove(userAnswer);
    }
}
