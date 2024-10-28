package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.SymptomList;


@Repository
public interface SymptomListRepository  extends CrudRepository<SymptomList, String>{
   SymptomList findBySymptom_Id(int symptom_Id);
}