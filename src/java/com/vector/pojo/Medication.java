package com.vector.pojo;
// Generated 2018-5-26 16:13:05 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Medication generated by hbm2java
 */
public class Medication implements java.io.Serializable {

    private int medicationId;
    private String medicationName;
    private String medicationInstructions;
    private String medicationDescription;
    private Date productionDate;
    private Integer validityPeriod;
    @JsonIgnore
    private Set<MedicationHistory> medicationHistories = new HashSet<MedicationHistory>(0);

    public Medication() {
    }

    public Medication(int medicationId, String medicationName, String medicationInstructions, String medicationDescription) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.medicationInstructions = medicationInstructions;
        this.medicationDescription = medicationDescription;
    }

    public Medication(int medicationId, String medicationName, String medicationInstructions, String medicationDescription, Date productionDate, Integer validityPeriod) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.medicationInstructions = medicationInstructions;
        this.medicationDescription = medicationDescription;
        this.productionDate = productionDate;
        this.validityPeriod = validityPeriod;
    }

    public Medication(int medicationId, String medicationName, String medicationInstructions, String medicationDescription, Set<MedicationHistory> medicationHistories) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.medicationInstructions = medicationInstructions;
        this.medicationDescription = medicationDescription;
        this.medicationHistories = medicationHistories;
    }

    public int getMedicationId() {
        return this.medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationName() {
        return this.medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationInstructions() {
        return this.medicationInstructions;
    }

    public void setMedicationInstructions(String medicationInstructions) {
        this.medicationInstructions = medicationInstructions;
    }

    public String getMedicationDescription() {
        return this.medicationDescription;
    }

    public void setMedicationDescription(String medicationDescription) {
        this.medicationDescription = medicationDescription;
    }

    public Set<MedicationHistory> getMedicationHistories() {
        return this.medicationHistories;
    }

    public void setMedicationHistories(Set<MedicationHistory> medicationHistories) {
        this.medicationHistories = medicationHistories;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

}
