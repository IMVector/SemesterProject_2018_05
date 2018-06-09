/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.BloodBank;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface BloodBankService {
    
    
    void addBloodBank(BloodBank newBloodBank);
    void updateBloodBank(BloodBank updatedBloodBank);
    void deleteBloodBank(String Id);
    List<BloodBank> getBloodBankList(); 
    List<BloodBank> getBloodBankByType(String type);
}
