package com.pbt.ambulance_app.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbt.ambulance_app.repository.SymptomListRepository;
import com.pbt.ambulance_app.model.emergency;
import com.pbt.ambulance_app.repository.AgeRepository;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.repository.PatientStatusRepository;
import com.pbt.ambulance_app.repository.PatientTypeRepository;
import com.pbt.ambulance_app.service.EmergencyService;
import com.pbt.ambulance_app.model.symptomemgforeachcase;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.web.bind.annotation.DeleteMapping;
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
    PatientStatusRepository patientStatusRepository;

    @Autowired
    PatientTypeRepository patienttype;
    @Autowired
    AgeRepository ageRepository;

    @Autowired
    SymptomListRepository symptomListRepository;

    @Autowired
    SymptomEmgForEachCaseRepository symptomEmgForEachCaseRepository;

    @Autowired
    EmergencyService emergencyservice;

    @PersistenceContext
    private EntityManager entitymanager;

    // fix column long lat
    @PostMapping()
    public ResponseEntity<String> AddEmergency(@RequestBody HashMap<String, Object> Emer) {
        // get data from Json by hashmap
        String severity = (String) Emer.get("severity");
        String emgDescription = (String) Emer.get("emgDescription");
        Double emgCoordinateLongAndLat = (Double) Emer.get("emgCoordinateLongAndLat");
        String emgLocation = (String) Emer.get("emgLocation");
        String phoneNumber = (String) Emer.get("phoneNumber");
        String gender = (String) Emer.get("gender");
        LocalDate emgDay = (LocalDate) Emer.get("emgDay");
        LocalTime emgTime = (LocalTime) Emer.get("emgTime");
        Integer age = (Integer) Emer.get("age");
        List<symptomemgforeachcase> symptomEmgForEachCase = (List<symptomemgforeachcase>) Emer
                .get("symptomEmgForEachCase");
        Integer patientType = (Integer) Emer.get("patientype");
        Integer patientStatus = (Integer) Emer.get("patientStatus");
        Integer area = (Integer) Emer.get("area");

        
        // set Emergency
        emergency newcase = new emergency();
        String Emr_id = emergencyservice.generateNextId();
        newcase.setEmergencyCaseId(Emr_id);

        newcase.setAge(ageRepository.findByAgeId(age));
        newcase.setSeverity(severity);
        newcase.setEmgDescription(emgDescription);
        //newcase.setEmgCoordinateLongAndLat(emgCoordinateLongAndLat);
        newcase.setEmgLocation(emgLocation);
        newcase.setPhoneNumber(phoneNumber);
        newcase.setGender(gender);
        newcase.setEmgDay(emgDay);
        newcase.setEmgTime(emgTime);
        newcase.setSymptomEmgForEachCase(symptomEmgForEachCase);
        //newcase.setPatientType(patienttype.findByPatientTypeId(patientType));
        newcase.setPatientStatus(patientStatusRepository.findByPatientStatusId(patientStatus));

        // Add to Symptom type for eachcase table
        emergencyservice.addSympandEmerid(newcase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // if I have time I will come back and find new solution Maybe I will Use hash
    // map
    // I will add the filter later
    @GetMapping("/{page}/{sort}/{gender}/{type}/{severity}")
    public ResponseEntity<List<emergency>> getAllEmergency(
            @PathVariable Integer page,
            @PathVariable Integer sort,
            @PathVariable String gender,
            @PathVariable Integer type,
            @PathVariable String severity) {

        StringBuilder sqlStatement = new StringBuilder("SELECT * FROM Emergency WHERE 1=1");
        if (gender != null) {
            sqlStatement.append(" AND gender = :gender");
        }
        if (severity != null) {
            sqlStatement.append(" AND severity = :severity"); // incase we use severity
        }
        if (type != null) {
            sqlStatement.append(" AND patient_Type_Id =:type");
        }

        switch (sort) {// fliter old to new /new to old Emer and age
            case 1:
                sqlStatement.append(" ORDER BY emergency_Case_Id DESC");// Emer Old to new

                break;
            case 2:
                sqlStatement.append(" ORDER BY emergency_Case_Id ASC");// Emer New to old

                break;
            case 3:
                sqlStatement.append(" ORDER BY age_Id DESC ");// Age Hight to low

                break;
            case 4:
                sqlStatement.append(" ORDER BY age_Id ASC");// Age ow to hight

                break;

            default:
                break;
        }
        List<emergency> Insert = new ArrayList<>();
        Query query = entitymanager.createNativeQuery(sqlStatement.toString());
        // set paramiter
        if (gender != null) {
            query.setParameter("gender", gender);
        }
        if (severity != null) {
            query.setParameter("severity", severity); // incase we use severity
        }
        if (type != null) {
            query.setParameter("type", type);
        }

        int pageSize = 10;
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        Insert = query.getResultList();
        return new ResponseEntity<List<emergency>>(Insert, HttpStatus.OK);

    }

    @PutMapping("")
    public ResponseEntity<String> editEmergency(@RequestBody emergency editEmergency) {
        if (emergencyrepository.existsById(editEmergency.getEmergencyCaseId())) {
            emergencyrepository.save(editEmergency);
            // Add logic Emerforeachcase
            for (symptomemgforeachcase i : editEmergency.getSymptomEmgForEachCase()) {
                symptomEmgForEachCaseRepository.save(i);
            }

            return ResponseEntity.ok("Emergency case updated successfully"); // 200 OK with message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emergency case not found"); // 404 if not found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmergency(@PathVariable String id){
        if(emergencyrepository.existsById(id)){
            emergencyrepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Emergency case not found", HttpStatus.NOT_FOUND);
        }
    }
}
