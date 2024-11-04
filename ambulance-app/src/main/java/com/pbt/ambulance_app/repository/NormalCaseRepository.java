package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.normalcase;

@Repository
public interface NormalCaseRepository  extends CrudRepository<normalcase, String>{
    normalcase findByCaseId(String caseId);
   
}

