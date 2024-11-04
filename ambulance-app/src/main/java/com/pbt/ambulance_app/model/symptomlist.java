package com.pbt.ambulance_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class symptomlist {
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
