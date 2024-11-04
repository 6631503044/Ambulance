package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

@Entity
public class SymptomEmgForEachCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "emergency_Case_Id")
    private Emergency emergency;


    @ManyToOne
    @JoinColumn(name = "symptom_Id")
    private SymptomList symptomList;


    public Emergency getEmergency() {
        return emergency;
    }
    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }
    public SymptomList getSymptomList() {
        return symptomList;
    }
    public void setSymptomList(SymptomList symptomList) {
        this.symptomList = symptomList;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
