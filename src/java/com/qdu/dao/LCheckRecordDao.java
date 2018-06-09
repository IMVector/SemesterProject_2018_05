/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.util.Date;

/**
 *
 * @author Vector
 */
public interface LCheckRecordDao extends BaseDao<CheckRecord> {

    void insertCheckRecord(Patient patient, Date checkDate, String checkItem);
}
