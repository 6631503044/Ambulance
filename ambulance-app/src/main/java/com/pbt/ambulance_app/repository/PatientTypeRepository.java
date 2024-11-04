package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.patienttype;


@Repository
public interface PatientTypeRepository  extends CrudRepository<patienttype, Integer>{
    patienttype findByPatientTypeId(int patientTypeId);
}