/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.StaffService;
import com.vector.pojo.Department;
import com.vector.pojo.Staff;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.dao.LStaffDao;
import com.qdu.dao.LDepartmentDao;

/**
 *
 * @author Dell
 */
@Service
public class StaffServiceImpl implements StaffService{

    


    @Autowired
    private LStaffDao staffDao;
    @Autowired
    private LDepartmentDao departmentDao;
    
    @Override
    @Transactional
    public Staff validateStaff(String staffId, String staffPwd) {
        
        Staff s=staffDao.getOneById(staffId);
        if(null!=s&&s.getStaffPassword().equals(staffPwd))
            return s;
        else
            return null;
    }

    @Override
    @Transactional
    public void addStaff(Staff newStaff) {
        staffDao.insert(newStaff);
    }
    @Override
    @Transactional
    public void updateStaff(Staff updatedStaff) {
        staffDao.update(updatedStaff);
    }
    @Override
    public void deleteStaff(String stuId) {
        staffDao.delete(stuId);
    }
    

    @Override
    @Transactional
    public Staff getStaffById(String staffId) {
        return staffDao.getOneById(staffId);
    }

    @Override
    @Transactional
    public String getPassword(String id, String answer) {
        return staffDao.getPassword(id, answer);
    }

    @Override
    @Transactional
    public String getQuestion(String id) {
        return staffDao.getQuestion(id);
    }

    @Override
    @Transactional
    public int getDepartmentId(String departmentName) {
        return departmentDao.getListByQuery("from Department where departmentName=?", departmentName).get(0).getDepartmentId();
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.getListByQuery("from Department");
    }
    
}
