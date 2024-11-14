package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.appointment;

import java.util.List;
import java.time.LocalDate;


@Repository
public interface NormalCaseRepository extends CrudRepository<appointment, String> {
    appointment findByCaseId(String caseId);
    List<appointment> findAll();
    List<appointment> findByPatient_HN(Integer HN);
    List<appointment> findByPickupDate(LocalDate pickupDate);
}

