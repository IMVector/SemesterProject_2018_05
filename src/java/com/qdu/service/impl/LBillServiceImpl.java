/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.LBillDao;
import com.qdu.service.LBillService;
import com.vector.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Vector
 */
public class LBillServiceImpl implements LBillService {

    @Autowired
    private LBillDao billDao;

    @Override
    public Double getTotalFee(Patient patient) {
        return billDao.getTotalAmount(patient.getPatientId());
    }

    @Override
    public void insertBill(Patient patient) {
        billDao.insertBill(patient);
    }

}
