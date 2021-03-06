package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PhoneNumer phoneNumer;

    private Person(){
    }
}