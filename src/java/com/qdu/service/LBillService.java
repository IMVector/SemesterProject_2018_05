/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.Bill;
import com.vector.pojo.Patient;

/**
 *
 * @author Vector
 */
public interface LBillService {
       
  Double getTotalFee(Patient patient);
  
  void insertBill(Patient patient);
  
  Bill getBillById(String Id);
}
