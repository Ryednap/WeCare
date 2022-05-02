package com.iot.backend.services.medicinedispatcher.repository;


import com.iot.backend.services.medicinedispatcher.model.Medicine;
import com.iot.backend.services.medicinedispatcher.model.MedicineScheduledTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    @Query(value= """
          SELECT DISTINCT * FROM medicine
          WHERE id IN (
            SELECT medicine_id FROM medicine_scheduled_days
            WHERE drug_scheduled_days LIKE ?1 AND status = ?2
          )
        """, nativeQuery = true)
    List<Medicine> findAllByDrugSchedule_ScheduledDays(String drugSchedule_scheduledDays, Integer status);

}
