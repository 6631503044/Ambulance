package com.pbt.ambulance_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbt.ambulance_app.model.Emergency;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.model.EmergencyDTO;
import com.pbt.ambulance_app.service.EmergencyService;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*Check list
 * 1.get emergency(Not yet)
 * 2.Add emergency(Not yet) **in check box we will sent it in array form
 * format [Date]
 * Symptom array....
 * 
 * 3.fliter??
 * 
 */

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    EmergencyRepository emergencyrepository;

    @Autowired
    SymptomEmgForEachCase  symptomemgforeachcase;

    //have the logic of put data for emergency table and symptomforeachemergency (use it like use anthor class)
    @Autowired
    EmergencyService emergencyservice;

    //get json at format EmergencyDTO  to Put it in Database by use Servicemethod(Just creat method!!)
    
    @PersistenceContext
    private EntityManager entitymanager;

    //get json at format EmergencyDTO  to Put it in Database by use Servicemethod(Just creat method!!)
    @PutMapping()
    public ResponseEntity<String>  AddEmergency(@RequestBody EmergencyDTO Emer){
        emergencyservice.addSympandEmerid(Emer);     
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* 
    @GetMapping("/{page}")
    public ResponseEntity<List<EmergencyDTO>> getAllEmergency(@PathVariable int page) {
        String sql ="Select ";
        Query query = entitymanager.createNativeQuery(sql);
        return ();
    }*/




}
