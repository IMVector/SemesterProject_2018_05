/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.qdu.dao.CheckItemDao;
import com.vector.dao.BillDao;
import com.vector.dao.CheckRecordDao;
import com.vector.pojo.Bill;
import com.vector.pojo.CheckItem;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class CheckRecordDaoImpl extends BaseDaoImpl<CheckRecord> implements CheckRecordDao {
    
    @Autowired
    private CheckItemDao checkItemDao;
    @Autowired
    private BillDao billDao;

    @Override
    public List<CheckRecord> getCheckRecordListByPatientId(Serializable patientId, Serializable currentPage) {
        int isChecked = 1;
        String hql = "from CheckRecord where patient.patientId=? and isChecked=?";
        return getListPaginationByQuery(hql, currentPage, patientId, isChecked);
    }

    @Override
    public CheckRecord getCheckRecordByPatientId(Serializable checkRecordId) {
        return getOneById(checkRecordId);
    }

    @Override
    public List<CheckRecord> getCheckRecordList(Serializable currentPage) {
        int isChecked = 1;
        String hql = "form CheckRecord where isChecked=?";
        return getListPaginationByQuery(hql, currentPage, isChecked);
    }

    @Override
    public int getListItemNum(Serializable id) {
        int isChecked = 1;
        String hql = "select count(*) from CheckRecord where patient.patientId=? and isChecked=?";;
        return getListSize(hql, id, isChecked);
    }

    @Override
    public int getListItemNum() {
        int isChecked = 1;
        String hql = "select count(*) from CheckRecord where isChecked=?";;
        return getListSize(hql, isChecked);
    }

    @Override
    public void insertCheckRecord(Patient patient, Date checkDate,String checkItem) {
        
        CheckItem ci=checkItemDao.getListByQuery("from CheckItem where checkItemName=?", checkItem).get(0);
        String paymentStatus="否";
        Integer isChecked=0;
        Bill b=billDao.getListByQuery("from Bill where Patient=?", patient).get(0);
        CheckRecord cr=new CheckRecord();
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
