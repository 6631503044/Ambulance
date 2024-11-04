package com.pbt.ambulance_app.model;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Emergency {
    @Id
    @Column (name = "emergency_Case_Id")
    private String emergencyCaseId;
    private String severity;
    @Column (name = "emg_Description")
    private String emgDescription;
    @Column (name = "emg_Coordinate_LongAndLat")
    private Double emgCoordinateLongAndLat;
    @Column (name = "emg_Location")
    private String emgLocation;
    @Column (name = "phone_Number")
    private String phoneNumber;
    private String gender;
    @Column (name = "emg_Day")
    private LocalDate emgDay;
    @Column (name = "emg_Time")
    private LocalTime emgTime;

    @ManyToOne
    @JoinColumn(name = "age Id")
    private Age age;

    @OneToMany(mappedBy = "emergency", cascade = CascadeType.ALL)
    private List<SymptomEmgForEachCase> symptomEmgForEachCase;

    @ManyToOne
    @JoinColumn(name = "patient_Type_Id")
    private PatientType patientType;

    @ManyToOne
    @JoinColumn(name = "patient_Status_Id")
    private PatientStatus patientStatus;

    @ManyToOne
    @JoinColumn(name = "area id")
    private Area area;

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<SymptomEmgForEachCase> getSymptomEmgForEachCase() {
        return symptomEmgForEachCase;
    }

    public void setSymptomEmgForEachCase(List<SymptomEmgForEachCase> symptomEmgForEachCase) {
        this.symptomEmgForEachCase = symptomEmgForEachCase;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getEmergencyCaseId() {
        return emergencyCaseId;
    }

    public void setEmergencyCaseId(String emergencyCaseId) {
        this.emergencyCaseId = emergencyCaseId;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getEmgDescription() {
        return emgDescription;
    }

    public void setEmgDescription(String emgDescription) {
        this.emgDescription = emgDescription;
    }

    public Double getEmgCoordinateLongAndLat() {
        return emgCoordinateLongAndLat;
    }

    public void setEmgCoordinateLongAndLat(Double emgCoordinateLongAndLat) {
        this.emgCoordinateLongAndLat = emgCoordinateLongAndLat;
    }

    public String getEmgLocation() {
        return emgLocation;
    }

    public void setEmgLocation(String emgLocation) {
        this.emgLocation = emgLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getEmgDay() {
        return emgDay;
    }

    public void setEmgDay(LocalDate emgDay) {
        this.emgDay = emgDay;
    }

    public LocalTime getEmgTime() {
        return emgTime;
    }

    public void setEmgTime(LocalTime emgTime) {
        this.emgTime = emgTime;
    }
}
