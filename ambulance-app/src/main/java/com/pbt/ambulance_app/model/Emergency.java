package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Emergency {
    @Id
    private String emergency_Case_Id;
    private Integer patient_Type_Id;
    private Integer patient_Status_Id;
    private String severity;
    private String emg_Description;
    private Double emg_Coordinate_LongAndLat;
    private String emg_Location;
    private Integer area_Id;
    private String phone_Number;
    private String gender;
    private Integer age_Id;
    private LocalDate emg_Day;
    private LocalTime emg_Time;


    @OneToMany
    @Column(name = "Symptom_Emg_For_Each_Case")
    private SymptomEmgForEachCase symptomEmgForEachCase;

    @ManyToOne
    @Column(name = "Patient_Type")
    private PatientType patientType;

    @ManyToOne
    @Column(name = "Patient_Status")
    private PatientStatus patientStatus;

    @ManyToOne
    @Column(name = "Area")
    private Area area;

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

    public Double getEmg_Coordinate_LongAndLat() {
        return emg_Coordinate_LongAndLat;
    }

    public void setEmg_Coordinate_LongAndLat(Double emg_Coordinate_LongAndLat) {
        this.emg_Coordinate_LongAndLat = emg_Coordinate_LongAndLat;
    }

    public String getEmg_Location() {
        return emg_Location;
    }

    public void setEmg_Location(String emg_Location) {
        this.emg_Location = emg_Location;
    }

    public Integer getArea_Id() {
        return area_Id;
    }

    public void setArea_Id(Integer area_Id) {
        this.area_Id = area_Id;
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

    public Integer getAge_Id() {
        return age_Id;
    }

    public void setAge_Id(Integer age_Id) {
        this.age_Id = age_Id;
    }

    public LocalDate getEmg_Day() {
        return emg_Day;
    }

    public void setEmg_Day(LocalDate emg_Day) {
        this.emg_Day = emg_Day;
    }

    public LocalTime getEmg_Time() {
        return emg_Time;
    }

    public void setEmg_Time(LocalTime emg_Time) {
        this.emg_Time = emg_Time;
    }

    public SymptomEmgForEachCase getSymptomEmgForEachCase() {
        return symptomEmgForEachCase;
    }

    public void setSymptomEmgForEachCase(SymptomEmgForEachCase symptomEmgForEachCase) {
        this.symptomEmgForEachCase = symptomEmgForEachCase;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
}
