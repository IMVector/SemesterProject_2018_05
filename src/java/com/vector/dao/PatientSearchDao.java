/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface PatientSearchDao extends BaseDao<Patient>{
    
//    List<MedicalRecord> getMedecalRecordList(String patientId,Integer currentPage);
    Patient getPatient(String patientId);
}
