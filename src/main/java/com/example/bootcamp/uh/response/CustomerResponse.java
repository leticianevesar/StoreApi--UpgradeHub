package com.example.bootcamp.uh.response;

import lombok.*;
import javax.persistence.Entity;


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
