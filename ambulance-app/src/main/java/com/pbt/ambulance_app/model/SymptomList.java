package com.pbt.ambulance_app.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalTime;

@Entity
public class SymptomList {
    @Id
    @Column (name = "symptom_Id")
    private Integer symptomId;
    @Column (name = "symptom_List")
    private String symptomList;

    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(String symptomList) {
        this.symptomList = symptomList;
    }
}
