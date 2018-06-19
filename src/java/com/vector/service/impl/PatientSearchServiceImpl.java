/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.MedicalRecordDao;
import com.vector.dao.PatientSearchDao;
import com.vector.pojo.Bill;
import com.vector.pojo.CheckResult;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import com.vector.pojo.Prescription;
import com.vector.service.PatientSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class PatientSearchServiceImpl implements PatientSearchService {

    @Autowired
    private PatientSearchDao patientSearchDao;
//    @Autowired
//    private MedicalRecordDao medicalRecordDao;
    

//    @Transactional
//    @Override
//    public List<MedicalRecord> searchMedicalRecordsList(String patientId,Integer currentPage) {
//        List<MedicalRecord> recordList = medicalRecordDao.getAllMedicalRecordList(patientId,currentPage);
//        return recordList;
//
//    }   
//    @Transactional
//    @Override
//    public List<Bill> searchBillsList(String patientId,Integer currentPage) {
//        return null;
//    }
//    @Transactional
//    @Override
//    public List<Prescription> searchPrescriptionsList(String patientId,Integer currentPage) {
//        return null;
//    }
//    @Transactional
//    @Override
//    public List<CheckResult> serachResultsList(String patientId,Integer currentPage) {
//        return null;
//    }
    @Transactional
    @Override
    public Patient searchPatient(String patientId) {
        return patientSearchDao.getPatient(patientId);
    }

}
