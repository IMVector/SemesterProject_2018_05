/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;

/**
 *
 * @author Vector
 */
public interface LMedicalRecordService {

    void insertMedicalRecord(MedicalRecord mr);

    void updateMedicalRecord(MedicalRecord mr);

    void deleteMedicalRecord(String id);
    
    MedicalRecord getRecordById(String patientId);
    
     public void addMedicalRecord(Patient p);
     
    MedicalRecord getLatestMedicalRecord(String patientId);
}
