package com.pbt.ambulance_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
    List<Person> findAll();
}