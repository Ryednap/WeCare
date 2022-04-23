package com.iot.backend.services.medicinedispatcher.model;


import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "scheduledTime", column = @Column(name = "drugScheduledTime")),
            @AttributeOverride(name = "scheduledDays", column = @Column(name = "drugScheduledDays"))
    })
    private MedicineScheduledTime drugSchedule;

    public Medicine(String drugName, String drugDescription, String drugType, Double drugDosage, MedicineScheduledTime drugSchedule) {
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.drugSchedule = drugSchedule;
    }
}
