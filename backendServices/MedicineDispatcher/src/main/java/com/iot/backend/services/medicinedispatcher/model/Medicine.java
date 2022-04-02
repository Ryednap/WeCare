package com.iot.backend.services.medicinedispatcher.model;


import java.time.LocalTime;
import java.util.List;
import java.util.Objects;


public class Medicine {
    private Long id;
    private String drugName;
    private String drugDescription;
    private String drugType;
    private Double drugDosage;
    private Integer frequency;
    private List<LocalTime> scheduledTimes;
    private Integer quantityRemaining;

    public Medicine(String drugName, String drugDescription, String drugType, Double drugDosage, Integer frequency,
                    List<LocalTime> scheduledTimes, Integer quantityRemaining) {
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugType = drugType;
        this.drugDosage = drugDosage;
        this.frequency = frequency;
        this.scheduledTimes = scheduledTimes;
        this.quantityRemaining = quantityRemaining;
    }

    public Long getId() {
        return id;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public List<LocalTime> getScheduledTimes() {
        return scheduledTimes;
    }

    public void setScheduledTimes(List<LocalTime> scheduledTimes) {
        this.scheduledTimes = scheduledTimes;
    }

    public Integer getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(Integer quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(getId(), medicine.getId()) && Objects.equals(getDrugName(), medicine.getDrugName()) && Objects.equals(getDrugDescription(), medicine.getDrugDescription()) && Objects.equals(getDrugType(), medicine.getDrugType()) && Objects.equals(getDrugDosage(), medicine.getDrugDosage()) && Objects.equals(getFrequency(), medicine.getFrequency()) && Objects.equals(getScheduledTimes(), medicine.getScheduledTimes()) && Objects.equals(getQuantityRemaining(), medicine.getQuantityRemaining());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDrugName(), getDrugDescription(), getDrugType(), getDrugDosage(), getFrequency(), getScheduledTimes(), getQuantityRemaining());
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", drugDescription='" + drugDescription + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugDosage=" + drugDosage +
                ", frequency=" + frequency +
                ", scheduledTimes=" + scheduledTimes +
                ", quantityRemaining=" + quantityRemaining +
                '}';
    }
}
