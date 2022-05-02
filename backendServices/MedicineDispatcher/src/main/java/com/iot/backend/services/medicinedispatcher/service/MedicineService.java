package com.iot.backend.services.medicinedispatcher.service;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.repository.MedicineRepository;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import com.iot.backend.services.medicinedispatcher.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public record MedicineService(MedicineRepository medicineRepo, Utility util) {

    public Long saveMedicineRecord(MedicineRecord record) {
        Medicine med = util.medicineRecordToMedicineEntity(record);
        medicineRepo.save(med);
        log.info("Medicine Record saved id: " + med.getId());
        return med.getId();
    }

    public List<MedicineRecord> getAllMedicine() {
        return medicineRepo.findAll().stream().map(util::medicineEntityToMedicineRecord).collect(Collectors.toList());
    }

    public MedicineRecord getSpecificMedicine(String id) {
        Optional<Medicine> optionalMedicine = medicineRepo.findById(Long.parseLong(id));
        if (optionalMedicine.isPresent()) return util.medicineEntityToMedicineRecord(optionalMedicine.get());
        return util.medicineEntityToMedicineRecord(new Medicine());
    }

    public void deleteMedicine(String id) {
        log.info("Deleting Medicine Record with id: " + id);
        medicineRepo.deleteById(Long.parseLong(id));
    }

    public List<MedicineRecord> getMedicineByDate(String date, String status) {
        return medicineRepo.findAllByDrugSchedule_ScheduledDays(date, Integer.parseInt(status))
                .stream().map(util::medicineEntityToMedicineRecord)
                .collect(Collectors.toList());
    }

    public String changeMedicineStatus(String id, String status) {
        Optional<Medicine> optionalMedicine = medicineRepo.findById(Long.parseLong(id));
        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            medicine.setStatus(Integer.parseInt(status));
            medicineRepo.save(medicine);
            return "Updated";
        } else return "Medicine not found";
    }
}
