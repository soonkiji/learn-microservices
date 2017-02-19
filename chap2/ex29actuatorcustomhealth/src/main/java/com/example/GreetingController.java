package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired private TPSHealth health;

    @RequestMapping("/")
    Greet greet() {
        health.updateTx();
        return new Greet("Hello World!");
    }
}
