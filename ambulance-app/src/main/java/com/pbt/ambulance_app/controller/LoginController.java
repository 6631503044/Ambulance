package com.pbt.ambulance_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbt.ambulance_app.model.Login;
import com.pbt.ambulance_app.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepository loginrepo;

    @PostMapping
    public String LoginCheck(@RequestBody Login login) {

        if(login.getUsername() != null && loginrepo.findByUsername(login.getUsername()) != null && login.getPassword().equals(loginrepo.findByUsername(login.getUsername()).getPassword())) {
            return "Password correct";
        } else {
            return "Password or Username incorrect";
        }
    }
}
