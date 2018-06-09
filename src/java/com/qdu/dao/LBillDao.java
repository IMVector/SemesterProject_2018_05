/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.Patient;
import java.io.Serializable;

/**
 *
 * @author Vector
 */
public interface LBillDao {

    Double getTotalAmount(Serializable patientId);

    void insertBill(Patient patient);
}
