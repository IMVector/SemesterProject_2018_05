/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BackpackSettingDao;
import com.vector.pojo.BackpackSetting;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class BackpackSettingDaoImpl extends BaseDaoImpl<BackpackSetting> implements BackpackSettingDao {

    @Override
    public List<BackpackSetting> getSettingList() {
        String hql = "from BackpackSetting";
        return getListByQuery(hql);
    }

    @Override
    public boolean addSetting(BackpackSetting setting) {
        boolean bool = false;
        try {
            insert(setting);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public boolean deleteSetting(Integer settingId) {
        boolean bool = false;
        try {
            delete(settingId);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public boolean updateSetting(BackpackSetting settting) {
        boolean bool = false;
        try {
            update(settting);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public BackpackSetting getSettingById(Integer settingId) {
        return getOneById(settingId);
    }

}
