package com.pbt.ambulance_app.service;

import com.pbt.ambulance_app.model.appointment;
import com.pbt.ambulance_app.repository.NormalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalCaseService {

    @Autowired
    private NormalCaseRepository normalCaseRepository;

    public List<appointment> getAllNormalCase() {
        List<appointment> appointments = new ArrayList<>();
        normalCaseRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    public void addNormalCase(appointment appointment) {
        normalCaseRepository.save(appointment);
    }
}
