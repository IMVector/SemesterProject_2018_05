/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.MedicalHistoryDao;
import com.qdu.service.MedicalHistoryService;
import com.vector.pojo.MedicationHistory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 刘福港
 */
@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService{
    @Autowired
    private MedicalHistoryDao medicalHistoryDao;

    @Override
    public void insertMedicalHistory(MedicationHistory medicalHistory) {
        medicalHistoryDao.insert(medicalHistory);
    }

    @Override
    public void updateMedicalHistory(MedicationHistory medicalHistory) {
        medicalHistoryDao.update(medicalHistory);
    }

    @Override
    public void deleteMedicalHistory(String medicalHistoryId) {
        medicalHistoryDao.delete(medicalHistoryId);
    }

    @Override
    public List<MedicationHistory> getMedicalHistoryList(int patientId) {
        return medicalHistoryDao.getMedicalHistory(patientId);
    }

    
    
}
