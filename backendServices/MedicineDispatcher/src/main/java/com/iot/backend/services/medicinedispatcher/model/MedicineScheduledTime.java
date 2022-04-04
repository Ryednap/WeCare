package com.iot.backend.services.medicinedispatcher.model;


import com.iot.backend.services.medicinedispatcher.util.DayOfTheWeek;
import com.sun.istack.NotNull;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Objects;

@Embeddable
public class MedicineScheduledTime {

    @ElementCollection
    private List<String> scheduledTime;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @NotNull
    private List<DayOfTheWeek> scheduledDays;

    public MedicineScheduledTime(List<String> scheduledTime, List<DayOfTheWeek> scheduledDays) {
        this.scheduledTime = scheduledTime;
        this.scheduledDays = scheduledDays;
    }

    public MedicineScheduledTime() {

    }

    public List<String> getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(List<String> scheduledTime) {
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
