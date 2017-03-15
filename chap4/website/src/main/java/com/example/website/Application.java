package com.example.website;

import com.example.website.dto.BookingRecord;
import com.example.website.dto.Flight;
import com.example.website.dto.Passenger;
import com.example.website.dto.SearchQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
    RestTemplate searchClient = new RestTemplate();
    RestTemplate bookingClient = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("항공편을 검색해봅니다.");
        SearchQuery searchQuery = new SearchQuery("NYC", "SFO", "22-JAN-16");
        Flight[] flights = searchClient.postForObject("http://localhost:8090/search/get", searchQuery, Flight[].class);
        System.out.println(flights);
        System.out.println(Arrays.toString(flights));

        Flight flight = flights[0];
        System.out.println("검색 결과 중 첫 항공편: " + flight);
        BookingRecord booking = new BookingRecord(
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getFlightDate(),
                null,
                flight.getFares().getFare());
        Set<Passenger> passengers = new HashSet<>();
        Passenger passenger = new Passenger("John", "Doe", "Male", booking);
        System.out.println("예약 고객: " + passenger);
        passengers.add(passenger);
        booking.setPassengers(passengers);
/*
        System.out.println("예약을 해봅니다.");
        long bookingId = bookingClient.postForObject("http://localhost:8060/booking/create", booking, long.class);
        System.out.println("예약 ID: " + bookingId);
*/
    }
}
