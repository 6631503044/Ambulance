package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.Patient;


@Repository
public interface PatientRepository  extends CrudRepository<Patient, Integer>{
   Patient findByHN(int HN);
   List<Patient> findByGender(String gender);
   List<Patient> findByPatient_Status_Id(int patient_Status_Id);
   List<Patient> findByAge_Id(int age_Id);

   
}