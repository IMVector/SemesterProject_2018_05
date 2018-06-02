/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.MedicalRecord;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Vector
 */
public interface MedicalRecordService extends BaseService<MedicalRecord> {

    int[] getMedicalVisitsNum(Serializable patientId, Serializable year);

    Set getMedicalYear(Serializable patientId);
    
    Map getIllnessInfo(Serializable patientId,Serializable year); 

}
