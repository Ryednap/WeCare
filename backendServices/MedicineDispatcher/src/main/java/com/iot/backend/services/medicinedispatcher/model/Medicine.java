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
            @AttributeOverride(name = "scheduledTime", column = @Column(name = "drugScheduledTime")),
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

    public void setDrugDescription(String drugDescription) {
        this.drugDescription = drugDescription;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public Double getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(Double drugDosage) {
        this.drugDosage = drugDosage;
    }

    public Integer getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(Integer quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public MedicineScheduledTime getDrugSchedule() {
        return drugSchedule;
    }

    public void setDrugSchedule(MedicineScheduledTime drugSchedule) {
        this.drugSchedule = drugSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(getId(), medicine.getId()) && Objects.equals(getDrugName(), medicine.getDrugName()) && Objects.equals(getDrugDescription(), medicine.getDrugDescription()) && Objects.equals(getDrugType(), medicine.getDrugType()) && Objects.equals(getDrugDosage(), medicine.getDrugDosage()) && Objects.equals(getQuantityRemaining(), medicine.getQuantityRemaining()) && Objects.equals(getDrugSchedule(), medicine.getDrugSchedule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDrugName(), getDrugDescription(), getDrugType(), getDrugDosage(), getQuantityRemaining(), getDrugSchedule());
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", drugDescription='" + drugDescription + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugDosage=" + drugDosage +
                ", quantityRemaining=" + quantityRemaining +
                ", drugSchedule=" + drugSchedule +
                '}';
    }
}
