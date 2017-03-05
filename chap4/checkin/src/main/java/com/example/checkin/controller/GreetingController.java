package com.example.checkin.controller;

import com.example.checkin.model.Greet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {
    @RequestMapping("/")
    Greet greet() {
        return new Greet("Hello World!");
    }
}

