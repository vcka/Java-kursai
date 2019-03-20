package model;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Employee {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @Getter
    @Setter
    @NonNull
    private String position;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @Setter
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    public Set<Contact> getContacts(){
        return contacts == null ? new HashSet<>() : contacts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", position='" + position + '\'' +
                ", company=" + company +
                '}';
    }
}
