/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.MedicationDao;
import com.vector.pojo.Medication;
import com.vector.service.MedicationService;
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
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationDao medicationDao;

    @Transactional
    @Override
    public List<Medication> getListOfAllWithPagination(Serializable currentPage) {
        return medicationDao.getListOfAllWithPagination(currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return medicationDao.getListItemNumber();
    }

    @Transactional
    @Override
    public boolean addOne(Medication object) {
        return medicationDao.addOne(object);
    }

    @Transactional
    @Override
    public boolean updateOne(Medication object) {
        return medicationDao.updateOne(object);
    }

    @Transactional
    @Override
    public boolean deleteOneById(Serializable id) {
        return medicationDao.deleteOneById(id);
    }

    @Transactional
    @Override
    public Medication getMedicationByName(String name) {
        return medicationDao.getOneByName(name);
    }

}
