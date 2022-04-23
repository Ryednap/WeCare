package com.iot.backend.services.medicinedispatcher.util;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MedicineRecord {
    Long id;
    String drugName;
    String drugDescription;
    String drugType;
    Double drugDosage;
    List<String> scheduledDays;
    List<String> scheduledTimes;

    public MedicineRecord(String drugName, String drugDescription, String drugType, Double drugDosage, List<String> scheduledDays, List<String> scheduledTimes) {
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.scheduledDays = scheduledDays;
        this.scheduledTimes = scheduledTimes;
    }

    public MedicineRecord(Long id, String drugName, String drugDescription, String drugType, Double drugDosage, List<String> scheduledDays, List<String> scheduledTimes) {
        this.id = id;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.scheduledDays = scheduledDays;
        this.scheduledTimes = scheduledTimes;
    }
}
