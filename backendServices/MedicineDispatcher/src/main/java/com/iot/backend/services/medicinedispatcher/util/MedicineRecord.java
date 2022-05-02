package com.iot.backend.services.medicinedispatcher.util;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class MedicineRecord {
    Long id;
    String drugName;
    String drugDescription;
    String drugType;
    Double drugDosage;
    List<String> scheduledDays;
    List<String> scheduledTimes;
    Integer status;

    public MedicineRecord(String drugName, String drugDescription, String drugType, Double drugDosage, List<String> scheduledDays, List<String> scheduledTimes, Integer status) {
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.scheduledDays = scheduledDays;
        this.scheduledTimes = scheduledTimes;
        this.status = status;
    }
}
