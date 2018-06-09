/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.Patient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Vector
 */
public interface BillDao extends AbstractDao<Bill> {
    
    List<Bill>getBillOfPatientByYear(Serializable patientId, Serializable year);
    
    Double getTotalAmount(Serializable patientId);
    void insertBill(Patient patient);
}
