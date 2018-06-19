/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.Department;
import java.util.List;

/**
 *
 * @author 刘福港
 */
public interface DepartmentService {
    
    List<Department> getDepartmentList();
    
    Department getDepartmentById(int departmentId);
}
