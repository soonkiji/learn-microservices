package com.example.myapp.fares.controller;

import com.example.myapp.fares.entity.Fare;
import com.example.myapp.fares.service.FaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {

    @Autowired
    private FaresService faresService;

    @RequestMapping("/get")
    Fare getFare(@RequestParam(value = "flightNumber") String flightNumber,
                 @RequestParam(value = "flightDate") String flightDate) {
        return faresService.getFare(flightNumber, flightDate);
    }
}
