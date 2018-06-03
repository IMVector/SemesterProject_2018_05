/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.BackpackFile;
import com.vector.pojo.BackpackSetting;
import com.vector.service.BackpackFileService;
import com.vector.service.DatabaseFileOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vector
 */
@Controller
public class AdminController {

    @Autowired
    private DatabaseFileOperation databaseSettingService;

    @Autowired
    private BackpackFileService backpackFileService;

    @RequestMapping(value = "/backpackSettingList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<BackpackSetting> getDatabaseSetting(@PathVariable int currentPage) {

        return databaseSettingService.getAllList(currentPage);

    }

    @RequestMapping(value = "/backpackSettingListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getDatabaseSettingIntemNum() {

        return databaseSettingService.getListItemNumber();

    }

    @RequestMapping(value = "/setSettting/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void setSettting(@PathVariable int id) {
        BackpackSetting backpackSetting = databaseSettingService.getBackpackSettingById(id);
        databaseSettingService.setSettingPath(backpackSetting);
    }

    @RequestMapping(value = "/databaseBackpackFileList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<BackpackFile> getDatabaseBackpackFileList(@PathVariable int currentPage) {
        return backpackFileService.getAllList(currentPage);
    }

    @RequestMapping(value = "/backpackFileListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getBackpackFileListIntemNum() {

        return backpackFileService.getListItemNumber();
    }

    @RequestMapping(value = "/restore/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean restore(@PathVariable int id) {
        BackpackFile backpackFile = backpackFileService.getBackpackFileById(id);
        return databaseSettingService.restore(backpackFile.getBackpackFilePath());
    }

}
