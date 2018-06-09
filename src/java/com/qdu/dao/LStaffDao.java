/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.Staff;


/**
 *
 * @author Dell
 */
public interface StaffDao extends BaseDao<Staff>{
    
    String getPassword(String StaffId,String answer);
    
    String getQuestion(String staffId);
}
