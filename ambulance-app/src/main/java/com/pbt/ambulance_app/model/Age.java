package com.pbt.ambulance_app.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;

@Entity
public class Age {
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
