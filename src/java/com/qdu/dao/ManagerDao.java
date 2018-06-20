/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.Admin;

/**
 *
 * @author 刘福港
 */
public interface ManagerDao extends BaseDao<Admin>{
    
    void getAdmin();
}
