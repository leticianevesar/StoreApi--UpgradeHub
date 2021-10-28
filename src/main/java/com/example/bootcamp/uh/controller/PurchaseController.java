package com.example.bootcamp.uh.controller;

import com.example.bootcamp.uh.request.PurchaseRequest;
import com.example.bootcamp.uh.response.CustomerResponse;
import com.example.bootcamp.uh.response.PurchaseResponse;
import com.example.bootcamp.uh.model.Purchase;
import com.example.bootcamp.uh.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(value = "/purchases")
    public List<PurchaseResponse> getAllPurchases() {
        List<Purchase> purchases = purchaseService.findAllPurchases();
        List<PurchaseResponse> purchaseResponseList = new ArrayList<>();
        for (Purchase purchase : purchases) {
            purchaseResponseList.add(
                    new PurchaseResponse(
                            purchase.getId(),
                            purchase.getIsPaid(),
                            new CustomerResponse(
                                    purchase.getCustomer().getId(),
                                    purchase.getCustomer().getName(),
                                    purchase.getCustomer().getAge()
                            )
                    ));
        }
        return purchaseResponseList;
    }

    @GetMapping(value = "/purchases/{id}")
    public PurchaseResponse getPurchaseById(@PathVariable(value = "id") Long id) {
        Purchase purchase = purchaseService.findById(id);
        return new PurchaseResponse(
                purchase.getId(),
                purchase.getIsPaid(),
                new CustomerResponse(
                        purchase.getCustomer().getId(),
                        purchase.getCustomer().getName(),
                        purchase.getCustomer().getAge()
                )
        );
    }

    @PostMapping(value = "/purchases")
    public PurchaseResponse addPurchaseToCustomer(@RequestBody PurchaseRequest purchaseRequest) {
        Purchase purchase = purchaseService.addPurchase(purchaseRequest.getCustomerId(), Purchase.builder()
                .isPaid(purchaseRequest.getIsPaid())
                .build());
        return new PurchaseResponse(
                purchase.getId(),
                purchase.getIsPaid(),
                new CustomerResponse(
                        purchase.getCustomer().getId(),
                        purchase.getCustomer().getName(),
                        purchase.getCustomer().getAge()
                )
        );
    }

    @PutMapping(value = "/purchases/{id}")
    public PurchaseResponse updatePurchase(@RequestBody PurchaseRequest newPurchaseRequest, @PathVariable(value = "id")Long purchaseId) {
        Purchase purchase = purchaseService.updatePurchase(purchaseId, newPurchaseRequest.getIsPaid(), newPurchaseRequest.getCustomerId());
        return new PurchaseResponse(
                purchase.getId(),
                purchase.getIsPaid(),
                new CustomerResponse(
                        purchase.getCustomer().getId(),
                        purchase.getCustomer().getName(),
                        purchase.getCustomer().getAge()
                )
        );
    }

    @DeleteMapping(value = "/purchases/{id}")
    public void deletePurchaseById(@PathVariable(value = "id")Long id){
        purchaseService.deleteById(id);
    }
}
