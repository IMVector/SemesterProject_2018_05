package com.vector.pojo;
// Generated 2018-5-26 16:13:05 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MedicalRecord generated by hbm2java
 */
public class MedicalRecord implements java.io.Serializable {

    private String doctorName;
    private int medicalRecordId;
    private Department department;
    @JsonIgnore
    private Patient patient;
    @JsonIgnore
    private Staff staff;
    private Date inDate;
    private String inDiagnosis;
    private Date outDate;
    private String outDiagnosis;
    private String isHospitalization;
    private Set<Prescription> prescriptions = new HashSet<Prescription>(0);
    private Set<CheckResult> checkResults = new HashSet<CheckResult>(0);

    public MedicalRecord() {
    }

    public MedicalRecord(int medicalRecordId, Patient patient, Date inDate) {
        this.medicalRecordId = medicalRecordId;
        this.patient = patient;
        this.inDate = inDate;
    }

    public MedicalRecord(int medicalRecordId, Department department, Patient patient, Staff staff, Date inDate, String inDiagnosis, Date outDate, String outDiagnosis, String isHospitalization, Set<Prescription> prescriptions, Set<CheckResult> checkResults) {
        this.medicalRecordId = medicalRecordId;
        this.department = department;
        this.patient = patient;
        this.staff = staff;
        this.inDate = inDate;
        this.inDiagnosis = inDiagnosis;
        this.outDate = outDate;
        this.outDiagnosis = outDiagnosis;
        this.isHospitalization = isHospitalization;
        this.prescriptions = prescriptions;
        this.checkResults = checkResults;
    }

    public int getMedicalRecordId() {
        return this.medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        if (null != staff) {
            this.doctorName = staff.getStaffName();
        }
    }

    public Date getInDate() {
        return this.inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getInDiagnosis() {
        return this.inDiagnosis;
    }

    public void setInDiagnosis(String inDiagnosis) {
        this.inDiagnosis = inDiagnosis;
    }

    public Date getOutDate() {
        return this.outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOutDiagnosis() {
        return this.outDiagnosis;
    }

    public void setOutDiagnosis(String outDiagnosis) {
        this.outDiagnosis = outDiagnosis;
    }

    public String getIsHospitalization() {
        return this.isHospitalization;
    }

    public void setIsHospitalization(String isHospitalization) {
        this.isHospitalization = isHospitalization;
    }

    public Set<Prescription> getPrescriptions() {
        return this.prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<CheckResult> getCheckResults() {
        return this.checkResults;
    }

    public void setCheckResults(Set<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}
