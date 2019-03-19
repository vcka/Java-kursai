package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @NonNull
    private String position;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
}
