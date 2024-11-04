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
    SymptomEmgForEachCaseRepository symptomEmgForEachCaseRepository;

    // have the logic of put data for emergency table and symptomforeachemergency
    // (use it like use anthor class)
    @Autowired
    EmergencyService emergencyservice;

    // get json at format EmergencyDTO to Put it in Database by use
    // Servicemethod(Just creat method!!)

    @PersistenceContext
    private EntityManager entitymanager;

    // get json at format EmergencyDTO to Put it in Database by use
    // Servicemethod(Just creat method!!)
    @PostMapping()
    public ResponseEntity<String> AddEmergency(@RequestBody Emergency Emer) {
        emergencyservice.addSympandEmerid(Emer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // if i have time I will caome back and find new solution Maybe i will Use hash
    // map
    // I will add the filter later
    @GetMapping("/{page}/{sort}/{gender}/{type}/{serverity}")
    public List<Emergency> getAllEmergency(
            @PathVariable Integer page,
            @PathVariable Integer sort,
            @PathVariable Integer gender,
            @PathVariable Integer type,
            @PathVariable Integer severity) {

        StringBuilder sqlStatement = new StringBuilder("SELECT e FORM Emergency e WHERE 1=1");
        if (gender != null) {
            sqlStatement.append("AND e.gender = :gender");
        }
        if (severity != null) {
            sqlStatement.append("AND e.severity = :severity");    // incase we use severity
        }
        if (type != null) {
            sqlStatement.append("AND e.patient_Type_Id =:type");
        }

        switch (sort) {// fliter old to new /new to old Emer and age
            case 1:
                sqlStatement.append("ORDER BY e.emergency_Case_Id DESC");//Emer Old to new

                break;
            case 2:sqlStatement.append("ORDER BY e.emergency_Case_Id ASC");//Emer New to old

                break;
            case 3:sqlStatement.append("ORDER BY e.age_Id DESC ");//Age Hight to low

                break;
            case 4:sqlStatement.append("ORDER BY e.age_Id ASC");//Age ow to hight

                break;

            default:
                break;
        }
        List<Emergency> Insert = new ArrayList<>();
        Query query = entitymanager.createNativeQuery(sqlStatement.toString());
      //set paramiter 
   if (gender != null) {
            query.setParameter("gender",gender );
        }
        if (severity != null) {
            query.setParameter("severity",severity ); // incase we use severity
        }
        if (type != null) {
            query.setParameter("type",type );
        }

        int pageSize = 10;
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        Insert = query.getResultList();

        return Insert;
    }

    @PutMapping("")
    public ResponseEntity<String> editEmergency(@RequestBody Emergency editEmergency) {
        if (emergencyrepository.existsById(editEmergency.getEmergency_Case_Id())) {
            emergencyrepository.save(editEmergency);
            // Add logic Emerforeachcase
            for(SymptomEmgForEachCase i : editEmergency.getSymptomEmgForEachCase()){
            symptomEmgForEachCaseRepository.save(i);
            }

            return ResponseEntity.ok("Emergency case updated successfully"); // 200 OK with message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emergency case not found"); // 404 if not found
        }
    }

}
