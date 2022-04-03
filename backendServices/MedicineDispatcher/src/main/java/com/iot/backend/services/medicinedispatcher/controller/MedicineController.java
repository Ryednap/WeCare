package com.iot.backend.services.medicinedispatcher.controller;

import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.service.MedicineService;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping
    public void registerMedicine(@RequestBody MedicineRecord medicine) {
        medicineService.saveMedicineRecord(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicine() {
        return medicineService.getAllMedicine();
    }

    @GetMapping("{id}")
    public Medicine getSpecificMedicine(@PathVariable String medicineId) {
        return medicineService.getSpecificMedicine(medicineId);
    }
}
