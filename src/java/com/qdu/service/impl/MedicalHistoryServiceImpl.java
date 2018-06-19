/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.MedicalHistoryDao;
import com.qdu.service.MedicalHistoryService;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.MedicationHistory;
import java.util.List;
import javax.transaction.Transactional;
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
    @Transactional
    public void insertMedicalHistory(MedicationHistory medicalHistory) {
        medicalHistoryDao.insert(medicalHistory);
    }

    @Override
    @Transactional
    public void updateMedicalHistory(MedicationHistory medicalHistory) {
        medicalHistoryDao.update(medicalHistory);
    }

    @Override
    @Transactional
    public void deleteMedicalHistory(String medicalHistoryId) {
        medicalHistoryDao.delete(medicalHistoryId);
    }

    @Override
    @Transactional
    public List<MedicationHistory> getMedicalHistoryList(String patientId) {
        return medicalHistoryDao.getMedicalHistory(patientId);
    }

    @Override
    @Transactional
    public MedicationHistory getMedicalHistoryByPatientId(String patientId) {
        String hql="from MedicationHistory where patient.patientId=?";
        return medicalHistoryDao.getListByQuery(hql,patientId).get(0);
    }

    

}
