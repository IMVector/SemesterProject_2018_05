/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.PatientSearchDao;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class PatientSearchDaoImpl extends BaseDaoImpl<Patient> implements PatientSearchDao {

    @Override
    public Patient getPatient(String patientId) {
        return getOneById(patientId);
    }

}
