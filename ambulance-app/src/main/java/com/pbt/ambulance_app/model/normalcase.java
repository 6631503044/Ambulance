package com.pbt.ambulance_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;
import java.time.LocalDate;

@Entity
public class normalcase {
    @Id
    @Column (name = "case_Id")
    private String caseId;
    @Column (name = "pickup_Time")
    private LocalTime pickupTime;
    @Column (name = "pickup_Date")
    private LocalDate pickupDate;
    private String description;
    @Column(name = "coordinate_long_and_lat", columnDefinition = "float")
    private double coordinateLongAndLat;
    private String location;
    @Column (name = "ambulance_Status")
    private String ambulanceStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "HN")
    private com.pbt.ambulance_app.model.patient patient;

    @ManyToOne
    @JoinColumn(name = "patient_Type_Id")
    private patienttype patientType;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoordinateLongAndLat() {
        return coordinateLongAndLat;
    }

    public void setCoordinateLongAndLat(Double coordinateLongAndLat) {
        this.coordinateLongAndLat = coordinateLongAndLat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmbulanceStatus() {
        return ambulanceStatus;
    }

    public void setAmbulanceStatus(String ambulanceStatus) {
        this.ambulanceStatus = ambulanceStatus;
    }

    public com.pbt.ambulance_app.model.patient getPatient() {
        return patient;
    }

    public void setPatient(com.pbt.ambulance_app.model.patient patient) {
        this.patient = patient;
    }

    public patienttype getPatientType() {
        return patientType;
    }

    public void setPatientType(patienttype patientType) {
        this.patientType = patientType;
    }
}
