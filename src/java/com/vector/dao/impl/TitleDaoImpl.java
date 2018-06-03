/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.TitleDao;
import com.vector.pojo.Title;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class TitleDaoImpl extends BaseDaoImpl<Title> implements TitleDao {

    @Override
    public List<Title> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from Title";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public boolean addOne(Title object) {
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
    public boolean updateOne(Title object) {
        boolean flag = false;
        try {
            update(object);
            flag = true;
        } catch (Exception e) {
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
            flag = false;
        }
        return flag;
    }

    @Override
    public int getListItemNumber() {
        String hql = "select count(*) from Title";
        return getListSize(hql);
    }

}
