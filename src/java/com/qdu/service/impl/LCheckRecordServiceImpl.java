/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.LCheckRecordDao;
import com.qdu.service.LCheckRecordService;
import com.vector.pojo.CheckRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vector
 */
public class LCheckRecordServiceImpl implements LCheckRecordService {

    @Autowired
    private LCheckRecordDao checkRecordDao;
    @Autowired
    private SessionFactory sessionFactory;

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
        CheckRecord cr = checkRecordDao.getOneById(Cid);
        sessionFactory.getCurrentSession().delete(cr);
        if (checkRecordDao.getOneById(Cid) == null) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
