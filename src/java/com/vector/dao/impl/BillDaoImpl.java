/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BillDao;
import com.vector.pojo.Bill;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class BillDaoImpl extends BaseDaoImpl<Bill> implements BillDao {

    @Override
    public List<Bill> getBillOfPatientByYear(Serializable patientId, Serializable year) {

        String yearStart = year + "-01-01 00:00:00";
        String yearEnd = year + "-12-31 23:59:59";
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        try {
            startDate = sdf.parse(yearStart);
            endDate = sdf.parse(yearEnd);
            String hql = "from Bill where patient.patientId=? and inDate between ? and ?";
            return getListByQuery(hql, patientId, startDate, endDate);
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public List<Bill> getListById(Serializable id, Serializable currentPage) {
        String hql = "from Bill where patient.patientId=?";
        return getListPaginationByQuery(hql, currentPage, id);

    }

    @Override
    public List<Bill> getList(Serializable currentPage) {
        String hql = "from Bill";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public Bill getOneOfSomeoneById(Serializable id) {
        return getOneById(id);
    }

    @Override
    public int getItemNum() {
        String hql = "select count(*) from Bill ";
        return getListSize(hql);
    }

    @Override
    public int getItemNum(Serializable id) {
        String hql = "select count(*) from Bill where patient.patientId=?";
        return getListSize(hql, id);
    }

}
