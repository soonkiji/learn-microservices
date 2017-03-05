package com.example.fares.repository;

import com.example.fares.entity.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FaresRepository extends JpaRepository<Fare, Long> {
    Fare getFareByFlightNumberAndFlightDate(@Param("flightNumber") String flightNumber, @Param("flightDate") String flightDate);
}
