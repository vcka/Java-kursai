package model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "phonenr")
@Data
@AllArgsConstructor
public class PhoneNumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Nullable
    private String phonenumber;

    @NonNull
    @JoinColumn(name ="fk_person_id")
    private int person_id;

    private PhoneNumer(){
    }
}
