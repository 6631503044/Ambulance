package com.pbt.ambulance_app.model;
import jakarta.persistence.*;

@Entity
@Table(name = "age")
public class age {
    @Id
    @Column(name = "age_Id")
    private Integer ageId;
    @Column (name = "age_Range")
    private String ageRange;

    public Integer getAgeId() {
        return ageId;
    }

    public void setAgeId(Integer ageId) {
        this.ageId = ageId;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
