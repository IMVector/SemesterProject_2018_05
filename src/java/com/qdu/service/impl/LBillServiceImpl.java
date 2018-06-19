/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.LBillDao;
import com.qdu.service.LBillService;
import com.vector.pojo.Bill;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class LBillServiceImpl implements LBillService{

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

    @Override
    @Transactional
    public Bill getBillById(String Id) {
        
        List l=billDao.getListByQuery("from Bill where patient.patientId=?", Id);
        System.out.println("+++++++++++++++++++++++++++"+l.size());
        return (Bill) l.get(0);
    }

}
