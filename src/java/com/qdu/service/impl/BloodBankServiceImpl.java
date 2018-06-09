/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.BloodBankDao;
import com.qdu.service.BloodBankService;
import com.vector.pojo.BloodBank;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Dell
 */
@Service
public class BloodBankServiceImpl implements BloodBankService{

    @Autowired
    private BloodBankDao bloodBankDao;
    
   

    @Override
    public void addBloodBank(BloodBank newBloodBank) {
        bloodBankDao.insert(newBloodBank);
    }
    @Override
    public void updateBloodBank(BloodBank updatedBloodBank) {
        bloodBankDao.update(updatedBloodBank);
    }
    @Override
    public void deleteBloodBank(String stuId) {
        bloodBankDao.delete(stuId);
    }
    @Override
    public List<BloodBank> getBloodBankList() {
        return bloodBankDao.getBloodList();
    }

    @Override
    public List<BloodBank> getBloodBankByType(String type) {
        return bloodBankDao.getBloodListByType(type);
    }
    
}

