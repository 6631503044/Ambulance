package com.pbt.ambulance_app.controller;

import com.pbt.ambulance_app.model.appointment;
import com.pbt.ambulance_app.repository.NormalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pbt.ambulance_app.service.NormalCaseService;

import java.util.List;

@RestController
@RequestMapping("/normalcase")
public class NormalCaseController {

    @Autowired
    private NormalCaseRepository normalCaseRepository;

    @Autowired
    private NormalCaseService normalCaseService;

    @GetMapping
    public List<appointment> getAllNormalCases() {
        return normalCaseRepository.findAll();
    }

    @PostMapping("/add")
    public void addNormalCase(@RequestBody appointment appointment) {
        normalCaseService.addNormalCase(appointment);
    }

    @GetMapping("/{HN}")
    public List<appointment> getNormalCaseByHN(@PathVariable Integer HN) {
        return normalCaseRepository.findByPatient_HN(HN);
    }
}

