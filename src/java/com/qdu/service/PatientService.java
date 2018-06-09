/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.Patient;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface PatientService {
    Patient validatePatient(String stuId,String stuPwd);
    void addPatient(Patient newPatient);
    void updatePatient(Patient updatedPatient);
    void deletePatient(String stuId);
    List<Patient> getPatientList();  
    String getPassword(String patientId,String answer);
    String getQuestion(String id);
}
