/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Medication;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface MedicationService extends AdminBaseService<Medication> {

    List<Medication> getOneByName(Serializable name);

}
