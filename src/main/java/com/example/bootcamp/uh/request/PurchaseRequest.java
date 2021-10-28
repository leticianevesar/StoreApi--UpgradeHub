package com.example.bootcamp.uh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    private Boolean isPaid;
    private Long customerId;
}
