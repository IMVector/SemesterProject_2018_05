/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.CheckResultDao;
import com.qdu.service.CheckResultService;
import com.vector.pojo.CheckResult;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 刘福港
 */
@Service
public class CheckResultServiceImpl implements CheckResultService{
    @Autowired
    private CheckResultDao dao;

    @Override
    @Transactional
    public void insertCheckResult(CheckResult c) {
        dao.insert(c);
    }

    @Override
    @Transactional
    public CheckResult getCheckResultById(String Id) {
        List l=dao.getListByQuery("from CheckResult where patient.patientId=?", Id);
        System.out.println("+++++++++++++++++++++++++++"+l.size());
        return (CheckResult) l.get(0);
    }
    
}
