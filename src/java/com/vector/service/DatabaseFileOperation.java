/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.BackpackSetting;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface DatabaseFileOperation {

    public List<BackpackSetting> getSettings();

//    public void setting(BackpackSetting setting);
    
    public void setBackpackPath(BackpackSetting setting);

    public void backpack();

    public void restore(String fileName);

    public String getFilePath(Integer id);

}
