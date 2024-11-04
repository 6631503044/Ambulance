package com.pbt.ambulance_app.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.age;


@Repository
public interface AgeRepository  extends CrudRepository<age, Integer>{

    age findByAgeId(int ageId);
    
}