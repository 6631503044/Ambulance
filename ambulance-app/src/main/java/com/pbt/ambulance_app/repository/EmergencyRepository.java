package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.Emergency;


@Repository
public interface EmergencyRepository  extends CrudRepository<Emergency, String>{

    Emergency findByEmergency_Case_Id(String emergency_Case_Id);
}