package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {
    @RequestMapping("/")
    Greet greet() {
        return new Greet("Hello World!");
    }
}

class Greet {
    private String message;

    public Greet() {
    }

    public Greet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
