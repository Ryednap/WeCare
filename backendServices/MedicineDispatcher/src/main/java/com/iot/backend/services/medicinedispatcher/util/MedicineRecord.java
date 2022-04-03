package com.iot.backend.services.medicinedispatcher.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.List;

public record MedicineRecord(String drugName, String drugDescription, String drugType, Double drugDosage,
                             List<DayOfTheWeek> scheduledDays, @JsonFormat(pattern = "HH:mm:ss") List<LocalTime> scheduledTimes,
                             Integer quantityRemaining) {

}
