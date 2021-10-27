package com.example.bootcamp.uh.controller.request;

import com.example.bootcamp.uh.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

        private ProductType type;
        private String name;
        private float price;
    }


