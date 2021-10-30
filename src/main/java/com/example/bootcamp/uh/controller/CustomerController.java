package com.example.bootcamp.uh.controller;

import com.example.bootcamp.uh.request.CustomerRequest;
import com.example.bootcamp.uh.model.Customer;
import com.example.bootcamp.uh.response.CustomerResponse;
import com.example.bootcamp.uh.service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

    private final CustomerService customerServ;

    public CustomerController(CustomerService customerServ) {
        this.customerServ = customerServ;
    }


    //Get all customers
    @GetMapping("/customers")
    public List<CustomerResponse> getCustomers() {
        List<CustomerResponse> customersRetTemp = new ArrayList<>();
        List<Customer> customers = customerServ.findAll();

        if(!customers.isEmpty()){
            for (Customer customer : customers) {
                customersRetTemp.add(new CustomerResponse(
                                customer.getId(),
                                customer.getName(),
                                customer.getAge()
                        )
                );
            }
            return customersRetTemp;
        }
        return Collections.emptyList();
    }

    //Get customer by id
    @GetMapping("/customers/{id}")
    public CustomerResponse getCustomersById(@PathVariable(value = "id") Long id) {
        Customer customer = customerServ.findById(id);

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getAge()
        );
    }

    //Create customer
    @PostMapping(value = "/customers")
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerTemp) {

        Customer newCustomer = Customer.builder()
                .name(customerTemp.getName())
                .age(customerTemp.getAge())
                .build();
        customerServ.save(newCustomer);

        return new CustomerResponse(
                newCustomer.getId(),
                newCustomer.getName(),
                newCustomer.getAge()
        );
    }

    //Update customer

    @PutMapping(value = "/updateCustomers/{id}")

    public CustomerResponse updateCustomer(@PathVariable(value = "id") Long id,@RequestBody CustomerRequest CustomerRequest) {
        Customer customer = customerServ.update(
                id,
                CustomerRequest.getName(),
                CustomerRequest.getAge()
        );
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getAge()
        );
    }

    //Delete customers by ID
    @DeleteMapping(value = "/customers/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Long id) {
        customerServ.deleteById(id);

    }
}