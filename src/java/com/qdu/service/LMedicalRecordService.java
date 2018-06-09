/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.MedicalRecord;

/**
 *
 * @author Vector
 */
public interface LMedicalRecordService {

    void insertMedicalRecord(MedicalRecord mr);

    void updateMedicalRecord(MedicalRecord mr);

    void deleteMedicalRecord(String id);
}
