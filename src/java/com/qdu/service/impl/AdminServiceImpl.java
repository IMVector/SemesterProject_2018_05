/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.ManagerDao;
import com.qdu.service.AdminService;
import com.vector.pojo.Admin;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 刘福港
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    
    @Autowired
    private ManagerDao managerDao;
    
    @Override
    public Admin getAdminById(String adminId) {
        return managerDao.getOneById(adminId);
    }

    
    
}
