package com.pbt.ambulance_app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findAll();
}