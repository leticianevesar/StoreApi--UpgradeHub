package com.example.bootcamp.uh.response;

import com.example.bootcamp.uh.model.ProductType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private ProductType type;
    private String name;
    private float price;
}
