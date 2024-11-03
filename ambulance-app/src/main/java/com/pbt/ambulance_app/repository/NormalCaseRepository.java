package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.NormalCase;

@Repository
public interface NormalCaseRepository  extends CrudRepository<NormalCase, String>{
    NormalCase findByCase_Id (String caseId);
   
}

