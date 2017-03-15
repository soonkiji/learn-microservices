package com.example.website;

import com.example.website.dto.Flight;
import com.example.website.dto.SearchQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {
    RestTemplate searchClient = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SearchQuery searchQuery = new SearchQuery("NYC", "SFO", "22-JAN-16");
        Flight[] flights = searchClient.postForObject("http://localhost:8090/search/get", searchQuery, Flight[].class);
        System.out.println(flights);
        System.out.println(Arrays.toString(flights));
    }
}
