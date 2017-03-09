package com.example.checkin.repository;

import com.example.checkin.entity.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckInRecord, Long> {
}
