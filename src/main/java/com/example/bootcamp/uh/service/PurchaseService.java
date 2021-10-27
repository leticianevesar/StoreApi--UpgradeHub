package com.example.bootcamp.uh.service;

import com.example.bootcamp.uh.exception.CustomerNotFound;
import com.example.bootcamp.uh.exception.PurchaseNotFound;
import com.example.bootcamp.uh.model.Customer;
import com.example.bootcamp.uh.model.Product;
import com.example.bootcamp.uh.model.Purchase;
import com.example.bootcamp.uh.repository.CustomerRepository;
import com.example.bootcamp.uh.repository.ProductRepository;
import com.example.bootcamp.uh.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElseThrow(PurchaseNotFound::new);
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
    }
    public Purchase addPurchase(Long customerId, Purchase purchase) {
        Customer customer = this.findCustomerById(customerId);
        purchase.setCustomer(customer);
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Long purchaseId, Boolean isPaid, Long customerId) {
        Purchase purchase = this.findById(purchaseId);
        purchase.setCustomer(this.findCustomerById(customerId));
        purchase.setIsPaid(isPaid);
        purchaseRepository.save(purchase);
        return purchase;
    }

    public void deleteById(Long id) {
        Purchase purchase = this.findById(id);

        if(!purchase.getPurchase_product().isEmpty()){
            for(Product product : purchase.getPurchase_product()){
                productRepository.deleteById(product.getId());
            }
        }
        purchaseRepository.deleteById(id);
    }
}