package com.pbt.ambulance_app.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
public class Statistic {

    @Id
    private int year;
    private LocalTime morning;
    private LocalTime noon;
    private LocalTime evening;
    private LocalTime night;
    private LocalTime late_Night;
    
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public LocalTime getMorning() {
        return morning;
    }
    public void setMorning(LocalTime morning) {
        this.morning = morning;
    }
    public LocalTime getNoon() {
        return noon;
    }
    public void setNoon(LocalTime noon) {
        this.noon = noon;
    }
    public LocalTime getEvening() {
        return evening;
    }
    public void setEvening(LocalTime evening) {
        this.evening = evening;
    }
    public LocalTime getNight() {
        return night;
    }
    public void setNight(LocalTime night) {
        this.night = night;
    }
    public LocalTime getLate_Night() {
        return late_Night;
    }
    public void setLate_Night(LocalTime late_Night) {
        this.late_Night = late_Night;
    }


    
}
