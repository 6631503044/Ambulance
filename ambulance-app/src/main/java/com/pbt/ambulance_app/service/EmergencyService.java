package com.pbt.ambulance_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbt.ambulance_app.model.EmergencyDTO;
import com.pbt.ambulance_app.model.Emergency;
import com.pbt.ambulance_app.model.SymptomEmgForEachCase;
import com.pbt.ambulance_app.repository.EmergencyRepository;
import com.pbt.ambulance_app.repository.SymptomEmgForEachCaseRepository;

@Service
public class EmergencyService {

    @Autowired
    EmergencyRepository emerrepo;

    @Autowired
    SymptomEmgForEachCaseRepository sympforeachrepo;
//defind new name
//logic to add the new row for table  SymptomEmgForEachCase and maybe Emergency table
    public void addSympandEmerid (EmergencyDTO emerdto){

        //call generateNextid
        String Emr_id = generateNextId();

        //add the new data for SymptomEmgForEachCase
        for(Integer i: emerdto.getSymptom_id()){
            SymptomEmgForEachCase symptom = new SymptomEmgForEachCase();
            symptom.setSymptom_Id(i);
            symptom.setEmergency_Id(Emr_id);
            sympforeachrepo.save(symptom);
        }
        addEmergency(emerdto,Emr_id);

    }

    //for Auto generate emer_Id
    public String generateNextId(){
        String prefix ="E";
        int nextId = (int) (emerrepo.count() + 1);
        return prefix + String.format("%03d", nextId);


    }

    //Add data to Emergency
    public void addEmergency(EmergencyDTO emerdto,String Emr_id){
        Emergency Emernewcase = new Emergency(); 
        Emernewcase.setEmergency_Case_Id(Emr_id);
        Emernewcase.setEmg_Coordinate_Lat(emerdto.getEmg_Coordinate_Lat());
        Emernewcase.setEmg_Coordinate_Long(emerdto.getEmg_Coordinate_Lat());
        Emernewcase.setEmg_Description(emerdto.getEmg_Description());
        Emernewcase.setEmg_Duration(emerdto.getEmg_Duration());
        Emernewcase.setEmg_Location(emerdto.getEmg_Location());
        Emernewcase.setPatient_Status_Id(emerdto.getPatient_Status_Id());
        Emernewcase.setPatient_Type_Id(emerdto.getPatient_Type_Id());
        Emernewcase.setSeverity(emerdto.getSeverity());

        emerrepo.save(Emernewcase);

    }
}
