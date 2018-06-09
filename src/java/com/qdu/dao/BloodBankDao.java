/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.BloodBank;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface BloodBankDao extends BaseDao<BloodBank>{
    List<BloodBank> getBloodList();
    
    List<BloodBank> getBloodListByType(String bloodType);
}
