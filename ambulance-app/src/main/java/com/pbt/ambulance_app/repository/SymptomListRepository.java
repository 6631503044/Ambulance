package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.symptomlist;


@Repository
public interface SymptomListRepository  extends CrudRepository<symptomlist, Integer>{
   symptomlist findBySymptomId(int symptomId);
}