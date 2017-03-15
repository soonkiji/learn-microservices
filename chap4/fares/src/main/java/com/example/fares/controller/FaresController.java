package com.example.fares.controller;

import com.example.fares.entity.Fare;
import com.example.fares.service.FaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {

    @Autowired
    private FaresService faresService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Fare getFare(@RequestParam(value = "flightNumber") String flightNumber,
                 @RequestParam(value = "flightDate") String flightDate) {
        return faresService.getFare(flightNumber, flightDate);
    }
}
