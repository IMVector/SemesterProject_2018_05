/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.Department;
import com.vector.pojo.Staff;
import java.util.List;


/**
 *
 * @author Dell
 */
public interface StaffService {
    Staff validateStaff(String staffId,String staffPwd);
    void addStaff(Staff newStaff);
    void updateStaff(Staff updatedStaff);
    void deleteStaff(String staffId);
    Staff getStaffById(String staffId);
    String getPassword(String id,String answer);
    String getQuestion(String id);
    int getDepartmentId(String departmentName);
    List<Department> getDepartmentList();
}
