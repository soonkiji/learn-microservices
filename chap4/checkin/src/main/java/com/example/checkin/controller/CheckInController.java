package com.example.checkin.controller;

import com.example.checkin.dto.CheckInRecord;
import com.example.checkin.service.CheckInService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    CheckInRecord get(
            @PathVariable
            @ApiParam(value = "id", example = "1")
            long id) {
        com.example.checkin.entity.CheckInRecord checkInEntity = checkInService.get(id);
        com.example.checkin.dto.CheckInRecord checkInDto = new CheckInRecord();
        BeanUtils.copyProperties(checkInEntity, checkInDto);
        return checkInDto;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    long checkIn(@RequestBody CheckInRecord checkIn) {
        return 0;
    }
}
