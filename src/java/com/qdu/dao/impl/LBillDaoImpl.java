/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.LBillDao;
import com.vector.dao.CheckRecordDao;
import com.vector.pojo.Bill;
import com.vector.pojo.CheckItem;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.qdu.dao.LCheckItemDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class LBillDaoImpl extends BaseDaoImpl<Bill>implements LBillDao {

    @Autowired
    private LCheckItemDao cid;
    @Autowired
    private CheckRecordDao crd;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Double getTotalAmount(Serializable patientId) {
        String hql = "from CheckItem";
        List<CheckItem> checkItemList = cid.getListByQuery(hql);

        List<CheckRecord> checkRecordlist = crd.getListByQuery("from CheckRecord where CheckRecord.Patient.patientId=?", patientId);
//        int m=checkRecordlist.size();
        double total = 0;
        for (int i = 0; i <= checkRecordlist.size(); i++) {
            for (int n = 0; n <= checkItemList.size(); i++) {
                if (checkRecordlist.get(i).getCheckItem().getCheckItemName() == checkItemList.get(n).getCheckItemName()) {

                    total = total + checkItemList.get(n).getCheckItemPrice();
                }
            }
        }
        return total;
    }

    @Override
    public void insertBill(Patient patient) {
        Date date1 = new Date();
        Double p = getTotalAmount(patient.getPatientId());
        String s = "否";
        Set<CheckRecord> checkRecord = (Set) crd.getListByQuery("from CheckRecord where CheckRecord.Patient=?", patient);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Bill bill = new Bill();
        bill.setBillDate(date1);
        bill.setCheckRecords(checkRecord);
        bill.setPatient(patient);
        bill.setPaymentStatus(s);
        bill.setTotalAmount(p);
        session.save(bill);
        tx.commit();
        session.close();
    }
}
