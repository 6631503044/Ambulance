package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Age {
    @Id
    private Integer age_Id;
    private String age_Range;

    public Integer getAge_Id() {
        return age_Id;
    }
    public void setAge_Id(int age_Id) {
        this.age_Id = age_Id;
    }
    public String getAge_Range() {
        return age_Range;
    }
    public void setAge_Range(String age_Range) {
        this.age_Range = age_Range;
    }
}
