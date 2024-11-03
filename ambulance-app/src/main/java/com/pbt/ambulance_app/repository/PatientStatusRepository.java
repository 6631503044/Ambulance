package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.PatientStatus;


@Repository
public interface PatientStatusRepository  extends CrudRepository<PatientStatus, Integer>{
    PatientStatus findByPatient_Status_Id(int patientStatusId);
}