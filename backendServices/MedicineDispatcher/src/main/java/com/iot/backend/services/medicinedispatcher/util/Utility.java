package com.iot.backend.services.medicinedispatcher.util;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.model.MedicineScheduledTime;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public Medicine medicineRecordToMedicineEntity(MedicineRecord record) {
        return new Medicine(record.getDrugName(), record.getDrugDescription(), record.getDrugType(), record.getDrugDosage(),
                new MedicineScheduledTime(record.getScheduledTimes(), record.getScheduledDays()), record.getStatus());
    }

    public MedicineRecord medicineEntityToMedicineRecord(Medicine med) {
        return new MedicineRecord(med.getId(), med.getDrugName(), med.getDrugDescription(), med.getDrugType(), med.getDrugDosage(),
                med.getDrugSchedule().getScheduledDays(), med.getDrugSchedule().getScheduledTime(), med.getStatus());
    }
}
