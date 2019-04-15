package ml.penkisimtai.crm.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "Customer")
@Table(name = "customer",
        uniqueConstraints = @UniqueConstraint(
                name = "customer_key",
                columnNames = {
                        "name",
                        "surname",
                        "birthDay"
                }
        ),
        indexes = @Index(
                name = "customer_customer_type_idx",
                columnList = "customer_type_id",
                unique = false
        ))

public class Customer extends SuperDomain {

    @NotNull
    @Column(length = 30)
    private String name;

    @NotNull
    @Column(length = 50)
    private String surname;

    @NotNull
    private Date birthDay;

    @NotNull
    @Formula(value = "date_part('year', age('birthDay))")
    private int age;

    @NotNull
    private String phoneNumber;

//    @NotNull
//    @ManyToOne()
//    private CustomerType customerType;

    @ManyToOne(cascade = javax.persistence.CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    @JoinTable(name = "customer_type",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_type_id"))
//    @ElementCollection(targetClass=CustomerType.class)
    protected CustomerType customerType;
}
