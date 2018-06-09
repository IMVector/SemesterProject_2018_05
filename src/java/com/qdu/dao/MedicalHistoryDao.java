/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.MedicationHistory;
import java.util.List;


/**
 *
 * @author Dell
 */
public interface MedicalHistoryDao extends BaseDao<MedicationHistory>{
    List<MedicationHistory> getMedicalHistory(int patirntId);
}
