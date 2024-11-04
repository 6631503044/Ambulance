package com.pbt.ambulance_app.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;

@Entity
public class PatientStatus {
    @Id
    @Column(name = "patient_Status_Id")
    private Integer patientStatusId;
    @Column (name = "patient_Status")
    private String patientStatus;

    public Integer getPatientStatusId() {
        return patientStatusId;
    }

    public void setPatientStatusId(Integer patientStatusId) {
        this.patientStatusId = patientStatusId;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }
}
