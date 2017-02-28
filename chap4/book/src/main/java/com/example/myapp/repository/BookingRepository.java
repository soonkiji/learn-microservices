package com.example.myapp.repository;

import com.example.myapp.entity.BookingRecord;
import com.example.myapp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
}
