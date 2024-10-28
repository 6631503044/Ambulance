package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientType {
    @Id
    private Integer patient_Type_Id;
    private String patient_Type;

    public Integer getPatient_Type_Id() {
        return patient_Type_Id;
    }
    public void setPatient_Type_Id(Integer patient_Type_Id) {
        this.patient_Type_Id = patient_Type_Id;
    }
    public String getPatient_Type() {
        return patient_Type;
    }
    public void setPatient_Type(String patient_Type) {
        this.patient_Type = patient_Type;
    }
}
