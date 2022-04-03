package com.iot.backend.services.medicinedispatcher.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.iot.backend.services.medicinedispatcher.util.DayOfTheWeek;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Embeddable
public class MedicineScheduledTime {

    @ElementCollection
    @JsonFormat(pattern = "HH:mm:ss")
    private List<LocalTime> scheduledTime;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @NotNull
    private List<DayOfTheWeek> scheduledDays;

    public MedicineScheduledTime(List<LocalTime> scheduledTime, List<DayOfTheWeek> scheduledDays) {
        this.scheduledTime = scheduledTime;
        this.scheduledDays = scheduledDays;
    }

    public MedicineScheduledTime() {

    }

    public List<LocalTime> getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(List<LocalTime> scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public List<DayOfTheWeek> getScheduledDays() {
        return scheduledDays;
    }

    public void setScheduledDays(List<DayOfTheWeek> scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineScheduledTime that = (MedicineScheduledTime) o;
        return Objects.equals(getScheduledTime(), that.getScheduledTime()) && Objects.equals(getScheduledDays(), that.getScheduledDays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScheduledTime(), getScheduledDays());
    }

    @Override
    public String toString() {
        return "MedicineScheduledTime{" +
                "scheduledTime=" + scheduledTime +
                ", scheduledDays=" + scheduledDays +
                '}';
    }
}
