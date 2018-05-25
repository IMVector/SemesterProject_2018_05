/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckResult;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Prescription;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface BaseService {

    List<MedicalRecord> searchMedicalRecordsList(String patientId);

    List<Bill> searchBillsList(String patientId);

    List<Prescription> searchPrescriptionsList(String patientId);

    List<CheckResult> serachResultsList(String patientId);

}
