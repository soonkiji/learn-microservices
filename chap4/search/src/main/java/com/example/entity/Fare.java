package com.example.entity;

import javax.persistence.*;

@Entity
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fare_id")
    long id;
    String fare;
    String currency;

    public Fare(String fare, String currency) {
        super();
        this.fare = fare;
        this.currency = currency;
    }

    public Fare() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
    }
}
