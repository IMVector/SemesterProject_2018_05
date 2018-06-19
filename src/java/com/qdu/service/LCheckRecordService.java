/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.CheckRecord;
import com.vector.pojo.CheckResult;

/**
 *
 * @author Vector
 */
public interface LCheckRecordService {

    String insertCheckRecord(CheckRecord cr);

    String updateCheckRecord(CheckRecord cr);

    String deleteCheckRecord(String Cid);
    
    CheckResult getCheckResult(String Id);
}
