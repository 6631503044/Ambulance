package com.pbt.ambulance_app.dto;

import java.util.List;

public class EmergencyDTO {
    
    private String emergency_Case_Id;
    private Integer patient_Type_Id;
    private Integer patient_Status_Id;
    private String severity;
    private String emg_Description;
    private double emg_Coordinate_Lat;
    private double emg_Coordinate_Long;
    private String emg_Location;
    private String emg_Duration;
    private List<Integer> symptom_Id;
    public String getEmergency_Case_Id() {
        return emergency_Case_Id;
    }
    public void setEmergency_Case_Id(String emergency_Case_Id) {
        this.emergency_Case_Id = emergency_Case_Id;
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
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getEmg_Description() {
        return emg_Description;
    }
    public void setEmg_Description(String emg_Description) {
        this.emg_Description = emg_Description;
    }
    public double getEmg_Coordinate_Lat() {
        return emg_Coordinate_Lat;
    }
    public void setEmg_Coordinate_Lat(double emg_Coordinate_Lat) {
        this.emg_Coordinate_Lat = emg_Coordinate_Lat;
    }
    public double getEmg_Coordinate_Long() {
        return emg_Coordinate_Long;
    }
    public void setEmg_Coordinate_Long(double emg_Coordinate_Long) {
        this.emg_Coordinate_Long = emg_Coordinate_Long;
    }
    public String getEmg_Location() {
        return emg_Location;
    }
    public void setEmg_Location(String emg_Location) {
        this.emg_Location = emg_Location;
    }
    public String getEmg_Duration() {
        return emg_Duration;
    }
    public void setEmg_Duration(String emg_Duration) {
        this.emg_Duration = emg_Duration;
    }
    public List<Integer> getSymptom_Id() {
        return symptom_Id;
    }
    public void setSymptom_Id(List<Integer> symptom_Id) {
        this.symptom_Id = symptom_Id;
    }
    
    


}
