/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;

/**
 *
 * @author Vector
 */
public interface CheckRecordService extends BaseService<CheckRecord> {
//
//    List<CheckRecord> getCheckRecordListByPatientId(String patientId, Integer currentPage);
//
//    CheckRecord getCheckRecordByPatientId(Integer checkRecordId);
//
//    int getCheckListItemNum(String patientId);
//
//    int getCheckListItemNum();
    
    String insertCheckRecord(CheckRecord cr);
    String updateCheckRecord(CheckRecord cr);
    String deleteCheckRecord(String Cid);

}
