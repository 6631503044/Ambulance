package com.pbt.ambulance_app.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.pbt.ambulance_app.model.normalcase;
import com.pbt.ambulance_app.repository.NormalCaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.pbt.ambulance_app.model.normalcase;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {

@Autowired
NormalCaseRepository normalCaseRepository ; 

//Add try catch later
    @GetMapping
    public ResponseEntity<List<normalcase>> getAppointment(@PathVariable String datefilter ){
        //set format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //set paramiter in same format
        LocalDate date = LocalDate.parse(datefilter, formatter);
        return new ResponseEntity<List<normalcase>>(normalCaseRepository.findByPickupDate(date),HttpStatus.OK);
        
    }

}
