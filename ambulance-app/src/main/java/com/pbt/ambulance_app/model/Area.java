package com.pbt.ambulance_app.model;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Area {
    @Id
    private Integer area_Id;
    private String area;

    public Integer getArea_Id() {
        return area_Id;
    }
    public void setArea_Id(Integer area_Id) {
        this.area_Id = area_Id;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}