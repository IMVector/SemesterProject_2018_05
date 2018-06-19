/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckResult;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import com.vector.pojo.Prescription;
import java.util.List;

/**
 *
 * @author NIIT
 */
public interface PatientSearchService {

    Patient searchPatient(String patientId);
    
//    List<MedicalRecord> searchMedicalRecordsList(String patientId,Integer currentPage);
//
//    List<Bill> searchBillsList(String patientId,Integer currentPage);
//
//    List<Prescription> searchPrescriptionsList(String patientId,Integer currentPage);
//
//    List<CheckResult> serachResultsList(String patientId,Integer currentPage);
    
    
}
