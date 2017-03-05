package com.example.book.service;

import com.example.book.entity.BookingRecord;
import com.example.book.entity.Fare;
import com.example.book.entity.Inventory;
import com.example.book.entity.Passenger;
import com.example.book.exception.BookingException;
import com.example.book.repository.BookingRepository;
import com.example.book.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class BookingService {
    private String FareURL = "http://localhost:8080/fares";

    // @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    MessageSender messageSender;

    public long book(BookingRecord bookingRecord) {
        String me = "book()";
        System.out.println(me + " bookingRecord from client: " + bookingRecord);

        String url = String.format("%s/get?flightNumber=%s&flightDate=%s", FareURL, bookingRecord.getFlightNumber(), bookingRecord.getFlightDate());
        System.out.println(me + " Connecting to " + url);
        Fare fare = restTemplate.getForObject(url, Fare.class);
        System.out.println(me + " fare from fares microservice: " + fare);

        Inventory inventory = inventoryRepository.findByFlightNumberAndFlightDate(bookingRecord.getFlightNumber(), bookingRecord.getFlightDate());
        if (!inventory.isAvailable(bookingRecord.getPassengers().size())) {
            throw new BookingException("No more seats available");
        }
        System.out.println(me + " inventory from db: " + inventory);

        inventory.setAvailable(inventory.getAvailable() - bookingRecord.getPassengers().size());
        inventoryRepository.saveAndFlush(inventory);
        System.out.println(me + " inventory saved to db: " + inventory);

        bookingRecord.setStatus(BookingRecord.BOOKING_CONFIRMED);
        for (Passenger passenger : bookingRecord.getPassengers()) {
            passenger.setBookingRecord(bookingRecord);
        }
        bookingRecord.setBookingDate(new Date());

        Long id = bookingRepository.save(bookingRecord).getId();
        System.out.println(me + " booked: " + id);
        Map<String, Object> bookingDetails = new HashMap<>();
        bookingDetails.put("FLIGHT_NUMBER", bookingRecord.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", bookingRecord.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", inventory.getBookableInventory());
        messageSender.send(bookingDetails);
        return id;
    }

    public BookingRecord getBooking(long id) {
        return bookingRepository.findOne(id);
    }
}
