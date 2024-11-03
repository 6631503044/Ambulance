package com.pbt.ambulance_app.model;
import java.util.List;

import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
    @Id
    private Integer HN;
    private String phone_Number;
    private String gender;
    private String location;
    private String description;
    

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL) //JUST IN CASE need to pull data from normal case from patient
    private List<NormalCase> normalCase;

    @ManyToOne
    @JoinColumn(name = "patient_Status_Id")
    private PatientStatus patientStatus;

    @ManyToOne
    @JoinColumn(name = "patient_Type_Id")
    private PatientType patientType;

    @ManyToOne
    @JoinColumn(name = "age_Id")
    private Age age;

    @ManyToOne
    @JoinColumn(name = "area_Id")
    private Area area;

    public Integer getHN() {
        return HN;
    }

    public void setHN(Integer hN) {
        HN = hN;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<NormalCase> getNormalCase() {
        return normalCase;
    }

    public void setNormalCase(List<NormalCase> normalCase) {
        this.normalCase = normalCase;
    }

    

    
}