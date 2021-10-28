package com.example.bootcamp.uh.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private Long id;
    private Boolean isPaid;
    private CustomerResponse customerResponse;
}
