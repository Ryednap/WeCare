package com.iot.backend.services.medicinedispatcher.service;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.model.MedicineScheduledTime;
import com.iot.backend.services.medicinedispatcher.repository.MedicineRepository;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import com.iot.backend.services.medicinedispatcher.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public record MedicineService(MedicineRepository medicineRepo, Utility util) {


    @Autowired
    public MedicineService {
    }

    public void saveMedicineRecord(MedicineRecord record) {
        Medicine med = new Medicine(record.drugName(), record.drugDescription(), record.drugType(), record.drugDosage(),
                record.quantityRemaining(), new MedicineScheduledTime(record.scheduledTimes(), record.scheduledDays()));
        medicineRepo.save(med);
    }

    public List<MedicineRecord> getAllMedicine() {
        return medicineRepo.findAll().stream().map(util::medicineEntityToMedicineRecord).collect(Collectors.toList());
    }

    public MedicineRecord getSpecificMedicine(String id) {
        Optional<Medicine> optionalMedicine = medicineRepo.findById(Long.parseLong(id));
        if (optionalMedicine.isPresent()) return util.medicineEntityToMedicineRecord(optionalMedicine.get());
        return util.medicineEntityToMedicineRecord(new Medicine());
    }
}
