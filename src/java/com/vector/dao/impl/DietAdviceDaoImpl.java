/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.DietAdviceDao;
import com.vector.pojo.DietAdvice;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class DietAdviceDaoImpl extends BaseDaoImpl<DietAdvice> implements DietAdviceDao {

    @Override
    public List<DietAdvice> getListById(Serializable id, Serializable currentPage) {
        String hql = "from DietAdvice where patient.patientId=?";
        return getListPaginationByQuery(hql, currentPage, id);
    }

    @Override
    public List<DietAdvice> getList(Serializable currentPage) {
        String hql = "from DietAdvice";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public DietAdvice getOneOfSomeoneById(Serializable id) {
        return getOneById(id);
    }

    @Override
    public int getItemNum() {
        String hql = "select count(*) from DietAdvice";
        return getListSize(hql);
    }

    @Override
    public int getItemNum(Serializable id) {
        String hql = "select count(*) from DietAdvice where patient.patientId=?";
        return getListSize(hql, id);
    }

}
