package com.pbt.ambulance_app.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalTime;

@Entity
public class SymptomList {
    @Id
    private Integer symptom_Id;
    private String symptom_List;
    
    @OneToMany
    private SymptomEmgForEachCase symptomEmgForEachCase;

    public Integer getSymptom_Id() {
        return symptom_Id;
    }
    public void setSymptom_Id(Integer symptom_Id) {
        this.symptom_Id = symptom_Id;
    }
    public String getSymptom_List() {
        return symptom_List;
    }
    public void setSymptom_List(String symptom_List) {
        this.symptom_List = symptom_List;
    }
}
