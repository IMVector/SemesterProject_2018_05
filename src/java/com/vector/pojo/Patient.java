package com.vector.pojo;
// Generated 2018-5-26 16:13:05 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Patient generated by hbm2java
 */
public class Patient implements java.io.Serializable {

    private String patientId;
    private Image image;
    private String patientName;
    private String patientBirthday;
    private String patientGender;
    private Integer patientAge;
    private String bloodType;
    private String patientPhone;
    private String patientAddress;
    private String patientMstatus;
    private String patientEmail;
    private String patientQuestion;
    private String patientAnswer;
    private String patientPassword;
    private String patientImagePath;
    private Set<DietAdvice> dietAdvices = new HashSet<DietAdvice>(0);
    private Set<Bill> bills = new HashSet<Bill>(0);
    private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>(0);
    private Set<CheckResult> checkResults = new HashSet<CheckResult>(0);
    private Set<PrecautionAdvice> precautionAdvices = new HashSet<PrecautionAdvice>(0);
    private Set<Prescription> prescriptions = new HashSet<Prescription>(0);
    private Set<CheckRecord> checkRecords = new HashSet<CheckRecord>(0);
    private Set<MedicationHistory> medicationHistories = new HashSet<MedicationHistory>(0);

    public Patient() {
    }

    public Patient(String patientName, String patientBirthday, String patientGender, Integer patientAge, String patientPhone, String patientAddress, String patientMstatus, String patientEmail, String patientQuestion, String patientAnswer, String patientPassword) {
        this.patientName = patientName;
        this.patientBirthday = patientBirthday;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientMstatus = patientMstatus;
        this.patientEmail = patientEmail;
        this.patientQuestion = patientQuestion;
        this.patientAnswer = patientAnswer;
        this.patientPassword = patientPassword;
    }

    public Patient(String patientId, String patientName, String patientBirthday, String patientGender, String patientPhone, String patientAddress, String patientMstatus, String patientEmail, String patientQuestion, String patientAnswer, String patientPassword) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientBirthday = patientBirthday;
        this.patientGender = patientGender;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientMstatus = patientMstatus;
        this.patientEmail = patientEmail;
        this.patientQuestion = patientQuestion;
        this.patientAnswer = patientAnswer;
        this.patientPassword = patientPassword;
    }

    public Patient(String patientId, Image image, String patientName, String patientBirthday, String patientGender, Integer patientAge, String bloodType, String patientPhone, String patientAddress, String patientMstatus, String patientEmail, String patientQuestion, String patientAnswer, String patientPassword, Set<DietAdvice> dietAdvices, Set<Bill> bills, Set<MedicalRecord> medicalRecords, Set<CheckResult> checkResults, Set<PrecautionAdvice> precautionAdvices, Set<CheckRecord> checkRecords, Set<MedicationHistory> medicationHistories, Set<Prescription> prescriptions) {
        this.patientId = patientId;
        this.image = image;
        this.patientName = patientName;
        this.patientBirthday = patientBirthday;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.bloodType = bloodType;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientMstatus = patientMstatus;
        this.patientEmail = patientEmail;
        this.patientQuestion = patientQuestion;
        this.patientAnswer = patientAnswer;
        this.patientPassword = patientPassword;
        this.dietAdvices = dietAdvices;
        this.bills = bills;
        this.medicalRecords = medicalRecords;
        this.checkResults = checkResults;
        this.precautionAdvices = precautionAdvices;
        this.checkRecords = checkRecords;
        this.medicationHistories = medicationHistories;
        this.prescriptions = prescriptions;
    }

    public Patient(String patientId, Image image, String patientName, String patientBirthday, String patientGender, Integer patientAge, String bloodType, String patientPhone, String patientAddress, String patientMstatus, String patientEmail, String patientQuestion, String patientAnswer, String patientPassword, String patientImagePath) {
        this.patientId = patientId;
        this.image = image;
        this.patientName = patientName;
        this.patientBirthday = patientBirthday;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.bloodType = bloodType;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientMstatus = patientMstatus;
        this.patientEmail = patientEmail;
        this.patientQuestion = patientQuestion;
        this.patientAnswer = patientAnswer;
        this.patientPassword = patientPassword;
        this.patientImagePath = patientImagePath;
    }

    public String getPatientImagePath() {
        return patientImagePath;
    }

    public void setPatientImagePath(String patientImagePath) {
        this.patientImagePath = patientImagePath;
    }

    public Patient(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientBirthday() {
        return this.patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientGender() {
        return this.patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientAge() {
        return this.patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPatientPhone() {
        return this.patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientAddress() {
        return this.patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientMstatus() {
        return this.patientMstatus;
    }

    public void setPatientMstatus(String patientMstatus) {
        this.patientMstatus = patientMstatus;
    }

    public String getPatientEmail() {
        return this.patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientQuestion() {
        return this.patientQuestion;
    }

    public void setPatientQuestion(String patientQuestion) {
        this.patientQuestion = patientQuestion;
    }

    public String getPatientAnswer() {
        return this.patientAnswer;
    }

    public void setPatientAnswer(String patientAnswer) {
        this.patientAnswer = patientAnswer;
    }

    public String getPatientPassword() {
        return this.patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public Set<DietAdvice> getDietAdvices() {
        return this.dietAdvices;
    }

    public void setDietAdvices(Set<DietAdvice> dietAdvices) {
        this.dietAdvices = dietAdvices;
    }

    public Set<Bill> getBills() {
        return this.bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Set<CheckResult> getCheckResults() {
        return this.checkResults;
    }

    public void setCheckResults(Set<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public Set<PrecautionAdvice> getPrecautionAdvices() {
        return this.precautionAdvices;
    }

    public void setPrecautionAdvices(Set<PrecautionAdvice> precautionAdvices) {
        this.precautionAdvices = precautionAdvices;
    }

    public Set<CheckRecord> getCheckRecords() {
        return this.checkRecords;
    }

    public void setCheckRecords(Set<CheckRecord> checkRecords) {
        this.checkRecords = checkRecords;
    }

    public Set<MedicationHistory> getMedicationHistories() {
        return this.medicationHistories;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void setMedicationHistories(Set<MedicationHistory> medicationHistories) {
        this.medicationHistories = medicationHistories;
    }

}
