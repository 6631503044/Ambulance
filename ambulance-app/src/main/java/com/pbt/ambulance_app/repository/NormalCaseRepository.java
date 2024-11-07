package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pbt.ambulance_app.model.normalcase;

import java.util.List;

@Repository
public interface NormalCaseRepository extends CrudRepository<normalcase, String> {
    normalcase findByCaseId(String caseId);
    List<normalcase> findAll();
}

