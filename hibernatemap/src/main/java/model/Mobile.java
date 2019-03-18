package model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Mobile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
