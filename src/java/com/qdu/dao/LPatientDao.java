/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.Patient;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface LPatientDao extends BaseDao<Patient>{
       List<Patient> getPatientList();
       String getPassword(String patientId,String answer);
       String getQuestion(String id);
}
