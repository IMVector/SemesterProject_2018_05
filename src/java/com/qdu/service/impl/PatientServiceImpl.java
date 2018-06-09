/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.PatientService;
import com.vector.pojo.Patient;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.dao.LPatientDao;

/**
 *
 * @author Dell
 */
@Service

    public class PatientServiceImpl implements PatientService{

    @Autowired
    private LPatientDao PatientDao;
    
    @Override
    @Transactional
    public Patient validatePatient(String stuId, String stuPwd) {
        
        Patient s=PatientDao.getOneById(stuId);
        if(null!=s&&s.getPatientPassword().equals(stuPwd))
            return s;
        else
            return null;
    }

    @Override
    @Transactional
    public void addPatient(Patient newPatient) {
        PatientDao.insert(newPatient);
    }
    @Override
    public void updatePatient(Patient updatedPatient) {
        PatientDao.update(updatedPatient);
    }
    @Override
    public void deletePatient(String stuId) {
        PatientDao.delete(stuId);
    }
    @Override
     @Transactional
    public List<Patient> getPatientList() {
        return PatientDao.getPatientList();
    }

    @Override
     @Transactional
    public String getPassword(String patientId, String answer) {
        return PatientDao.getPassword(patientId, answer);
    }

    @Override
     @Transactional
    public String getQuestion(String id) {
        return PatientDao.getQuestion(id);
    }
    
}

