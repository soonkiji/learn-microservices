package com.example.website.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;

public class BookingRecord {
    public static final String BOOKING_CONFIRMED = "BOOKING_CONFIRMED";

    Long id;
    String flightNumber;
    String origin;
    String destination;
    String flightDate;
    Date bookingDate;
    String fare;
    String status;

    @JsonIgnore
    Set<Passenger> passengers;

    public BookingRecord() {
    }

    public BookingRecord(String flightNumber, String origin, String destination, String flightDate, Date bookingDate, String fare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

/*
    @Override
    public String toString() {
        return (new org.apache.commons.lang3.builder.ReflectionToStringBuilder(this,
                org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE) {
            protected boolean accept(java.lang.reflect.Field f) {
                return super.accept(f)
                        && !java.util.Collection.class.isAssignableFrom(f.getType())
                        && !f.getName().startsWith("pass");
            }
        }).toString();
    }
*/
}
