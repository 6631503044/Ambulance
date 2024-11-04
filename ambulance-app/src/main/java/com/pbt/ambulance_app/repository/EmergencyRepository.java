package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.emergency;


@Repository
public interface EmergencyRepository  extends CrudRepository<emergency, String>{

    emergency findByEmergencyCaseId(String emergencyCaseId);
}