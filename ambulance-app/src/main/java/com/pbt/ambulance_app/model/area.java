package com.pbt.ambulance_app.model;
import jakarta.persistence.*;

@Entity
public class area {
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