package com.iot.backend.services.medicinedispatcher.util;

import java.time.LocalTime;
import java.util.List;

public record MedicineRecord(String drugName, String drugDescription, String drugType, Double drugDosage,
                             Integer frequency, List<LocalTime> scheduledTimes, Integer quantityRemaining) {

}
