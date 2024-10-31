package com.pbt.ambulance_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;


import com.pbt.ambulance_app.dto.EmergencyDTO;
import com.pbt.ambulance_app.model.Emergency;
import com.pbt.ambulance_app.repository.EmergencyRepository;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    EmergencyRepository emergencyrepository;

    @Autowired
    SymptomEmgForEachCaseRepository  symptomEmgForEachCaseRepository;

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

    //if i have time I will caome back and find new solution Maybe i will Use hash map
    //I will add the filter later
    @GetMapping("/{page}")
    public List<EmergencyDTO> getAllEmergency(@PathVariable int page) {
        //Use inner join 
        List<EmergencyDTO> DTO = new ArrayList<>();
        List<Emergency> result = new ArrayList<>();
        
        

        //DTO.setSymptom_Id(symptomemgforeachcase.findByEmergency_Id());
        String sql ="SELECT * FROM Emergency ;";
        Query query = entitymanager.createNativeQuery(sql,Emergency.class);
         int pageSize = 10;
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        result =  query.getResultList();
        for (Emergency emergency : result) {
            EmergencyDTO Sort = new EmergencyDTO();

            Sort.setEmergency_Case_Id(emergency.getEmergency_Case_Id());
            Sort.setEmg_Coordinate_Lat(emergency .getEmg_Coordinate_Lat());
            Sort.setEmg_Coordinate_Long(emergency .getEmg_Coordinate_Lat());
            Sort.setEmg_Description(emergency .getEmg_Description());
            Sort.setEmg_Duration(emergency .getEmg_Duration());
            Sort.setEmg_Location(emergency .getEmg_Location());
            Sort.setPatient_Status_Id(emergency .getPatient_Status_Id());
            Sort.setPatient_Type_Id(emergency .getPatient_Type_Id());
            Sort.setSeverity(emergency.getSeverity());
           
           List<SymptomEmgForEachCase> symptoms = symptomEmgForEachCaseRepository.findByEmergency_Case_Id(emergency.getEmergency_Case_Id());
           List<Integer> symptomIds = symptoms.stream().map(SymptomEmgForEachCase::getSymptom_Id).collect(Collectors.toList());//Use steam to manage about list and map to class and get the choose Type that we want to collect
            Sort.setSymptom_Id(symptomIds);
            DTO.add(Sort);

        }
        // Execute the query and return the results
        
        return DTO;
    }




}
