package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientStatus {
    @Id
    private Integer patient_Status_Id;
    private String patient_Status;

    public Integer getPatient_Status_Id() {
        return patient_Status_Id;
    }
    public void setPatient_Status_Id(Integer patient_Status_Id) {
        this.patient_Status_Id = patient_Status_Id;
    }
    public String getPatient_Status() {
        return patient_Status;
    }
    public void setPatient_Status(String patient_Status) {
        this.patient_Status = patient_Status;
    }
}
