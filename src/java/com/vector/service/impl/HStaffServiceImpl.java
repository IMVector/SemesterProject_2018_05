/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.StaffDao;
import com.vector.pojo.Department;
import com.vector.pojo.Staff;
import com.vector.pojo.Title;
import com.vector.service.HStaffService;
import com.vector.utils.MD5Utils;
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
public class HStaffServiceImpl implements HStaffService {

    @Autowired
    private StaffDao staffDao;

    @Transactional
    @Override
    public Staff getOneById(Serializable id) {
        return staffDao.getOneById(id);
    }

    @Transactional
    @Override
    public List<Staff> getStaffByTitle(Serializable titleName, Serializable currentPage) {
        return staffDao.getStaffByTitle(titleName, currentPage);
    }

    @Transactional
    @Override
    public List<Staff> getStaffByName(Serializable name, Serializable currentPage) {
        return staffDao.getStaffByName(name, currentPage);
    }

    @Transactional
    @Override
    public List<Staff> getAllList(Serializable currentPage) {
        return staffDao.getListOfAllWithPagination(currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return staffDao.getListItemNumber();
    }

    @Transactional
    @Override
    public boolean addOne(Staff object) {
        Title title = new Title();
        title.setTitleId(object.getTitleId());
        object.setTitle(title);
        Department department = new Department();
        department.setDepartmentId(object.getDepartmentId());
        object.setDepartment(department);
        object.setStaffQuestion("空");
        object.setStaffAnswer("空");
        object.setStaffPassword(MD5Utils.md5("123456"));
        return staffDao.addOne(object);
    }

    @Transactional
    @Override
    public boolean updateOne(Staff object) {
        Staff oldStaff = staffDao.getStaffById(object.getStaffId());
        oldStaff.setStaffName(object.getStaffName());
        Title title = new Title();
        title.setTitleId(object.getTitleId());
        Department department = new Department();
        department.setDepartmentId(object.getDepartmentId());
        oldStaff.setTitle(title);
        oldStaff.setTitle(title);
        oldStaff.setDepartment(department);
        return staffDao.updateOne(oldStaff);
    }

    @Transactional
    @Override
    public boolean deleteOne(Serializable id) {
        return staffDao.deleteOneById(id);
    }

    @Transactional
    @Override
    public Integer getStaffByNameItemNum(Serializable name) {
        return staffDao.getStaffByNameItemNum(name);
    }

    @Transactional
    @Override
    public Integer getStaffByTitleItemNum(Serializable titleName) {
        return staffDao.getStaffByTitleItemNum(titleName);
    }

}
