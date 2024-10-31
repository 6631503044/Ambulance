package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
public class SymptomEmgForEachCase {
    @Id
    private Integer symptom_Id;
    private String emergency_Case_Id;
    
    public Integer getSymptom_Id() {
        return symptom_Id;
    }
    public void setSymptom_Id(Integer symptom_Id) {
        this.symptom_Id = symptom_Id;
    }
    public String getEmergency_Case_Id() {
        return emergency_Case_Id;
    }
    public void setEmergency_Case_Id(String emergency_Case_Id) {
        this.emergency_Case_Id = emergency_Case_Id;
    }
  
}
