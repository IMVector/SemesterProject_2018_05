/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.MedicalRecord;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface MedicalRecordDao extends BaseDao<MedicalRecord> {

    List<MedicalRecord> getAllMedicalRecordList(Serializable curentPage);

    List<MedicalRecord> getAllMedicalRecordListOfSomeOne(Serializable patientId, Serializable curentPage);
    
    List<MedicalRecord> getAllMedicalRecordListofSomeone(Serializable patientId);

    int getListItemNumber();

    int getListItemNumber(Serializable patientId);

    List<MedicalRecord> getMedicalOfPatientByYear(Serializable patientId,Serializable year);
    
    
    

}
