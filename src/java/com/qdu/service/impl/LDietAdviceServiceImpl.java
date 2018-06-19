/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LDietAdviceService;
import com.vector.dao.DietAdviceDao;
import com.vector.pojo.DietAdvice;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class LDietAdviceServiceImpl implements LDietAdviceService {

    @Autowired
    private DietAdviceDao dietAdviceDao;

    @Override
    @Transactional
    public void insertDietAdvice(DietAdvice dietAdvice) {
        dietAdviceDao.insert(dietAdvice);
    }

    @Override
    @Transactional
    public void updateDietAdvice(DietAdvice dietAdvice) {
        dietAdviceDao.update(dietAdvice);
    }

    @Override
    @Transactional
    public void deleteDietAdvice(String dietAdviceId) {
        dietAdviceDao.delete(dietAdviceId);
    }

    @Override
    @Transactional
    public DietAdvice getAdviceByPatientId(String patientId) {
        String hql="from DietAdvice where patient.patientId=?";
        return dietAdviceDao.getListByQuery(hql,patientId).get(0);
    }
}
