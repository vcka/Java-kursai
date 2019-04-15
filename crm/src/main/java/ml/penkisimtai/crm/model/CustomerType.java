package ml.penkisimtai.crm.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CustomerType{

    @Id
    @GeneratedValue
    private Long id = null;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "customer_type")
    private CustomerTypeEnum customerTypeEnum;
}
