/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.MedicationHistory;
import java.util.List;

/**
 *
 * @author 刘福港
 */
public interface MedicalHistoryService {
    
    void insertMedicalHistory(MedicationHistory medicalHistory);
    void updateMedicalHistory(MedicationHistory medicalHistory);
    void deleteMedicalHistory(String medicalHistoryId);
    List<MedicationHistory> getMedicalHistoryList(String patientId);
    MedicationHistory getMedicalHistoryByPatientId(String patientId);
}
