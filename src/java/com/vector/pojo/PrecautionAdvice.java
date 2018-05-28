package com.vector.pojo;
// Generated 2018-5-26 16:13:05 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 * PrecautionAdvice generated by hbm2java
 */
public class PrecautionAdvice implements java.io.Serializable {

    private int precautionAdviceId;
    @JsonIgnore
    private Patient patient;
    @JsonIgnore
    private Staff staff;
    private String precautionAdviceContent;
    private Date dietAdviceTime;

    public PrecautionAdvice() {
    }

    public PrecautionAdvice(int precautionAdviceId, Patient patient, Staff staff, String precautionAdviceContent, Date dietAdviceTime) {
        this.precautionAdviceId = precautionAdviceId;
        this.patient = patient;
        this.staff = staff;
        this.precautionAdviceContent = precautionAdviceContent;
        this.dietAdviceTime = dietAdviceTime;
    }

    public int getPrecautionAdviceId() {
        return this.precautionAdviceId;
    }

    public void setPrecautionAdviceId(int precautionAdviceId) {
        this.precautionAdviceId = precautionAdviceId;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPrecautionAdviceContent() {
        return this.precautionAdviceContent;
    }

    public void setPrecautionAdviceContent(String precautionAdviceContent) {
        this.precautionAdviceContent = precautionAdviceContent;
    }

    public Date getDietAdviceTime() {
        return this.dietAdviceTime;
    }

    public void setDietAdviceTime(Date dietAdviceTime) {
        this.dietAdviceTime = dietAdviceTime;
    }

}