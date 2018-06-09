/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.DietAdvice;

/**
 *
 * @author Vector
 */
public interface LDietAdviceService {
        
    void insertDietAdvice(DietAdvice dietAdvice );
    void updateDietAdvice (DietAdvice dietAdvice );
    void deleteDietAdvice(String dietAdviceId ); 
}
