package com.pbt.ambulance_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.symptomemgforeachcase;


@Repository
public interface SymptomEmgForEachCaseRepository  extends CrudRepository<symptomemgforeachcase, Integer>{
   List<symptomemgforeachcase> findBySymptomListSymptomId(int symptomId);
   List<symptomemgforeachcase> findByEmergencyEmergencyCaseId(String emergencyCaseId);
   symptomemgforeachcase findById(int id);
}