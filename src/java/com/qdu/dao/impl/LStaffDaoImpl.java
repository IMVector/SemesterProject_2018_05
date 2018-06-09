/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.vector.pojo.Staff;
import org.springframework.stereotype.Repository;
import com.qdu.dao.LStaffDao;

/**
 *
 * @author Dell
 */
@Repository
public class LStaffDaoImpl extends BaseDaoImpl<Staff> implements LStaffDao{

    @Override
    public String getPassword(String StaffId, String answer) {
        Staff s=getOneById(StaffId);
        if(s.getStaffAnswer().equals(answer))
            return s.getStaffPassword().toString();
        else
            return "答案不正确";
    }

    @Override
    public String getQuestion(String staffId) {
        Staff s=getOneById(staffId);
        return s.getStaffQuestion();
    }
    
}
