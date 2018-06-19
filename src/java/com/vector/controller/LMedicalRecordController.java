/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.DepartmentService;
import com.qdu.service.LMedicalRecordService;
import com.qdu.service.impl.LMedicalRecordServcieImpl;
import com.vector.pojo.Department;
import com.vector.pojo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author NIIT
 */
@Service
public class LMedicalRecordController {
    
    @Autowired
    private LMedicalRecordService medicalService;
    @Autowired
    private DepartmentService departmentService;
    
    
    @RequestMapping(value = "/patient/insertMedicalRecord",method = POST)
    public String insertMedicalRecord(MedicalRecord mr,String departmentId){
        
        Department department=departmentService.getDepartmentById(Integer.parseInt(departmentId));
        mr.setDepartment(department);
        medicalService.insertMedicalRecord(mr);
        return "插入成功";
    }
    
    
    
}
