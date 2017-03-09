package com.example.checkin.service;

import com.example.checkin.repository.CheckInRepository;
import com.example.checkin.entity.CheckInRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    public CheckInRecord get(long id) {
        return checkInRepository.findOne(id);
    }
}
