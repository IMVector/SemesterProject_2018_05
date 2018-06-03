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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    private MedicalRecordDao medicalRecordDao;

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
            yearSet.add(calendar.get(Calendar.YEAR));
            //System.out.println(calendar.get(Calendar.YEAR));

        }
        return yearSet;
    }

    @Transactional
    @Override
    public Map getIllnessInfo(Serializable patientId, Serializable year) {
        List<MedicalRecord> list = medicalRecordDao.getMedicalOfPatientByYear(patientId, year);

        Map illnessMap = new HashMap();
        for (MedicalRecord m : list) {
            if (illnessMap.containsKey(m.getInDiagnosis())) {
                int value = (int) illnessMap.get(m.getInDiagnosis());
                value++;
                illnessMap.replace(m.getInDiagnosis(), value);
            } else {
                illnessMap.put(m.getInDiagnosis(), 1);
            }
        }
        //遍历map中的键  

//        for (Object key : illnessMap.keySet()) {
//
//            System.out.println("Key = " + key);
//        }
//        //遍历map中的值  
//        for (Object value : illnessMap.values()) {
//
//            System.out.println("Value = " + value);
//        }
        return illnessMap;
    }

}
