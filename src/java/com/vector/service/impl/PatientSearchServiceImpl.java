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

/**
 *
 * @author Vector
 */
@Service
public class PatientSearchServiceImpl implements PatientSearchService {

    @Autowired
    private PatientSearchDao patientSearchDao;

    @Override
    public List<MedicalRecord> searchMedicalRecordsList(String patientId) {
        Patient p = (Patient) patientSearchDao.getListByQuery("form Patient where patientId=?", patientId).get(0);
        Set<MedicalRecord> medicalRecord = p.getMedicalRecords();
        for (MedicalRecord r : medicalRecord) {
            System.out.println(r.getCheckResults());
        }
        return null;

    }

    @Override
    public List<Bill> searchBillsList(String patientId) {
        Patient p = (Patient) patientSearchDao.getListByQuery("form Patient where patientId=?", patientId).get(0);
        Set<Bill> bills = p.getBills();
        for (Bill b : bills) {
            System.out.println(b.getBillId());
        }
        return null;
    }

    @Override
    public List<Prescription> searchPrescriptionsList(String patientId) {
        Patient p = (Patient) patientSearchDao.getListByQuery("form Patient where patientId=?", patientId).get(0);
        Set<MedicalRecord> medicalRecords = p.getMedicalRecords();
        List<Prescription> prescriptionList = new ArrayList();
        for (MedicalRecord medicalRecord : medicalRecords) {
            Set<Prescription> prescriptions = medicalRecord.getPrescriptions();
            for (Prescription prescription : prescriptions) {
                prescriptionList.add(prescription);
            }
        }

        return null;
    }

    @Override
    public List<CheckResult> serachResultsList(String patientId) {

        Patient p = (Patient) patientSearchDao.getListByQuery("form Patient where patientId=?", patientId).get(0);
        Set<MedicalRecord> medicalRecords = p.getCheckResults();
        

        return null;
    }
}
