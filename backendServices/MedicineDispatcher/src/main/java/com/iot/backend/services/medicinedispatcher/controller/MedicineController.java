package com.iot.backend.services.medicinedispatcher.controller;

import com.iot.backend.services.medicinedispatcher.service.MedicineService;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(method=RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MedicineRecord> getAllMedicine() {
        return medicineService.getAllMedicine();
    }

    @GetMapping("{id}")
    public MedicineRecord getSpecificMedicine(@PathVariable String id) {
        return medicineService.getSpecificMedicine(id);
    }
}
