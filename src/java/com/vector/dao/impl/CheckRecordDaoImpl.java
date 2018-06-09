/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.CheckRecordDao;
import com.vector.pojo.CheckRecord;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class CheckRecordDaoImpl extends BaseDaoImpl<CheckRecord> implements CheckRecordDao {

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

  

}
