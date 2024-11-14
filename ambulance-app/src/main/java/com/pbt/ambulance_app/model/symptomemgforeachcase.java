package com.pbt.ambulance_app.model;

import jakarta.persistence.*;

@Entity
public class symptomemgforeachcase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "emergency_Case_Id")
    private com.pbt.ambulance_app.model.emergency emergency;


    @ManyToOne
    @JoinColumn(name = "symptom_Id")
    private symptomlist symptomList;


    public com.pbt.ambulance_app.model.emergency getEmergency() {
        return emergency;
    }
    public void setEmergency(com.pbt.ambulance_app.model.emergency emergency) {
        this.emergency = emergency;
    }
    public symptomlist getSymptomList() {
        return symptomList;
    }
    public void setSymptomList(symptomlist symptomList) {
        this.symptomList = symptomList;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
