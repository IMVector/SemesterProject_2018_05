/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BackpackSettingDao;
import com.vector.pojo.BackpackFile;
import com.vector.pojo.BackpackSetting;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Repository
public class BackpackSettingDaoImpl extends BaseDaoImpl<BackpackSetting> implements BackpackSettingDao {



    @Override
    public BackpackSetting getSettingById(Integer settingId) {
        return getOneById(settingId);
    }

    @Override
    public List<BackpackSetting> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from BackpackSetting";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public int getListItemNumber() {
        String hql="select count(*) from BackpackSetting";
        return getListSize(hql);
    }

    @Override
    public boolean addOne(BackpackSetting object) {
        boolean bool = false;
        try {
            insert(object);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
            bool = false;
        }
        return bool;
    }

    @Override
    public boolean updateOne(BackpackSetting object) {
        boolean bool = false;
        try {
            update(object);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public boolean deleteOneById(Serializable id) {
        boolean bool = false;
        try {
            delete(id);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

}
