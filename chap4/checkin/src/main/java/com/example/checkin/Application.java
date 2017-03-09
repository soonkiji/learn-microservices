package com.example.checkin;

import com.example.checkin.entity.CheckInRecord;
import com.example.checkin.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {
    @Autowired
    CheckInRepository checkInRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        checkInRepository.save(new CheckInRecord("John", "Doe"));
        checkInRepository.save(new CheckInRecord("Jane", "Doe"));
        List<CheckInRecord> all = checkInRepository.findAll();
        for (CheckInRecord e : all) {
            System.out.println(e);
        }
    }
}
