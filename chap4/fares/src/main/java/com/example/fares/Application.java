package com.example.fares;

import com.example.fares.entity.Fare;
import com.example.fares.repository.FaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {
    @Autowired
    FaresRepository faresRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        faresRepository.save(new Fare("BF100", "22-JAN-16", "100"));
        faresRepository.save(new Fare("BF101", "22-JAN-16", "101"));
        faresRepository.save(new Fare("BF102", "22-JAN-16", "102"));
        faresRepository.save(new Fare("BF103", "22-JAN-16", "103"));
        faresRepository.save(new Fare("BF104", "22-JAN-16", "104"));
        faresRepository.save(new Fare("BF105", "22-JAN-16", "105"));
        faresRepository.save(new Fare("BF106", "22-JAN-16", "106"));
        System.out.println(faresRepository.findAll());
    }
}
