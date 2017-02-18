package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRegistrar {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("cannot register.");
        } else {
            customerRepository.save(customer);
        }
        return customer;
    }
}
