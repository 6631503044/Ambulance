package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;
import java.time.LocalDate;

@Entity
public class NormalCase {
    @Id
    private String case_Id;
    private LocalTime pickup_Time;
    private LocalDate pickup_Date;
    private String description;
    private Double coordinate_LongAndLat;
    private String location;
    private String ambulance_Status;

    @ManyToOne
    @JoinColumn(name = "HN")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "patient_Type_Id")
    private PatientType patientType;

    

    public String getCase_Id() {
        return case_Id;
    }

    public void setCase_Id(String case_Id) {
        this.case_Id = case_Id;
    }

    public LocalTime getPickup_Time() {
        return pickup_Time;
    }

    public void setPickup_Time(LocalTime pickup_Time) {
        this.pickup_Time = pickup_Time;
    }

    public LocalDate getPickup_Date() {
        return pickup_Date;
    }

    public void setPickup_Date(LocalDate pickup_Date) {
        this.pickup_Date = pickup_Date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoordinate_LongAndLat() {
        return coordinate_LongAndLat;
    }

    public void setCoordinate_LongAndLat(Double coordinate_LongAndLat) {
        this.coordinate_LongAndLat = coordinate_LongAndLat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getAmbulance_Status() {
        return ambulance_Status;
    }

    public void setAmbulance_Status(String ambulance_Status) {
        this.ambulance_Status = ambulance_Status;
    }
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    
}
