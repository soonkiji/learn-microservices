package com.example.search.service;

import com.example.search.entity.Flight;
import com.example.search.entity.Inventory;
import com.example.search.model.SearchQuery;
import com.example.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> search(SearchQuery query) {
        String origin = query.getOrigin();
        String destination = query.getDestination();
        String flightDate = query.getFlightDate();
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(origin, destination, flightDate);
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            int inv = flight.getInventory().getCount();
            if (inv > 0) {
                result.add(flight);
            }
        }
        return result;
    }

    public void updateInventory(String flightNumber, String flightDate, int newInventory) {
        Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
        Inventory inv = flight.getInventory();
        inv.setCount(newInventory);
        flightRepository.save(flight);
    }
}
