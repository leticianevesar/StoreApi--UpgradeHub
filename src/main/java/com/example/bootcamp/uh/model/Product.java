package com.example.bootcamp.uh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float price;
    @Enumerated
    private ProductType type;

    @ManyToMany(mappedBy = "purchase_product")
    private List<Purchase> purchases;

    }
