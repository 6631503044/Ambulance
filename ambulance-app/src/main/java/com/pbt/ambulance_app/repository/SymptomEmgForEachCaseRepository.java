package com.pbt.ambulance_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;


@Repository
public interface SymptomEmgForEachCaseRepository  extends CrudRepository<SymptomEmgForEachCase, Integer>{
   List<SymptomEmgForEachCase> findBySymptomId(int symptomId);
   List<SymptomEmgForEachCase> findByEmergencyCaseId(String emergencyCaseId);
   SymptomEmgForEachCase findById(int id);
}