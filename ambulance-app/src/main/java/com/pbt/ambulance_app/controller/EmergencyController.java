package com.pbt.ambulance_app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;


import com.pbt.ambulance_app.model.SymptomList;
import com.pbt.ambulance_app.repository.SymptomListRepository;
import com.pbt.ambulance_app.model.Emergency;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.service.EmergencyService;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;
import com.pbt.ambulance_app.model.SymptomList;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/*Check list
 * 1.get emergency(Not yet)
 * 2.Add emergency(Not yet) **in check box we will sent it in array form
 * format [Date]
 * Symptom array....
 * 
 * 3.fliter??
 * 
 */
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    EmergencyRepository emergencyrepository;

    @Autowired
    SymptomListRepository symptomListRepository;

    @Autowired
    SymptomEmgForEachCaseRepository  symptomEmgForEachCaseRepository;

    //have the logic of put data for emergency table and symptomforeachemergency (use it like use anthor class)
    @Autowired
    EmergencyService emergencyservice;

    //get json at format EmergencyDTO  to Put it in Database by use Servicemethod(Just creat method!!)
    
    @PersistenceContext
    private EntityManager entitymanager;

    //get json at format EmergencyDTO  to Put it in Database by use Servicemethod(Just creat method!!)
    @PostMapping()
    public ResponseEntity<String>  AddEmergency(@RequestBody Emergency Emer){
        emergencyservice.addSympandEmerid(Emer);     
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //if i have time I will caome back and find new solution Maybe i will Use hash map
    //I will add the filter later
    @GetMapping("/{page}")
    public List<Emergency> getAllEmergency(@PathVariable int page) {

        List<Emergency> Sort = new ArrayList<>();
        //DTO.setSymptom_Id(symptomemgforeachcase.findByEmergency_Id());
        String sql ="SELECT * FROM Emergency ;";
        Query query = entitymanager.createNativeQuery(sql,Emergency.class);
         int pageSize = 10;
        //fliter


        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        Sort =  query.getResultList();
       
        // Execute the query and return the results
        
        return Sort;
    }

    @PutMapping("")
    public ResponseEntity<String> editEmergency (@RequestBody Emergency editEmergency) {
        if (emergencyrepository.existsById(editEmergency.getEmergency_Case_Id())) {
            emergencyrepository.save(editEmergency);
            return ResponseEntity.ok("Emergency case updated successfully"); // 200 OK with message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emergency case not found"); // 404 if not found
        }
    }



}
