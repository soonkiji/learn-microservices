package com.example.checkin.controller;

import com.example.checkin.schema.CheckInRecord;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    @RequestMapping(value = "/get/{id}")
    CheckInRecord get(@PathVariable long id) {
        return new CheckInRecord();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long checkIn(@RequestBody CheckInRecord checkIn) {
        return 0;
    }
}
