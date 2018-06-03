/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BackpackFileDao;
import com.vector.pojo.BackpackFile;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class BackpackFileDaoImpl extends BaseDaoImpl<BackpackFile> implements BackpackFileDao {

    @Override
    public List<BackpackFile> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from BackpackFile";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public int getListItemNumber() {
        String hql = "select count(*)from BackpackFile";
        return getListSize(hql);
    }

    @Override
    public boolean addOne(BackpackFile object) {
        boolean bool = false;
        try {
            insert(object);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public boolean updateOne(BackpackFile object) {
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
