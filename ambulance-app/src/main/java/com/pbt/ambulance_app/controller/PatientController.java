package com.pbt.ambulance_app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.pbt.ambulance_app.model.*;
import com.pbt.ambulance_app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientrepo;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PatientStatusRepository patientStatusRepository;
    @Autowired
    private PatientTypeRepository patientTypeRepository;
    @Autowired
    private AgeRepository ageRepository;
    @Autowired
    private AreaRepository areaRepository;

    // It's need these 4 parameter to make it work
    @GetMapping("/{page}/{filter}/{gender}/{type}")
    public List<patient> searchByHN(
            @PathVariable Integer page,
            @PathVariable Integer filter,
            @PathVariable Integer gender,
            @PathVariable Integer type) {

        StringBuilder jpql = new StringBuilder("SELECT p FROM patient p WHERE 1=1");

        // Apply gender filter if specified
        if (gender != 0) {
            jpql.append(" AND p.gender = :gender");
        }

        // Apply type filter if specified
        if (type != 0) {
            jpql.append(" AND p.patientType.patientTypeId = :type");
        }

        // Apply ordering based on filter
        switch (filter) {
            case 1: // Highest HN to lowest HN
                jpql.append(" ORDER BY p.HN DESC");
                break;
            case 2: // Lowest HN to highest HN
                jpql.append(" ORDER BY p.HN ASC");
                break;
            case 3: // Highest age to lowest age
                jpql.append(" ORDER BY p.age_Id DESC");
                break;
            case 4: // Lowest age to highest age
                jpql.append(" ORDER BY p.age_Id ASC");
                break;
            default:
                jpql.append(" ORDER BY p.HN ASC"); // Default ordering by HN ascending
                break;
        }

        Query query = entityManager.createQuery(jpql.toString(), patient.class);

        // Set parameters if conditions apply
        if (gender != 0) {
            String genderValue = (gender == 1) ? "male" : "female";
            query.setParameter("gender", genderValue);
        }
        if (type != 0) {
            query.setParameter("type", type);
        }

        // Set pagination (10 records per page)
        int pageSize = 10;
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);

        // Execute the query and return the results
        return query.getResultList();
    }

    @PutMapping("")
    public ResponseEntity<String> editByHN( @RequestBody patient updatedPatient) {
        // Find the patient by HN
        Optional<patient> optionalPatient = patientrepo.findById(updatedPatient.getHN());

        if (optionalPatient.isPresent()) {
            patient existingPatient = optionalPatient.get();

            // Update fields in the existing patient with the new data
            existingPatient.setPatientStatus((updatedPatient.getPatientStatus()));
            existingPatient.setAge((updatedPatient.getAge()));
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
            existingPatient.setPatientType((updatedPatient.getPatientType()));

            // Save the updated patient
            patientrepo.save(existingPatient);

            return ResponseEntity.ok("Patient record updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Patient with HN " + updatedPatient.getHN() + " not found.");
        }
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Map<String, Object> newPatientData) {
        // Extract fields from the JSON map
        Integer hn = (Integer) newPatientData.get("HN");  // assuming HN is an Integer
        String phoneNumber = (String) newPatientData.get("phoneNumber");
        String gender = (String) newPatientData.get("gender");
        String location = (String) newPatientData.get("location");
        String description = (String) newPatientData.get("description");

        // Check if a patient with the given HN already exists
        if (patientrepo.findById(hn).isPresent()) {
            return ResponseEntity.status(409).body("This patient already exists");
        } else {
            // Create a new Patient object and set its fields
            patient newPatient = new patient();
            newPatient.setHN(hn);
            newPatient.setPhoneNumber(phoneNumber);
            newPatient.setGender(gender);
            newPatient.setLocation(location);
            newPatient.setDescription(description);

            // Optionally handle related entities if they are included in JSON data
            // Example for patient status
            Integer patientStatusId = (Integer) newPatientData.get("patientStatusId");
            if (patientStatusId != null) {
                patientstatus patientStatus = patientStatusRepository.findById(patientStatusId).orElse(null);
                newPatient.setPatientStatus(patientStatus);
            }

            // Example for patient type
            Integer patientTypeId = (Integer) newPatientData.get("patientTypeId");
            if (patientTypeId != null) {
                patienttype patientType = patientTypeRepository.findById(patientTypeId).orElse(null);
                newPatient.setPatientType(patientType);
            }

            // Example for age group
            Integer ageId = (Integer) newPatientData.get("ageId");
            if (ageId != null) {
                age age = ageRepository.findById(ageId).orElse(null);
                newPatient.setAge(age);
            }

            // Example for area
            Integer areaId = (Integer) newPatientData.get("areaId");
            if (areaId != null) {
                area area = areaRepository.findById(areaId).orElse(null);
                newPatient.setArea(area);
            }

            // Save the new patient and return 201 Created message
            patientrepo.save(newPatient);
            return ResponseEntity.status(201).body("Successfully Created");
        }
    }
    
}