/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.Bill;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface BillDao extends PatientAbstractDao<Bill> {

    List<Bill> getBillOfPatientByYear(Serializable patientId, Serializable year);

}
