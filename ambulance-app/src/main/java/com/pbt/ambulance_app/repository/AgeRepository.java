package com.pbt.ambulance_app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.Age;


@Repository
public interface AgeRepository  extends CrudRepository<Age, Integer>{

    Age findByAge_Id(int age_Id);
    
}