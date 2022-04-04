package com.iot.backend.services.medicinedispatcher.util;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.model.MedicineScheduledTime;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public Medicine medicineRecordToMedicineEntity(MedicineRecord record) {
        Medicine med = new Medicine(record.drugName(), record.drugDescription(), record.drugType(), record.drugDosage(),
                record.quantityRemaining(), new MedicineScheduledTime(record.scheduledTimes(), record.scheduledDays()));
        return med;
    }

    public MedicineRecord medicineEntityToMedicineRecord(Medicine med) {
        MedicineRecord medRecord = new MedicineRecord(med.getDrugName(), med.getDrugDescription(), med.getDrugType(), med.getDrugDosage(),
                med.getDrugSchedule().getScheduledDays(), med.getDrugSchedule().getScheduledTime(), med.getQuantityRemaining());
        return medRecord;
    }
}
