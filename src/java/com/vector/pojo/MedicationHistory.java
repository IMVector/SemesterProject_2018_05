package com.vector.pojo;
// Generated 2018-5-25 7:55:16 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;

/**
 * MedicationHistory generated by hbm2java
 */
public class MedicationHistory  implements java.io.Serializable {


     private int medicationHistoryId;
     private Medication medication;
     private Patient patient;
     private String adverseReactions;
     private int duration;
     private Date lastTime;

    public MedicationHistory() {
    }

    public MedicationHistory(int medicationHistoryId, Medication medication, Patient patient, String adverseReactions, int duration, Date lastTime) {
       this.medicationHistoryId = medicationHistoryId;
       this.medication = medication;
       this.patient = patient;
       this.adverseReactions = adverseReactions;
       this.duration = duration;
       this.lastTime = lastTime;
    }
   
    public int getMedicationHistoryId() {
        return this.medicationHistoryId;
    }
    
    public void setMedicationHistoryId(int medicationHistoryId) {
        this.medicationHistoryId = medicationHistoryId;
    }
    public Medication getMedication() {
        return this.medication;
    }
    
    public void setMedication(Medication medication) {
        this.medication = medication;
    }
    public Patient getPatient() {
        return this.patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getAdverseReactions() {
        return this.adverseReactions;
    }
    
    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }
    public int getDuration() {
        return this.duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Date getLastTime() {
        return this.lastTime;
    }
    
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }




}


