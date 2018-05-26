/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.PatientSearchDao;
import com.vector.pojo.Bill;
import com.vector.pojo.CheckResult;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import com.vector.pojo.Prescription;
import com.vector.service.PatientSearchService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class PatientSearchServiceImpl implements PatientSearchService {

    @Autowired
    private PatientSearchDao patientSearchDao;

    @Transactional
    @Override
    public List<MedicalRecord> searchMedicalRecordsList(String patientId) {
        List<MedicalRecord> recordList=patientSearchDao.getMedecalRecordList(patientId);
        
        return recordList;

    }

    @Override
    public List<Bill> searchBillsList(String patientId) {
        return null;
    }

    @Override
    public List<Prescription> searchPrescriptionsList(String patientId) {
        return null;
    }

    @Override
    public List<CheckResult> serachResultsList(String patientId) {
        return null;
    }

}
