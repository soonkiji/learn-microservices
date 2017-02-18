package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerController {
    @Autowired
    private CustomerRegistrar customerRegistrar;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    Customer register(@RequestBody Customer customer) {
        return customerRegistrar.register(customer);
    }
}
