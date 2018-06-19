/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.CheckResult;

/**
 *
 * @author 刘福港
 */
public interface CheckResultService {
    
    void insertCheckResult(CheckResult c);
    
    CheckResult getCheckResultById(String Id);
}
