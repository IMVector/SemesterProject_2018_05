/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LMedicalRecordService;
import com.vector.dao.MedicalRecordDao;
import com.vector.pojo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Transactional
@Service
public class LMedicalRecordServcieImpl implements LMedicalRecordService {

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @Override
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

}
