package com.iot.backend.services.medicinedispatcher.repository;


import com.iot.backend.services.medicinedispatcher.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
