package com.pbt.ambulance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbt.ambulance_app.model.emergency;
import com.pbt.ambulance_app.model.symptomemgforeachcase;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;
import com.pbt.ambulance_app.repository.SymptomListRepository;

@Service
public class EmergencyService {

    @Autowired
    EmergencyRepository emerrepo;

     @Autowired
    SymptomListRepository symptomListRepository;

    @Autowired
    SymptomEmgForEachCaseRepository sympforeachrepo;
//defind new name
//logic to add the new row for table  SymptomEmgForEachCase and maybe Emergency table
    public void addSympandEmerid (emergency newEmergency){

        //call generateNextid
        String Emr_id = generateNextId();
        newEmergency.setEmergencyCaseId(Emr_id);
  
        for(symptomemgforeachcase i : newEmergency.getSymptomEmgForEachCase()){
            symptomemgforeachcase Sort = new symptomemgforeachcase();
            Sort.setEmergency(newEmergency);
            Sort.setSymptomList(symptomListRepository.findBySymptomId( i.getSymptomList().getSymptomId()));
            sympforeachrepo.save(Sort);

        }

        emerrepo.save(newEmergency);




    }

    //for Auto generate emer_Id
    public String generateNextId(){
        String prefix ="E";
        int nextId = (int) (emerrepo.count() + 1);
        return prefix + String.format("%03d", nextId);


    }

}
