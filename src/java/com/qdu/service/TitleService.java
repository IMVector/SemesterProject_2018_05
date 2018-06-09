/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.vector.pojo.Title;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 刘福港
 */

public interface TitleService{
    
    List<Title> getAllTitle();
    Title getTitle(int id);
    
}
