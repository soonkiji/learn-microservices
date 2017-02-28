package com.example.myapp.repository;

import com.example.myapp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByFlightNumberAndFlightDate(@Param("flightNumber") String flightNumber, @Param("flightDate") String flightDate);
}
