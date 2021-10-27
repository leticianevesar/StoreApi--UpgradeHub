package com.example.bootcamp.uh.controller;

import lombok.*;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private int age;

}
