/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.CheckRecordDao;
import com.vector.pojo.CheckRecord;
import com.vector.service.CheckRecordService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Transactional
@Service
public class CheckRecordServiceImpl implements CheckRecordService {

    @Autowired
    private CheckRecordDao checkRecordDao;

    @Override
    public CheckRecord getOneById(Serializable id) {
        return checkRecordDao.getOneById(id);
    }

    @Override
    public List<CheckRecord> getAllList(Serializable currentPage) {
        return checkRecordDao.getCheckRecordList(currentPage);
    }

    @Override
    public List<CheckRecord> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return checkRecordDao.getCheckRecordListByPatientId(id, currentPage);
    }

    @Override
    public int getListItemNumber() {
        return checkRecordDao.getListItemNum();
    }

    @Override
    public int getListItemNumber(Serializable id) {
        return checkRecordDao.getListItemNum(id);
    }

    @Override
    public List<CheckRecord> getCheckRecordWithNoCheck(Serializable patientId, Serializable currentPage) {
        return checkRecordDao.getCheckRecordWithNoCheck(patientId, currentPage);
    }

    @Override
    public int getListItemNumWithNoCheck(Serializable patientId) {
        return checkRecordDao.getListItemNumWithNoCheck(patientId);
    }

}
