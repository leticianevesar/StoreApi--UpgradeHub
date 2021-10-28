package com.example.bootcamp.uh.request;

import lombok.*;

import javax.persistence.Entity;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String name;
    private int age;
}

