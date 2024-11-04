package com.pbt.ambulance_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbt.ambulance_app.model.login;


@Repository
public interface LoginRepository  extends CrudRepository<login, String>{

   login findByUsername(String username);
}