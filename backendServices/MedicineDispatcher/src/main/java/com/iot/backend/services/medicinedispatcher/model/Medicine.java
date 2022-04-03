package com.iot.backend.services.medicinedispatcher.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drugName")
    private String drugName;

    @Column(name = "drugDescription", columnDefinition = "TEXT")
    private String drugDescription;

    @Column(name = "drugType")
    private String drugType;

    @Column(name = "drugDosage")
    private Double drugDosage;

    @Column(name = "quantityRemaining")
    private Integer quantityRemaining;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "scheduledTime", column = @Column(name = "drugScheduledTime", columnDefinition = "TIME(0)")),
            @AttributeOverride(name = "scheduledDays", column = @Column(name = "drugScheduledDays"))
    })
    private MedicineScheduledTime drugSchedule;

    public Medicine(String drugName, String drugDescription, String drugType, Double drugDosage, Integer quantityRemaining, MedicineScheduledTime drugSchedule) {
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.quantityRemaining = quantityRemaining;
        this.drugSchedule = drugSchedule;
    }

    public Medicine() {}
}
