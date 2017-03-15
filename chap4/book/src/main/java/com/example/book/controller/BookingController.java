package com.example.book.controller;

import com.example.book.entity.BookingRecord;
import com.example.book.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8001")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long book(@RequestBody BookingRecord bookingRecord) {
        System.out.println("예약 정보: " + bookingRecord);
        long bookingId = bookingService.book(bookingRecord);
        System.out.println("예약 ID: " + bookingId);
        return bookingId;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    BookingRecord getBooking(@PathVariable long id) {
        return bookingService.getBooking(id);
    }
}