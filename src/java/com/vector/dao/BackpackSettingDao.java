/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.BackpackSetting;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface BackpackSettingDao extends BaseDao<BackpackSetting> {

    List<BackpackSetting> getSettingList();

    boolean addSetting(BackpackSetting setting);

    boolean deleteSetting(Integer settingId);

    boolean updateSetting(BackpackSetting settting);

    BackpackSetting getSettingById(Integer settingId);

}
