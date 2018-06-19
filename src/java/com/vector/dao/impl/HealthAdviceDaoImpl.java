/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.HealthAdviceDao;
import com.vector.pojo.PrecautionAdvice;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class HealthAdviceDaoImpl extends BaseDaoImpl<PrecautionAdvice> implements HealthAdviceDao {

    @Override
    public List<PrecautionAdvice> getListById(Serializable id, Serializable currentPage) {
        String hql = "from PrecautionAdvice where patient.patientId=?";
        return  getListPaginationByQuery(hql, currentPage, id);
    }

    @Override
    public List<PrecautionAdvice> getList(Serializable currentPage) {
        String hql = "from PrecautionAdvice";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public PrecautionAdvice getOneOfSomeoneById(Serializable id) {
        return getOneById(id);
    }

    @Override
    public int getItemNum() {
        String hql = "select count(*) from PrecautionAdvice";
        return getListSize(hql);
    }

    @Override
    public int getItemNum(Serializable id) {
        String hql = "select count(*) from PrecautionAdvice where patient.patientId=?";
        return getListSize(hql, id);
    }

}
