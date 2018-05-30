/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BaseDao;
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
        String hql = "from CheckRecord where patient.patientId=?";
        return getListPaginationByQuery(hql, currentPage, patientId);
    }

    @Override
    public CheckRecord getCheckRecordByPatientId(Serializable checkRecordId) {
        return getOneById(checkRecordId);
    }

    @Override
    public List<CheckRecord> getCheckRecordList(Serializable currentPage) {
        String hql = "form CheckRecord";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public int getListItemNum(Serializable id) {
        String hql = "select count(*) from CheckRecord where patient.patientId=?";;
        return getListSize(hql, id);
    }

    @Override
    public int getListItemNum() {
        String hql = "select count(*) from CheckRecord";;
        return getListSize(hql);
    }

}
