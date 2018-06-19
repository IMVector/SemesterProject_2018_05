/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.DietAdvice;

/**
 *
 * @author Dell
 */
public interface DietAdviceService {
    
    void addDietAdvice(DietAdvice newDietAdvice);
    void updateDietAdvice(DietAdvice updatedDietAdvice);
    void deleteDietAdvice(String dietAdvice);
    DietAdvice getDietAdvice(String patientId);
}
