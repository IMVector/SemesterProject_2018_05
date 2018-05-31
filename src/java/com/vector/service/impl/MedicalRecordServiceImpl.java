/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.MedicalRecordDao;
import com.vector.pojo.MedicalRecord;
import com.vector.service.MedicalRecordService;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    MedicalRecordDao medicalRecordDao;

    @Transactional
    @Override
    public MedicalRecord getOneById(Serializable id) {
        return medicalRecordDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<MedicalRecord> getAllList(Serializable currentPage) {
        return medicalRecordDao.getAllMedicalRecordList(currentPage);
    }

    @Transactional
    @Override
    public List<MedicalRecord> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return medicalRecordDao.getAllMedicalRecordListOfSomeOne(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return medicalRecordDao.getListItemNumber();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return medicalRecordDao.getListItemNumber(id);
    }

    @Transactional
    @Override
    public int[] getMedicalVisitsNum(Serializable patientId, Serializable year) {
        int month[] = new int[12];
        for (int i = 0; i < 12; i++) {
            month[i] = 0;
        }
        List<MedicalRecord> list = medicalRecordDao.getMedicalOfPatientByYear(patientId, year);
        for (MedicalRecord m : list) {
            month[m.getInDate().getMonth()]++;
        }
        return month;
    }

    @Transactional
    @Override
    public Set getMedicalYear(Serializable patientId) {
        List<MedicalRecord> list = medicalRecordDao.getAllMedicalRecordListofSomeone(patientId);
        Set yearSet = new HashSet();
        Calendar calendar = Calendar.getInstance();
        for (MedicalRecord m : list) {
            calendar.setTime(m.getInDate());
            System.out.println(calendar.get(Calendar.YEAR));
            yearSet.add(calendar.get(Calendar.YEAR));
        }
        return yearSet;
    }

}
