/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.CheckRecord;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface CheckRecordDao extends BaseDao<CheckRecord> {

    List<CheckRecord> getCheckRecordList(Serializable currentPage);

    List<CheckRecord> getCheckRecordListByPatientId(Serializable patientId, Serializable currentPage);

    CheckRecord getCheckRecordByPatientId(Serializable patientId);

    int getListItemNum(Serializable patientId);

    int getListItemNum();

}
