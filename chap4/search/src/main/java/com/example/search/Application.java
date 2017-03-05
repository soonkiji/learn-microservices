package com.example.search;

import com.example.search.entity.Fares;
import com.example.search.entity.Flight;
import com.example.search.entity.Inventory;
import com.example.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {
    @Autowired
    private FlightRepository flightRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("BF100", "SEA", "SFO", "22-JAN-16", new Fares("100", "USD"), new Inventory(100)));
        flights.add(new Flight("BF101", "NYC", "SFO", "22-JAN-16", new Fares("101", "USD"), new Inventory(100)));
        flights.add(new Flight("BF102", "CHI", "SFO", "22-JAN-16", new Fares("102", "USD"), new Inventory(100)));
        flights.add(new Flight("BF103", "HOU", "SFO", "22-JAN-16", new Fares("103", "USD"), new Inventory(100)));
        flights.add(new Flight("BF104", "LAX", "SFO", "22-JAN-16", new Fares("104", "USD"), new Inventory(100)));
        flights.add(new Flight("BF105", "NYC", "SFO", "22-JAN-16", new Fares("105", "USD"), new Inventory(100)));
        flights.add(new Flight("BF106", "NYC", "SFO", "22-JAN-16", new Fares("106", "USD"), new Inventory(100)));
        flightRepository.save(flights);
        for (Flight flight : flightRepository.findByOriginAndDestinationAndFlightDate("NYC", "SFO", "22-JAN-16")) {
            System.out.println(flight);
        }
    }
}
