package com.example.myapp;

import com.example.myapp.entity.BookingRecord;
import com.example.myapp.entity.Inventory;
import com.example.myapp.entity.Passenger;
import com.example.myapp.repository.InventoryRepository;
import com.example.myapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    BookingService bookingService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String me = "run()";
        inventoryRepository.save(new Inventory("BF100", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF101", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF102", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF103", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF104", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF105", "22-JAN-16", 10));
        inventoryRepository.save(new Inventory("BF106", "22-JAN-16", 10));
        {
            BookingRecord bookingRecord = new BookingRecord("BF101", "NYC", "SFO", "22-JAN-16", new Date(), "$100.99");
            Set<Passenger> passengers = new HashSet<>();
            passengers.add(new Passenger("John", "Doe", "M", bookingRecord));
            bookingRecord.setPassengers(passengers);
            System.out.println(me + " Booking " + bookingRecord);
            Long id = bookingService.book(bookingRecord);
            System.out.println(me + " Booked ID " + id);
            BookingRecord booked = bookingService.getBooking(id);
            System.out.println(me + " booked record " + booked);
        }
        /*-
        {
            BookingRecord bookingRecord = new BookingRecord("BF101", "NYC", "SFO", "22-JAN-16", new Date(), "$110.99");
            Set<Passenger> passengers = new HashSet<>();
            passengers.add(new Passenger("John", "Doe", "M", bookingRecord));
            bookingRecord.setPassengers(passengers);
            System.out.println(me + " Booking " + bookingRecord);
            Long id = bookingService.book(bookingRecord);
            System.out.println(me + " Booked ID " + id);
            BookingRecord booked = bookingService.getBooking(id);
            System.out.println(me + " booked record " + booked);
        }
        {
            BookingRecord bookingRecord = new BookingRecord("BF101", "NYC", "SFO", "22-JAN-16", new Date(), "$120.99");
            Set<Passenger> passengers = new HashSet<>();
            passengers.add(new Passenger("John", "Doe", "M", bookingRecord));
            bookingRecord.setPassengers(passengers);
            System.out.println(me + " Booking " + bookingRecord);
            Long id = bookingService.book(bookingRecord);
            System.out.println(me + " Booked ID " + id);
            BookingRecord booked = bookingService.getBooking(id);
            System.out.println(me + " booked record " + booked);
        }
        */
    }
}
