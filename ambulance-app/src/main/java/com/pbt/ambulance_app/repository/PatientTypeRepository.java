package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.PatientType;


@Repository
public interface PatientTypeRepository  extends CrudRepository<PatientType, String>{
    PatientType findByPatient_Type_Id(int patient_Type_Id);
}