package com.example.book.repository;

import com.example.book.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByFlightNumberAndFlightDate(@Param("flightNumber") String flightNumber, @Param("flightDate") String flightDate);
}
