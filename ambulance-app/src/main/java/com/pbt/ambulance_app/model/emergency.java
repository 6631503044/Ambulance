package com.pbt.ambulance_app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class emergency {
    @Id
    @Column (name = "emergency_Case_Id", length = 50)
    private String emergencyCaseId;
    @Column (name = "severity", length = 50)
    private String severity;
    @Column (name = "emg_Description", length = 255)
    private String emgDescription;
    @Column (name = "emg_coordinate_long_and_lat", length = 30)
    private String emgCoordinateLongAndLat;
    @Column (name = "emg_Location", length = 100)
    private String emgLocation;
    @Column (name = "phone_Number", length = 15)
    private String phoneNumber;
    @Column (name = "gender", length = 10)
    private String gender;
    @Column (name = "emg_Day")
    private LocalDate emgDay;
    @Column (name = "emg_Time")
    private LocalTime emgTime;
    @Column (name = "area", length = 10)
    private String area;

    @ManyToOne
    @JoinColumn(name = "age_Id")
    private age age;

    @OneToMany(mappedBy = "emergency", cascade = CascadeType.ALL)
    private List<symptomemgforeachcase> symptomEmgForEachCase;

    @ManyToOne
    @JoinColumn(name = "patient_Status_Id")
    private patientstatus patientStatus;

    @ManyToOne
    @JoinColumn(name = "emerpatient_Type_Id")
    private emerpatienttype emerpatientType;

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

    public patientstatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(patientstatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public List<symptomemgforeachcase> getSymptomEmgForEachCase() {
        return symptomEmgForEachCase;
    }

    public void setSymptomEmgForEachCase(List<symptomemgforeachcase> symptomEmgForEachCase) {
        this.symptomEmgForEachCase = symptomEmgForEachCase;
    }

    public String getEmergencyCaseId() {
        return emergencyCaseId;
    }

    public void setEmergencyCaseId(String emergencyCaseId) {
        this.emergencyCaseId = emergencyCaseId;
    }

    public age getAge() {
        return age;
    }

    public void setAge(age age) {
        this.age = age;
    }

    public String getEmgDescription() {
        return emgDescription;
    }

    public void setEmgDescription(String emgDescription) {
        this.emgDescription = emgDescription;
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

    public emerpatienttype getEmerpatientType() {
        return emerpatientType;
    }

    public void setEmerpatientType(emerpatienttype emerpatientType) {
        this.emerpatientType = emerpatientType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmgCoordinateLongAndLat() {
        return emgCoordinateLongAndLat;
    }

    public void setEmgCoordinateLongAndLat(String emgCoordinateLongAndLat) {
        this.emgCoordinateLongAndLat = emgCoordinateLongAndLat;
    }
}
