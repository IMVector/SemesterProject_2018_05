/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.LCheckRecordDao;
import com.vector.dao.BillDao;
import com.vector.pojo.Bill;
import com.vector.pojo.CheckItem;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.qdu.dao.LCheckItemDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class LCheckRecordDaoImpl extends BaseDaoImpl<CheckRecord> implements LCheckRecordDao {

    @Autowired
    private LCheckItemDao checkItemDao;
    @Autowired
    private BillDao billDao;

    @Override
    public void insertCheckRecord(Patient patient, Date checkDate, String checkItem) {

        CheckItem ci = checkItemDao.getListByQuery("from CheckItem where checkItemName=?", checkItem).get(0);
        String paymentStatus = "否";
        Integer isChecked = 0;
        Bill b = billDao.getListByQuery("from Bill where Patient=?", patient).get(0);
        CheckRecord cr = new CheckRecord();
        cr.setBill(b);
        cr.setCheckDate(checkDate);
        cr.setCheckItem(ci);
        cr.setCheckResult(null);
        cr.setIsChecked(isChecked);
        cr.setPatient(patient);
        cr.setPaymentStatus(paymentStatus);
        insert(cr);

    }

}
