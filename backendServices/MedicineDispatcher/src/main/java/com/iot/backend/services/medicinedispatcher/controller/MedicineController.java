package com.iot.backend.services.medicinedispatcher.controller;

import com.iot.backend.services.medicinedispatcher.service.MedicineService;
import com.iot.backend.services.medicinedispatcher.util.MedicineRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/medicine")
@Slf4j
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    /**
     * Register endpoint for medicine records
     * @param medicine
     * @return id: Id of the medicine
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registerMedicine(@RequestBody MedicineRecord medicine) {
        log.info("Received Medicine: " + medicine);
        Long id = medicineService.saveMedicineRecord(medicine);

        Map<String, String> msg = new HashMap<>();
        msg.put("message", "Created User in the database");
        msg.put("id", id.toString());

        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    @RequestMapping(method=RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getAllMedicine() {
        List<MedicineRecord> medicineRecordList = medicineService.getAllMedicine();
        Map<String, List<?>> msg = new HashMap<>();
        msg.put("medicineList", medicineRecordList);

        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSpecificMedicine(@PathVariable String id) {
        MedicineRecord record =  medicineService.getSpecificMedicine(id);
        Map<String, MedicineRecord> msg = new HashMap<>();
        msg.put("record", record);
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMedicineRecord(@PathVariable String id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping(value = "/date/{date}/{status}")
    public ResponseEntity<?> getMedicineByDate(@PathVariable String date, @PathVariable String status) {
        List<MedicineRecord> medicineRecordList = medicineService.getMedicineByDate(date, status);
        Map<String, List<?>> msg = new HashMap<>();
        msg.put("medicineList", medicineRecordList);
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    @PutMapping("/update/{id}/{status}")
    public ResponseEntity<?> updateMedicineStatus(@PathVariable String id, @PathVariable String status) {
        String message = medicineService.changeMedicineStatus(id, status);
        Map<String, String> msg = new HashMap<>();
        msg.put("message", message);
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

}
