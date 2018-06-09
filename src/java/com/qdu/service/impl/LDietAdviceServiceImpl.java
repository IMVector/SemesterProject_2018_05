/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LDietAdviceService;
import com.vector.dao.DietAdviceDao;
import com.vector.pojo.DietAdvice;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vector
 */
public class LDietAdviceServiceImpl implements LDietAdviceService {

    @Autowired
    private DietAdviceDao dietAdviceDao;

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
