package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository repo) {
        return (evt) -> {
            repo.save(new Customer("Harry", "harry@example.com"));
            repo.save(new Customer("Sally", "sally@example.com"));
            repo.save(new Customer("Tayaee", "tayaee@example.com"));
        };
    }
}
