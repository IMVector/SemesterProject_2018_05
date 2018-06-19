/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.vector.pojo.Patient;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.qdu.dao.LPatientDao;

/**
 *
 * @author Dell
 */
@Repository
public class LPatientDaoImpl extends BaseDaoImpl<Patient> implements LPatientDao{
//public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{
    @Override
    public List<Patient> getPatientList() {
        return getListByQuery("from Patient");
    }

    @Override
    public String getPassword(String patientId, String answer) {
        Patient p=getOneById(patientId);
        if(p.getPatientAnswer().equals(answer))
            return p.getPatientPassword().toString();
        else
            return "答案不正确";
    }

    @Override
    public String getQuestion(String id) {
        Patient p=getOneById(id);
        return p.getPatientQuestion();
        
    }

    
    
}
