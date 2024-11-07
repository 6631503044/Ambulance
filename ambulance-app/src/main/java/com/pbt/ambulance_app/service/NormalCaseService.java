package com.pbt.ambulance_app.service;

import com.pbt.ambulance_app.model.normalcase;
import com.pbt.ambulance_app.repository.NormalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalCaseService {

    @Autowired
    private NormalCaseRepository normalCaseRepository;

    public List<normalcase> getAllNormalCase() {
        List<normalcase> normalcases = new ArrayList<>();
        normalCaseRepository.findAll().forEach(normalcases::add);
        return normalcases;
    }

    public void addNormalCase(normalcase normalcase) {
        normalCaseRepository.save(normalcase);
    }
}
