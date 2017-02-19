package com.example.myapp.fares.service;

import com.example.myapp.fares.entity.Fare;
import com.example.myapp.fares.repository.FaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FaresService {
    @Autowired
    FaresRepository faresRepository;

    public Fare getFare(String flightNumber, String flightDate) {
        return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
    }
}
