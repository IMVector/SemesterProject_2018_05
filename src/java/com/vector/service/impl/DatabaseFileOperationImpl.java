/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.pojo.BackpackSetting;
import com.vector.service.DatabaseFileOperation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vector
 */
@Service
public class DatabaseFileOperationImpl implements DatabaseFileOperation {

    @Scheduled(cron = "0/10 * * * * ? ")
    @Override
    public void backpack() {
        try {
            Runtime javaRuntime = Runtime.getRuntime();
            Process pr = javaRuntime.exec("cmd.exe /C F:\\*.bat");
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
    }
    
    private BackpackSetting setting;

    @Override
    public void restore(String fileName) {
    }

    @Override
    public List<BackpackSetting> getSettings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFilePath(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBackpackPath(BackpackSetting setting) {
        this.setting = setting;
    }

}
