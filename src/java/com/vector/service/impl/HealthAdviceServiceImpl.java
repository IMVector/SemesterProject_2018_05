/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.HealthAdviceDao;
import com.vector.pojo.PrecautionAdvice;
import com.vector.service.HealthAdviceService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class HealthAdviceServiceImpl implements HealthAdviceService {

    @Autowired
    private HealthAdviceDao healthAdviceDao;

    @Transactional
    @Override
    public PrecautionAdvice getOneById(Serializable id) {
        return healthAdviceDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<PrecautionAdvice> getAllList(Serializable currentPage) {
        return healthAdviceDao.getList(currentPage);
    }

    @Transactional
    @Override
    public List<PrecautionAdvice> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return healthAdviceDao.getListById(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return healthAdviceDao.getItemNum();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return healthAdviceDao.getItemNum(id);
    }

}
