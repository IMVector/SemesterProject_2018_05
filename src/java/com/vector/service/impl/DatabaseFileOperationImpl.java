/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.BackpackFileDao;
import com.vector.dao.BackpackSettingDao;
import com.vector.pojo.BackpackFile;
import com.vector.pojo.BackpackSetting;
import com.vector.service.DatabaseFileOperation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
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

    @Autowired
    private BackpackFileDao backpackFailDao;

    private BackpackSetting setting;

    @Transactional
    @Scheduled(cron = "0 */5 * * * ?")
    public void backpack() {
        if (null == setting || null == setting.getBackpackToPath()) {
            Resource resource = new ClassPathResource("properties/jdbc.properties");
            Properties props = null;
            try {
                props = PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setting = new BackpackSetting(0, props.getProperty("detabase.backpack_sql_path"), props.getProperty("database.backpack_bat_path"), props.getProperty("database.backpack_save_path"));
            System.out.println(props.getProperty("detabase.backpack_sql_path"));
            System.out.println(props.getProperty("database.backpack_bat_path"));
            System.out.println(props.getProperty("database.backpack_save_path"));

        }
        if (null != setting) {
            String sqlPath = (String) setting.getBackpackSqlFile();
            String batPath = (String) setting.getBackpackBatFile();
            String savePath = (String) setting.getBackpackToPath();
            System.out.println(sqlPath);
            System.out.println(batPath);
            String command = "cmd.exe /c " + batPath + " " + sqlPath + " " + savePath;
            System.out.println(command);

            String currentSavePath = "";
            try {
                Runtime javaRuntime = Runtime.getRuntime();
                Process pr = javaRuntime.exec(command);
                InputStream in = pr.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "GBK");
                BufferedReader br = new BufferedReader(isr);
                while (br.readLine() != null) {
                    String out = br.readLine();
                    if (out.contains("\\")) {
                        currentSavePath = out;
                    }
//                    System.out.println(out);
                }
                br.close();
                BackpackFile backpackFile = new BackpackFile(0, currentSavePath, new Date());
                boolean flag = backpackFailDao.addOne(backpackFile);
                System.out.println(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println("备份成功");
        }

    }

    @Override
    public boolean restore(String fileName) {

        boolean flag = false;
        if (null == setting || null != setting.getBackpackToPath()) {
            Resource resource = new ClassPathResource("properties/jdbc.properties");
            Properties props = null;
            try {
                props = PropertiesLoaderUtils.loadProperties(resource);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setting = new BackpackSetting(0, props.getProperty("detabase.restore_sql_path"), props.getProperty("database.restore_bat_path"), null);
            System.out.println(props.getProperty("detabase.restore_sql_path"));
            System.out.println(props.getProperty("database.restore_bat_path"));

        }
        String sqlPath = (String) setting.getBackpackSqlFile();
        String batPath = (String) setting.getBackpackBatFile();

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
            flag = true;
        } catch (Exception e) {
            flag = false;
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

    @Transactional
    @Override
    public boolean addOne(BackpackSetting object) {
        object.setBackpackSettingId(0);
        return backpackSettingDao.addOne(object);
    }

    @Transactional
    @Override
    public boolean updateOne(BackpackSetting object) {
        return backpackSettingDao.updateOne(object);
    }

    @Transactional
    @Override
    public boolean deleteOne(Serializable id) {
        return backpackSettingDao.deleteOneById(id);
    }

}
