/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.BillDao;
import com.vector.pojo.Bill;
import com.vector.pojo.MedicalRecord;
import com.vector.service.BillService;
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
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Transactional
    @Override
    public double[] getMedicalVisitsFee(Serializable patientId, Serializable year) {

        double fee[] = new double[12];
        for (int i = 0; i < 12; i++) {
            fee[i] = 0;
        }
        List<Bill> list = billDao.getBillOfPatientByYear(patientId, year);
        for (Bill b : list) {
            fee[b.getBillDate().getMonth()]+= b.getTotalAmount();
        }
        
//        for(int i=0;i<fee.length;i++){
//            System.out.println(fee[i]);
//        }
        return fee;
    }

    @Transactional
    @Override
    public Bill getOneById(Serializable id) {
        return billDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<Bill> getAllList(Serializable currentPage) {
        return billDao.getList(currentPage);
    }

    @Transactional
    @Override
    public List<Bill> getAllListOfSomeone(Serializable id, Serializable currentPage) {
        return billDao.getListById(id, currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return billDao.getItemNum();
    }

    @Transactional
    @Override
    public int getListItemNumber(Serializable id) {
        return billDao.getItemNum(id);
    }

}
