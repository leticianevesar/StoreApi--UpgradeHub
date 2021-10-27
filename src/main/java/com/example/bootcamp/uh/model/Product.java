package com.example.bootcamp.uh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float price;
    @Enumerated
    private ProductType type;
    @ManyToMany
    @JoinColumn(name = "customer_id")
    private Customer customer;

    }
