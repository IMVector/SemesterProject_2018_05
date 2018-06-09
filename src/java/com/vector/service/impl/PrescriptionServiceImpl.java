/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.PrescriptionDao;
import com.vector.pojo.Prescription;
import com.vector.service.PrescriptionService;
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
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionDao prescriptionDao;

    @Transactional
    @Override
    public Prescription getOneById(Serializable id) {
        return prescriptionDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<Prescription> getAllList(Serializable currentPage) {
        return prescriptionDao.getList(currentPage);
    }

    @Transactional
    @Override
    public List<Prescription> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return prescriptionDao.getListById(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return prescriptionDao.getItemNum();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return prescriptionDao.getItemNum(id);
    }

    @Override
    public void insertPrescription(Prescription prescription) {
        prescriptionDao.insert(prescription);
    }

    @Override
    public void updatePrescription(Prescription prescription) {
        prescriptionDao.update(prescription);
    }

    @Override
    public void deletePrescription(String prescriptionId) {
        prescriptionDao.delete(prescriptionId);
    }

}
