package com.pbt.ambulance_app.controller;

import java.util.List;
import java.util.Optional;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbt.ambulance_app.model.Patient;
import com.pbt.ambulance_app.repository.PatientRepository;

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

    // It's need these 4 parameter to make it work
    @GetMapping("/{page}/{filter}/{gender}/{type}")
    public List<Patient> searchByHN(
            @PathVariable Integer page,
            @PathVariable Integer filter,
            @PathVariable Integer gender,
            @PathVariable Integer type) {

        StringBuilder jpql = new StringBuilder("SELECT p FROM Patient p WHERE 1=1");

        // Apply gender filter if specified
        if (gender != 0) {
            jpql.append(" AND p.gender = :gender");
        }

        // Apply type filter if specified
        if (type != 0) {
            jpql.append(" AND p.patient_Type_Id = :type");
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

        Query query = entityManager.createQuery(jpql.toString(), Patient.class);

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
    public ResponseEntity<String> editByHN( @RequestBody Patient updatedPatient) {
        // Find the patient by HN
        Optional<Patient> optionalPatient = patientrepo.findById(updatedPatient.getHN());

        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();

            // Update fields in the existing patient with the new data
            existingPatient.setPatient_Status_Id(updatedPatient.getPatient_Status_Id());
            existingPatient.setAge_Id(updatedPatient.getAge_Id());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setPhone_Number(updatedPatient.getPhone_Number());
            existingPatient.setPatient_Type_Id(updatedPatient.getPatient_Type_Id());

            // Save the updated patient
            patientrepo.save(existingPatient);

            return ResponseEntity.ok("Patient record updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Patient with HN " + updatedPatient.getHN() + " not found.");
        }
    }

    @PostMapping("")
    public ResponseEntity<String> addPatient(@RequestBody Patient NewPatient) {
        // Check if a patient with the given HN already exists
        if(patientrepo.findById(NewPatient.getHN()).isPresent()) {
            return ResponseEntity.status(409).body("This patient is already exists");
        }else {
            // Save the new patient and return 201 Created message
            patientrepo.save(NewPatient);
            return ResponseEntity.status(201).body("Succesfully Created");
        }
    }
    
}