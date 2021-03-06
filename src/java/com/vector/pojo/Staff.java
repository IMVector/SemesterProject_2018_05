package com.vector.pojo;
// Generated 2018-6-10 9:29:45 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

/**
 * Staff generated by hbm2java
 */
public class Staff implements java.io.Serializable {

    private String staffId;
    private Department department;
    private Integer departmentId;
    private Image image;
    private Title title;
    private Integer titleId;
    private String staffName;
    private String staffQuestion;
    private String staffAnswer;
    private String staffPassword;
    private String motto;
    @JsonIgnore
    private Set<CheckResult> checkResults = new HashSet<CheckResult>(0);
    @JsonIgnore
    private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>(0);
    @JsonIgnore
    private Set<PrecautionAdvice> precautionAdvices = new HashSet<PrecautionAdvice>(0);
    @JsonIgnore
    private Set<DietAdvice> dietAdvices = new HashSet<DietAdvice>(0);

    public Staff() {
    }

    public Staff(String staffId, Department department, Title title, String staffName, String staffQuestion, String staffAnswer, String staffPassword) {
        this.staffId = staffId;
        this.department = department;
        this.title = title;
        this.staffName = staffName;
        this.staffQuestion = staffQuestion;
        this.staffAnswer = staffAnswer;
        this.staffPassword = staffPassword;
    }

    public Staff(String staffId, Department department, Integer departmentId, Image image, Title title, Integer titleId, String staffName, String staffQuestion, String staffAnswer, String staffPassword) {
        this.staffId = staffId;
        this.department = department;
        this.departmentId = departmentId;
        this.image = image;
        this.title = title;
        this.titleId = titleId;
        this.staffName = staffName;
        this.staffQuestion = staffQuestion;
        this.staffAnswer = staffAnswer;
        this.staffPassword = staffPassword;
    }

    public Staff(String staffId, Department department, Image image, Title title, String staffName, String staffQuestion, String staffAnswer, String staffPassword, Set<CheckResult> checkResults, Set<MedicalRecord> medicalRecords, Set<PrecautionAdvice> precautionAdvices, Set<DietAdvice> dietAdvices) {
        this.staffId = staffId;
        this.department = department;
        this.image = image;
        this.title = title;
        this.staffName = staffName;
        this.staffQuestion = staffQuestion;
        this.staffAnswer = staffAnswer;
        this.staffPassword = staffPassword;
        this.checkResults = checkResults;
        this.medicalRecords = medicalRecords;
        this.precautionAdvices = precautionAdvices;
        this.dietAdvices = dietAdvices;
    }

    public Staff(String staffId, Department department, Integer departmentId, Image image, Title title, Integer titleId, String staffName, String staffQuestion, String staffAnswer, String staffPassword, String motto) {
        this.staffId = staffId;
        this.department = department;
        this.departmentId = departmentId;
        this.image = image;
        this.title = title;
        this.titleId = titleId;
        this.staffName = staffName;
        this.staffQuestion = staffQuestion;
        this.staffAnswer = staffAnswer;
        this.staffPassword = staffPassword;
        this.motto = motto;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getStaffId() {
        return this.staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffQuestion() {
        return this.staffQuestion;
    }

    public void setStaffQuestion(String staffQuestion) {
        this.staffQuestion = staffQuestion;
    }

    public String getStaffAnswer() {
        return this.staffAnswer;
    }

    public void setStaffAnswer(String staffAnswer) {
        this.staffAnswer = staffAnswer;
    }

    public String getStaffPassword() {
        return this.staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Set<CheckResult> getCheckResults() {
        return this.checkResults;
    }

    public void setCheckResults(Set<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Set<PrecautionAdvice> getPrecautionAdvices() {
        return this.precautionAdvices;
    }

    public void setPrecautionAdvices(Set<PrecautionAdvice> precautionAdvices) {
        this.precautionAdvices = precautionAdvices;
    }

    public Set<DietAdvice> getDietAdvices() {
        return this.dietAdvices;
    }

    public void setDietAdvices(Set<DietAdvice> dietAdvices) {
        this.dietAdvices = dietAdvices;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

}
