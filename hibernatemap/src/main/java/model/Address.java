package model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import javax.persistence.GeneratedValue;

@Entity
@Data
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    @OneToOne(mappedBy="address")
    private User user;
}