package com.example.myapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue
    long id;

    String flightNumber;

    String flightDate;

    int available;

    public Inventory() {
    }

    public Inventory(String flightNumber, String flightDate, int available) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.available = available;
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

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public boolean isAvailable(int count) {
        return (available - count) > 5;
    }

    public int getBookableInventory() {
        return available - 5;
    }

    @Override
    public String toString() {
        return (new org.apache.commons.lang3.builder.ReflectionToStringBuilder(this,
                org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE) {
            protected boolean accept(java.lang.reflect.Field f) {
                return super.accept(f)
                        && !java.util.Collection.class.isAssignableFrom(f.getType())
                        && !f.getName().startsWith("passw");
            }
        }).toString();
    }
}
