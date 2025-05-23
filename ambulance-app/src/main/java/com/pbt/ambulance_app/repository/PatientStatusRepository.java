package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.patientstatus;


@Repository
public interface PatientStatusRepository  extends CrudRepository<patientstatus, Integer>{
    patientstatus findByPatientStatusId(int patientStatusId);
}