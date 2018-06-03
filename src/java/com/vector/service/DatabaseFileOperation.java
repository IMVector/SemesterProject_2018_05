/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.BackpackSetting;
import java.io.Serializable;

/**
 *
 * @author Vector
 */
public interface DatabaseFileOperation extends AdminBaseService<BackpackSetting>{


    BackpackSetting getBackpackSettingById(Serializable id);
    
    public void setSettingPath(BackpackSetting setting);

    public boolean backpack();

    public boolean restore(String fileName);


}
