/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.DepartmentDao;
import com.vector.pojo.Department;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public class DepartmetnDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

    @Override
    public List<Department> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from Department";
        return getListPaginationByQuery(hql, currentPage);
    }
    @Override
    public boolean addOne(Department object) {
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
    public boolean updateOne(Department object) {
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

}
