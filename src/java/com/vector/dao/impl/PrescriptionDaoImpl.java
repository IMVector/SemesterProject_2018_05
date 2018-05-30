/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.AbstractDao;
import com.vector.dao.PrescriptionDao;
import com.vector.pojo.Prescription;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class PrescriptionDaoImpl extends BaseDaoImpl<Prescription> implements PrescriptionDao{

    @Override
    public List<Prescription> getListById(Serializable id, Serializable currentPage) {
        String hql = "from Prescription where patient.patientId=?";
        return getListPaginationByQuery(hql, currentPage, id);
    }

    @Override
    public List<Prescription> getList(Serializable currentPage) {
        String hql = "from Prescription";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public Prescription getOneOfSomeoneById(Serializable id) {
        return getOneById(id);
    }

    @Override
    public int getItemNum() {
        String hql = "select count(*) from Prescription";
        return getListSize(hql);
    }

    @Override
    public int getItemNum(Serializable id) {
        String hql = "select count(*) from Prescription where patient.patientId=?";
        return getListSize(hql, id);
    }

}
