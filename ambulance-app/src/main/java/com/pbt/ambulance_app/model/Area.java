package com.pbt.ambulance_app.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;

@Entity
public class Area {
    @Id
    @Column(name = "area_Id")
    private Integer areaId;
    @Column (name = "area")
    private String area;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}