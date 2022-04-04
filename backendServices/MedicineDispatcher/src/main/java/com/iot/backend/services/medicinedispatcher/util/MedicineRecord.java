package com.iot.backend.services.medicinedispatcher.util;

import java.util.List;

public record MedicineRecord(String drugName, String drugDescription, String drugType, Double drugDosage,
                             List<DayOfTheWeek> scheduledDays, List<String> scheduledTimes,
                             Integer quantityRemaining) {

}
