/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.StaffDao;
import com.vector.pojo.Staff;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {

    @Override
    public List<Staff> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from Staff";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public boolean addOne(Staff object) {
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
    public boolean updateOne(Staff object) {
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
    public List<Staff> getStaffByName(Serializable name, Serializable currentPage) {

        String hql = "from Staff where staffName=?";
        return getListPaginationByQuery(hql, currentPage, name);
    }

    @Override
    public Staff getStaffById(Serializable id) {
        return getOneById(id);
    }

    @Override
    public List<Staff> getStaffByTitle(Serializable title, Serializable currentPage) {
        String hql = "from Staff where title.titleName=?";

        return getListPaginationByQuery(hql, currentPage, title);
    }

    @Override
    public int getListItemNumber() {
        String hql = "select count(*) from Staff";
        return getListSize(hql);
    }

}
