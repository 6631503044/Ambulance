package com.pbt.ambulance_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbt.ambulance_app.dto.EmergencyDTO;
import com.pbt.ambulance_app.model.Emergency;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;
import com.pbt.ambulance_app.repository.SymptomListRepository;
import com.pbt.ambulance_app.model.PatientStatus;

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
    public void addSympandEmerid (Emergency newEmergency){

        //call generateNextid
        String Emr_id = generateNextId();
        newEmergency.setEmergencyCaseId(Emr_id);
  
        for(SymptomEmgForEachCase i : newEmergency.getSymptomEmgForEachCase()){
            SymptomEmgForEachCase Sort = new SymptomEmgForEachCase();
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
