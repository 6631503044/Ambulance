package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.Login;


@Repository
public interface LoginRepository  extends CrudRepository<Login, String>{

   Login findByUsername(String username);
}