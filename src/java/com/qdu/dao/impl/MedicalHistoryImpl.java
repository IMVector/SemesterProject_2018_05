/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.MedicalHistoryDao;
import com.vector.pojo.MedicationHistory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class MedicalHistoryImpl extends BaseDaoImpl<MedicationHistory> implements MedicalHistoryDao{
    @Autowired //自动装配,按照类型装配
    private SessionFactory sessionFactory;

    @Override
    public List<MedicationHistory> getMedicalHistory(String patirntId) {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from MedicationHistory where MedicationHistory.Patient.patientId=id");
        query.setParameter("id", patirntId);
        List<MedicationHistory> list=query.list(); //执行查询，获取结果集
        session.close();
        return list;
    }
    
}
