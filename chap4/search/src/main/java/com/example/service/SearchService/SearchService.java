package com.example.service.SearchService;

import com.example.entity.Flight;
import com.example.model.SearchQuery;
import com.example.repository.FlightRepository;
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
            // flight.getFares();
            int inv = flight.getInventory().getCount();
            if (inv > 0) {
                result.add(flight);
            }
        }
        return result;
    }
}
