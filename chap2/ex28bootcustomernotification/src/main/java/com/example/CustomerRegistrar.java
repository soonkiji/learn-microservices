package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRegistrar {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private QueueSender queueSender;

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException(String.format("Customer '%s' exists. Not accepted.", customer.getName()));
        } else {
            customerRepository.save(customer);
            queueSender.send(customer.getEmail());
        }
        return customer;
    }
}
