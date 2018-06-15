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
@Transactional
@Service
public class HStaffServiceImpl implements HStaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff getOneById(Serializable id) {
        return staffDao.getOneById(id);
    }

    @Override
    public List<Staff> getStaffByTitle(Serializable titleName, Serializable currentPage) {
        return staffDao.getStaffByTitle(titleName, currentPage);
    }

    @Override
    public List<Staff> getStaffByName(Serializable name, Serializable currentPage) {
        return staffDao.getStaffByName(name, currentPage);
    }

    @Override
    public List<Staff> getAllList(Serializable currentPage) {
        return staffDao.getListOfAllWithPagination(currentPage);
    }

    @Override
    public int getListItemNumber() {
        return staffDao.getListItemNumber();
    }

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

    @Override
    public boolean deleteOne(Serializable id) {
        return staffDao.deleteOneById(id);
    }

    @Override
    public Integer getStaffByNameItemNum(Serializable name) {
        return staffDao.getStaffByNameItemNum(name);
    }

    @Override
    public Integer getStaffByTitleItemNum(Serializable titleName) {
        return staffDao.getStaffByTitleItemNum(titleName);
    }

    @Override
    public List<Staff> getStaffWithImage(Serializable number) {
        return staffDao.getStaffWithImage(number);
    }

    @Override
    public int getStaffNumWithImage() {
        return staffDao.getStaffNumWithImage();
    }

    @Override
    public List<Staff> getStaffByDepartmentName(Serializable departmentName, Serializable currentPage) {
        return staffDao.getStaffByDepartmentName(departmentName, currentPage);
    }

    @Override
    public int getStaffByDepartmentNameItemNum(Serializable departmentName) {
        return staffDao.getStaffByDepartmentNameItemNum(departmentName);
    }

}
