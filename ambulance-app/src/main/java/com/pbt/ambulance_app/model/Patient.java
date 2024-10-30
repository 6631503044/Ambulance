package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
    @Id
    private Integer HN;
    private Integer patient_Status_Id;
    private Integer age_Id;
    private String gender;
    private String phone_Number;
    private Integer patient_Type_Id;
    
    @OneToMany
    private NormalCase normalCase;

    @ManyToOne
    private PatientStatus patientStatus;

    @ManyToOne
    private PatientType patientType;

    @ManyToOne
    private Age age;


    public Integer getHN() {
        return HN;
    }
    public void setHN(Integer hN) {
        HN = hN;
    }
    public Integer getPatient_Status_Id() {
        return patient_Status_Id;
    }
    public void setPatient_Status_Id(Integer patient_Status_Id) {
        this.patient_Status_Id = patient_Status_Id;
    }
    public Integer getAge_Id() {
        return age_Id;
    }
    public void setAge_Id(Integer age_Id) {
        this.age_Id = age_Id;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone_Number() {
        return phone_Number;
    }
    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }
    public Integer getPatient_Type_Id() {
        return patient_Type_Id;
    }
    public void setPatient_Type_Id(Integer patient_Type_Id) {
        this.patient_Type_Id = patient_Type_Id;
    }

    
}