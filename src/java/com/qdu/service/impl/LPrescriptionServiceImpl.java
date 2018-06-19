/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LPrescriptionService;
import com.vector.dao.PrescriptionDao;
import com.vector.pojo.Prescription;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class LPrescriptionServiceImpl implements LPrescriptionService {

    @Autowired
    private PrescriptionDao prescriptionDao;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public Prescription getPrescriptionById(String patientId) {
        String hql="from Prescription where patient.patientId=?";
        return prescriptionDao.getListByQuery(hql,patientId).get(0);
    }

    

}
