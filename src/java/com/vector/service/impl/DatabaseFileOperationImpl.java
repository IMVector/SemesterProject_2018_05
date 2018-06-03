/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.BackpackFileDao;
import com.vector.dao.BackpackSettingDao;
import com.vector.pojo.BackpackSetting;
import com.vector.service.DatabaseFileOperation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class DatabaseFileOperationImpl implements DatabaseFileOperation {

    @Autowired
    private BackpackSettingDao backpackSettingDao;

    private BackpackSetting setting;

//    @Scheduled(cron = "0/10 * * * * ? ")
    @Override
    public boolean backpack() {
        String sqlPath = (String) setting.getBackpackSqlFile();
        String batPath = (String) setting.getBackpackBatFile();
        String savePath = (String) setting.getBackpackToPath();
        System.out.println(sqlPath);
        System.out.println(batPath);
        String command = "cmd.exe /c " + batPath + " " + sqlPath + " " + savePath;
        System.out.println(command);
        try {
            Runtime javaRuntime = Runtime.getRuntime();
            Process pr = javaRuntime.exec(command);
            InputStream in = pr.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "GBK");
            BufferedReader br = new BufferedReader(isr);
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean restore(String fileName) {
        
        boolean flag=false;
        String sqlPath = (String) setting.getBackpackSqlFile();
        String batPath = (String) setting.getBackpackBatFile();
        String savePath = (String) setting.getBackpackToPath();
        System.out.println(sqlPath);
        System.out.println(batPath);
        String command = "cmd.exe /c " + batPath + " " + sqlPath + " " + fileName;
        System.out.println(command);
        try {
            Runtime javaRuntime = Runtime.getRuntime();
            Process pr = javaRuntime.exec(command);
            InputStream in = pr.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "GBK");
            BufferedReader br = new BufferedReader(isr);
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }
            br.close();
            flag=true;
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }

    @Transactional
    @Override
    public List<BackpackSetting> getAllList(Serializable currentPage) {
        return backpackSettingDao.getListOfAllWithPagination(currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return backpackSettingDao.getListItemNumber();
    }

    @Override
    public void setSettingPath(BackpackSetting setting) {
        this.setting = setting;
    }

    @Transactional
    @Override
    public BackpackSetting getBackpackSettingById(Serializable id) {
        return backpackSettingDao.getOneById(id);
    }

}
