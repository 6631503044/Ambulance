package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.PatientType;


@Repository
public interface PatientTypeRepository  extends CrudRepository<PatientType, Integer>{
    PatientType findByPatientTypeId(int patientTypeId);
}