/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckResult;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Prescription;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */


public interface PatientBaseService<T> {

    T getOneById(Serializable id);

    List<T> getAllList(Serializable currentPage);

    List<T> getAllListOfSomeone(Serializable id, Serializable currentPage);

    int getListItemNumber();

    int getListItemNumber(Serializable id);

}
