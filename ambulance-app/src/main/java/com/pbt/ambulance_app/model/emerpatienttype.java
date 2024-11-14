package com.pbt.ambulance_app.model;
import jakarta.persistence.*;

@Entity
public class emerpatienttype {
    @Id
    @Column(name = "emerpatient_Type_Id")
    private Integer emerpatientTypeId;
    @Column (name = "emerpatient_Type", length = 50)
    private String emerpatientType;

    public Integer getEmerpatientTypeId() {
        return emerpatientTypeId;
    }

    public void setEmerpatientTypeId(Integer emerpatientTypeId) {
        this.emerpatientTypeId = emerpatientTypeId;
    }

    public String getEmerpatientType() {
        return emerpatientType;
    }

    public void setEmerpatientType(String emerpatientType) {
        this.emerpatientType = emerpatientType;
    }
}
