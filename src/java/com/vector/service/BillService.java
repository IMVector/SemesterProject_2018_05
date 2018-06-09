/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Bill;
import com.vector.pojo.Patient;
import java.io.Serializable;

/**
 *
 * @author Vector
 */
public interface BillService extends BaseService<Bill> {
       
   double[] getMedicalVisitsFee(Serializable patientId, Serializable year);
   
  Double getTotalFee(Patient patient);
  
  void insertBill(Patient patient);
}
