package com.pbt.ambulance_app.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class patient {
    @Id
    @Column (name = "HN")
    private Integer HN;
    @Column (name = "phone_Number", length = 15)
    private String phoneNumber;
    @Column (name = "gender", length = 10)
    private String gender;
    @Column (name = "location", length = 100)
    private String location;
    @Column (name = "description", length = 255)
    private String description;
    @Column (name = "area", length = 10)
    private String area;

    @OneToMany(mappedBy = "patient") //JUST IN CASE need to pull data from normal case from patient
    private List<appointment> normalCase;

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

    public List<appointment> getNormalCase() {
        return normalCase;
    }

    public void setNormalCase(List<appointment> normalCase) {
        this.normalCase = normalCase;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}