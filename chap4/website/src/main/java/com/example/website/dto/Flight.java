package com.example.website.dto;

import org.apache.commons.lang3.builder.ToStringStyle;

public class Flight {
    long id;
    String flightNumber;
    String origin;
    String destination;
    String flightDate;
    Fares fares;

    public Flight() {
    }

    public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public Fares getFares() {
        return fares;
    }

    public void setFares(Fares fares) {
        this.fares = fares;
    }

    @Override
    public String toString() {
        return (new org.apache.commons.lang3.builder.ReflectionToStringBuilder(this,
                ToStringStyle.MULTI_LINE_STYLE) {
            protected boolean accept(java.lang.reflect.Field f) {
                return super.accept(f)
                        && !java.util.Collection.class.isAssignableFrom(f.getType())
                        && !f.getName().startsWith("passw");
            }
        }).toString();
    }
}
