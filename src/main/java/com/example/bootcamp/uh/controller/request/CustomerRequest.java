package com.example.bootcamp.uh.controller.request;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String name;
    private int age;
}

