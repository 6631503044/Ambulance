package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;
import java.time.LocalDate;

@Entity
public class NormalCase {
    @Id
    private String case_Id;
    private LocalTime call_Time;
    private LocalDate call_Date;
    private LocalTime pickup_Time;
    private LocalDate pickup_Date;
    private Integer patient_Type_Id;
    private Integer patient_Status_Id;
    private String description;
    private double coordinate_Lat;
    private double coordinate_Long;
    private String location;
    private String duration;
    private Integer HN;

    
    public String getCase_Id() {
        return case_Id;
    }
    public void setCase_Id(String case_Id) {
        this.case_Id = case_Id;
    }
    public LocalTime getCall_Time() {
        return call_Time;
    }
    public void setCall_Time(LocalTime call_Time) {
        this.call_Time = call_Time;
    }
    public LocalDate getCall_Date() {
        return call_Date;
    }
    public void setCall_Date(LocalDate call_Date) {
        this.call_Date = call_Date;
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
    public Integer getPatient_Type_Id() {
        return patient_Type_Id;
    }
    public void setPatient_Type_Id(Integer patient_Type_Id) {
        this.patient_Type_Id = patient_Type_Id;
    }
    public Integer getPatient_Status_Id() {
        return patient_Status_Id;
    }
    public void setPatient_Status_Id(Integer patient_Status_Id) {
        this.patient_Status_Id = patient_Status_Id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getCoordinate_Lat() {
        return coordinate_Lat;
    }
    public void setCoordinate_Lat(double coordinate_Lat) {
        this.coordinate_Lat = coordinate_Lat;
    }
    public double getCoordinate_Long() {
        return coordinate_Long;
    }
    public void setCoordinate_Long(double coordinate_Long) {
        this.coordinate_Long = coordinate_Long;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Integer getHN() {
        return HN;
    }
    public void setHN(Integer hN) {
        HN = hN;
    }

    
}
