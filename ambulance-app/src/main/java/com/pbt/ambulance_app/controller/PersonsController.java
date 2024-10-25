package com.pbt.ambulance_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pbt.ambulance_app.model.Person;
import com.pbt.ambulance_app.repository.PersonRepository;

@Controller
public class PersonsController {


    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/allpersons")
    public String getPersons(Model model) {
        // Fetch all persons from the repository
        List<Person> personsList = personRepository.findAll();
        model.addAttribute("persons", personsList);
        return "person"; 
    }
}
