/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.CheckRecordDao;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import com.vector.service.CheckRecordService;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class CheckRecordServiceImpl implements CheckRecordService {

    @Autowired
    private CheckRecordDao checkRecordDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public CheckRecord getOneById(Serializable id) {
        return checkRecordDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<CheckRecord> getAllList(Serializable currentPage) {
        return checkRecordDao.getCheckRecordList(currentPage);
    }

    @Transactional
    @Override
    public List<CheckRecord> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return checkRecordDao.getCheckRecordListByPatientId(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return checkRecordDao.getListItemNum();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return checkRecordDao.getListItemNum(id);
    }

    @Override
    public String insertCheckRecord(CheckRecord cr) {
        checkRecordDao.insert(cr);
        return "插入成功";
    }

    @Override
    public String updateCheckRecord(CheckRecord cr) {
        checkRecordDao.update(cr);
        return "更新成功";
    }

    @Override
    public String deleteCheckRecord(String Cid) {
        CheckRecord cr= checkRecordDao.getOneById(Cid);
        sessionFactory.getCurrentSession().delete(cr);
        if(checkRecordDao.getOneById(Cid)==null)
            return "删除成功";
        else
            return "删除失败";
    }

}
