/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.DietAdvice;
import com.vector.pojo.Prescription;

/**
 *
 * @author Vector
 */
public interface DietAdviceService extends PatientBaseService<DietAdvice> {
    
    void insertDietAdvice(DietAdvice dietAdvice );
    void updateDietAdvice (DietAdvice dietAdvice );
    void deleteDietAdvice(String dietAdviceId ); 
}
