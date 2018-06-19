/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.BloodBankDao;
import com.vector.pojo.BloodBank;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class BloodBankDaoImpl extends BaseDaoImpl<BloodBank> implements BloodBankDao{
//public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<BloodBank> getBloodList() {
        return getListByQuery("from BloodBank");
    }

    @Override
    public List<BloodBank> getBloodListByType(String bloodType) {
        return getListByQuery("from BloodBank where donorBloodType=?", bloodType);
    }
}
