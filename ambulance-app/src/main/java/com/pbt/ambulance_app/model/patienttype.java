package com.pbt.ambulance_app.model;
import jakarta.persistence.*;

@Entity
public class patienttype {
    @Id
    @Column(name = "patient_Type_Id")
    private Integer patientTypeId;
    @Column (name = "patient_Type")
    private String patientType;

    public Integer getPatientTypeId() {
        return patientTypeId;
    }

    public void setPatientTypeId(Integer patientTypeId) {
        this.patientTypeId = patientTypeId;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }
}
