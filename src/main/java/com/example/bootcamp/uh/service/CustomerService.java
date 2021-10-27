package com.example.bootcamp.uh.service;

import com.example.bootcamp.uh.exception.CustomerNotFound;
import com.example.bootcamp.uh.model.Customer;
import com.example.bootcamp.uh.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

        private final CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepo) {
            this.customerRepository = customerRepo;

        }

        public Customer findById(Long aLong) {
            return customerRepository.findById(aLong).orElseThrow(CustomerNotFound::new);
        }

        public List<Customer> findAll() {
            return customerRepository.findAll();
        }

        public void deleteById(Long aLong) {

            Customer customerToDelete = this.findById(aLong);
            customerRepository.deleteById(aLong);
        }

        public <S extends Customer> S save(S entity) {
            return customerRepository.save(entity);
        }

        public Customer update(Long id, String name, int age) {
            Customer customer = this.findById(id);
            customer.setName(name);
            customer.setAge(age);

            return customerRepository.save(customer);

        }
    }
