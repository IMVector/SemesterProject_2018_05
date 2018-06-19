/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LMedicalRecordService;
import com.vector.dao.MedicalRecordDao;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class LMedicalRecordServcieImpl implements LMedicalRecordService {

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @Override
    @Transactional
    public void insertMedicalRecord(MedicalRecord mr) {
        medicalRecordDao.insert(mr);
    }

    @Override
    public void updateMedicalRecord(MedicalRecord mr) {
        medicalRecordDao.update(mr);
    }

    @Override
    public void deleteMedicalRecord(String id) {
        medicalRecordDao.delete(id);
    }

    @Override
    public MedicalRecord getRecordById(String patientId) {
        return medicalRecordDao.getListByQuery("from MedicalRecord where patient.patientId=?", patientId).get(0);
    }
    @Transactional
    public void addMedicalRecord(Patient p){
        System.out.println(medicalRecordDao.getListItemNumber());
        MedicalRecord medical=new MedicalRecord(0,p,new Date());
        
        medicalRecordDao.insert(medical);
        
    }

    @Override
    @Transactional
    public MedicalRecord getLatestMedicalRecord(String patientId) {
        System.out.println(patientId);
        List l=medicalRecordDao.getListByQuery("from MedicalRecord where patient.patientId=?", patientId);
        System.out.println("+++++++++++++++++++++++++++"+l.size());
        return (MedicalRecord) l.get(0);
    }
}
