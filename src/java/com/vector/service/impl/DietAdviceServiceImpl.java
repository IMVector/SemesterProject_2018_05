/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.DietAdviceDao;
import com.vector.pojo.DietAdvice;
import com.vector.service.DietAdviceService;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class DietAdviceServiceImpl implements DietAdviceService {

    @Autowired
    private DietAdviceDao dietAdviceDao;

    @Transactional
    @Override
    public DietAdvice getOneById(Serializable id) {
        return dietAdviceDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<DietAdvice> getAllList(Serializable currentPage) {
        return dietAdviceDao.getList(currentPage);
    }

    @Transactional
    @Override
    public List<DietAdvice> getAllListOfSomeone(Serializable id, Serializable currentPage) {

        return dietAdviceDao.getListById(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return dietAdviceDao.getItemNum();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return dietAdviceDao.getItemNum(id);
    }

    @Override
    public void insertDietAdvice(DietAdvice dietAdvice) {
        dietAdviceDao.insert(dietAdvice);
    }

    @Override
    public void updateDietAdvice(DietAdvice dietAdvice) {
        dietAdviceDao.update(dietAdvice);
    }

    @Override
    public void deleteDietAdvice(String dietAdviceId) {
        dietAdviceDao.delete(dietAdviceId);
    }

}
