/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.PatientSearchDao;
import com.vector.pojo.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class PatientSearchDaoImpl extends BaseDaoImpl<Patient> implements PatientSearchDao{

    @Autowired
    private SessionFactory sessionFactory;
    

}
