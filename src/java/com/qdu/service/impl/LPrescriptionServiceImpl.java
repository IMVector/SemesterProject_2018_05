/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.LPrescriptionService;
import com.vector.dao.PrescriptionDao;
import com.vector.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vector
 */
public class LPrescriptionServiceImpl implements LPrescriptionService {

    @Autowired
    private PrescriptionDao prescriptionDao;

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
