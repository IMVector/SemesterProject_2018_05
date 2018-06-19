/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.DepartmentDao;
import com.vector.pojo.Department;
import com.vector.service.HDepartmentService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Transactional
@Service
public class HDepartmentServiceImpl implements HDepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAllList(Serializable currentPage) {
        return departmentDao.getListOfAllWithPagination(currentPage);
    }

    @Override
    public List<Department> getOneByName(Serializable name) {
        return departmentDao.getOneByName(name);
    }

    @Override
    public int getListItemNumber() {
        return departmentDao.getListItemNumber();
    }

    @Override
    public boolean addOne(Department object) {
        return departmentDao.addOne(object);
    }

    @Override
    public boolean updateOne(Department object) {
        return departmentDao.updateOne(object);
    }

    @Override
    public boolean deleteOne(Serializable id) {
        return departmentDao.deleteOneById(id);
    }

    @Override
    public List<Department> getAllList() {
        return departmentDao.getAllList();
    }

}
