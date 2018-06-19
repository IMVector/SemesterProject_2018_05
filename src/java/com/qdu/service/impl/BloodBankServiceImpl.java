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
import javax.transaction.Transactional;
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
    @Transactional
    public void addBloodBank(BloodBank newBloodBank) {
        bloodBankDao.insert(newBloodBank);
    }
    @Override
    @Transactional
    public void updateBloodBank(BloodBank updatedBloodBank) {
        bloodBankDao.update(updatedBloodBank);
    }
    @Override
    @Transactional
    public void deleteBloodBank(int stuId) {
        bloodBankDao.delete(stuId);
    }
    @Override
    @Transactional
    public List<BloodBank> getBloodBankList() {
        return bloodBankDao.getBloodList();
    }

    @Override
    @Transactional
    public List<BloodBank> getBloodBankByType(String type) {
        return bloodBankDao.getBloodListByType(type);
    }

    @Override
    @Transactional
    public BloodBank getDonor(int recordId) {
        return bloodBankDao.getOneById(recordId);
    }
    
}

