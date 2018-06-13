/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface CheckRecordService extends PatientBaseService<CheckRecord> {

    List<CheckRecord> getCheckRecordWithNoCheck(Serializable patientId, Serializable currentPage);

    int getListItemNumWithNoCheck(Serializable patientId);

}
