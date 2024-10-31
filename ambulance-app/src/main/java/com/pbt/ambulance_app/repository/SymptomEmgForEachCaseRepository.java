package com.pbt.ambulance_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;


@Repository
public interface SymptomEmgForEachCaseRepository  extends CrudRepository<SymptomEmgForEachCase, Integer>{
   List<SymptomEmgForEachCase> findBySymptom_Id(int symptom_Id);
   List<SymptomEmgForEachCase> findByEmergency_Case_Id(String emergency_Case_Id);
}