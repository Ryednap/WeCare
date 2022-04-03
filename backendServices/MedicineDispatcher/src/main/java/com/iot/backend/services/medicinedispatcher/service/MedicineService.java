package com.iot.backend.services.medicinedispatcher.service;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import org.springframework.stereotype.Service;


@Service
public class MedicineService {
    public void saveMedicineRecord(MedicineRecord record) {
        Medicine medicine = new Medicine(record.drugName(), record.drugDescription(), record.drugType(), record.drugDosage(),
                                        record.frequency(), record.scheduledTimes(), record.quantityRemaining());
    }
}
