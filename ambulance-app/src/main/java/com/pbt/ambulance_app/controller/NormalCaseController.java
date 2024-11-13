package com.pbt.ambulance_app.controller;

import com.pbt.ambulance_app.model.normalcase;
import com.pbt.ambulance_app.repository.NormalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<normalcase> getAllNormalCases() {
        return normalCaseRepository.findAll();
    }

    @PostMapping("/add")
    public void addNormalCase(@RequestBody normalcase normalcase) {
        normalCaseService.addNormalCase(normalcase);
    }

    @GetMapping("/{HN}")
    public List<normalcase> getNormalCaseByHN(@PathVariable Integer HN) {
        return normalCaseRepository.findByPatient_HN(HN);
    }
}

