package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.patient;


@Repository
public interface PatientRepository  extends CrudRepository<patient, Integer>{
   patient findByHN(int HN);
   List<patient> findByGender(String gender);
   List<patient> findByPatientStatusPatientStatusId(int patientStatusId);
   List<patient> findByAgeAgeId(int ageId);

   
}