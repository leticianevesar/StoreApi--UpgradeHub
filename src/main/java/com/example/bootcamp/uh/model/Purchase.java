package com.example.bootcamp.uh.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "purchase_product",
            joinColumns = @JoinColumn(name = "purchaseId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> purchase_product;
}
