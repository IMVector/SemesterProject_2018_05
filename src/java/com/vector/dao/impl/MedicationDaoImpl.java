/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.MedicationDao;
import com.vector.pojo.Medication;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class MedicationDaoImpl extends BaseDaoImpl<Medication> implements MedicationDao {

    @Override
    public List<Medication> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from Medication";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public List<Medication> getOneByName(Serializable name) {
        String hql = "from Medication where medicationName=?";
        return getListByQuery(hql, name);
    }

    @Override
    public boolean addOne(Medication object) {
        boolean flag = false;
        try {
            insert(object);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateOne(Medication object) {
        boolean flag = false;
        try {
            update(object);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteOneById(Serializable id) {
        boolean flag = false;
        try {
            delete(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public int getListItemNumber() {
        String hql = "select count(*) from Medication";
        return getListSize(hql);
    }

}
