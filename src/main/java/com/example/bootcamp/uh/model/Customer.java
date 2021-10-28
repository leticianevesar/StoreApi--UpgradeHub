package com.example.bootcamp.uh.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;
}







