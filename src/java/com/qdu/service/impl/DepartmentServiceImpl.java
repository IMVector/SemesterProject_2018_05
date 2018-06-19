/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.DepartmentService;
import com.vector.pojo.Department;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.dao.LDepartmentDao;

/**
 *
 * @author 刘福港
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    
    @Autowired
    private LDepartmentDao departmentDao;
    

    @Override
    @Transactional
    public List<Department> getDepartmentList() {
        return departmentDao.getListByQuery("from Department");
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentDao.getOneById(departmentId);
    }
    
}
