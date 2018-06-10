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
@Service
public class HDepartmentServiceImpl implements HDepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    @Override
    public List<Department> getAllList(Serializable currentPage) {
        return departmentDao.getListOfAllWithPagination(currentPage);
    }

    @Transactional
    @Override
    public List<Department> getOneByName(Serializable name) {
        return departmentDao.getOneByName(name);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return departmentDao.getListItemNumber();
    }

    @Transactional
    @Override
    public boolean addOne(Department object) {
        return departmentDao.addOne(object);
    }

    @Transactional
    @Override
    public boolean updateOne(Department object) {
        return departmentDao.updateOne(object);
    }

    @Transactional
    @Override
    public boolean deleteOne(Serializable id) {
        return departmentDao.deleteOneById(id);
    }

    @Transactional
    @Override
    public List<Department> getAllList() {
        return departmentDao.getAllList();
    }

}
