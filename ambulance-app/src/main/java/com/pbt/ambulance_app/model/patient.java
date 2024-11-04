package com.pbt.ambulance_app.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class patient {
    @Id
    private Integer HN;
    @Column (name = "phone_Number")
    private String phoneNumber;
    private String gender;
    private String location;
    private String description;
    

    @OneToMany(mappedBy = "patient") //JUST IN CASE need to pull data from normal case from patient
    private List<normalcase> normalCase;

    @ManyToOne
    @JoinColumn(name = "patient_Status_Id")
    private patientstatus patientStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "patient_Type_Id")
    private patienttype patientType;

    @ManyToOne
    @JoinColumn(name = "age_Id")
    private age age;

    @ManyToOne
    @JoinColumn(name = "area_Id")
    private area area;

    public Integer getHN() {
        return HN;
    }

    public void setHN(Integer hN) {
        HN = hN;
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

    public patientstatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(patientstatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public patienttype getPatientType() {
        return patientType;
    }

    public void setPatientType(patienttype patientType) {
        this.patientType = patientType;
    }

    public age getAge() {
        return age;
    }

    public void setAge(age age) {
        this.age = age;
    }

    public area getArea() {
        return area;
    }

    public void setArea(area area) {
        this.area = area;
    }

    public List<normalcase> getNormalCase() {
        return normalCase;
    }

    public void setNormalCase(List<normalcase> normalCase) {
        this.normalCase = normalCase;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}