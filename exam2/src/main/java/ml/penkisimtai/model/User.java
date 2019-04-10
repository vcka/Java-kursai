package ml.penkisimtai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
//@NoArgsConstructor
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Getter
//    @Setter
//    @NonNull
//    private String userName;
//
//    @Getter
//    @Setter
//    @NonNull
//    private String email;
//
//    @Getter
//    @Setter
//    @NonNull
//    private String password;
//
//    @Getter
//    @Setter
//    @NonNull
//    private boolean isAdmin = false;

    @Getter
    @Setter
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Getter
    @Setter
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Getter
    @Setter
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Getter
    @Setter
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "active")
    private int active;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private Set<UserAnswer> userAnswers = new HashSet<>();

//    @Getter
//    @Setter
//    @Column(name = "enabled")
//    @JsonIgnore
//    private boolean enabled;

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
