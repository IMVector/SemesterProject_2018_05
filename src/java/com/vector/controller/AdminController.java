/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.BackpackFile;
import com.vector.pojo.BackpackSetting;
import com.vector.pojo.Medication;
import com.vector.service.BackpackFileService;
import com.vector.service.DatabaseFileOperation;
import com.vector.service.MedicationService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private MedicationService medicationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
    }

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

    @RequestMapping(value = "/deleteRestore/{id}", method = RequestMethod.POST)
    @ResponseBody
    public int restoreDelete(@PathVariable int id) {

        if (backpackFileService.deleteOne(id)) {
            return id;
        } else {
            return -1;
        }
    }
//////////////////////////////////////药品增删改查/////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/addMedication", method = RequestMethod.POST)
    @ResponseBody
    public boolean addMedication(Medication medication) {
        return medicationService.addOne(medication);
    }

    @RequestMapping(value = "/medicationList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Medication> getMedicationList(@PathVariable int currentPage) {
        return medicationService.getListOfAllWithPagination(currentPage);
    }

    @RequestMapping(value = "/medicationListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getMedicationListItemNum() {
        return medicationService.getListItemNumber();
    }

    @RequestMapping(value = "/updateMedication", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateMedication(Medication medication) {
        return medicationService.updateOne(medication);
    }

    @RequestMapping(value = "/deleteMedication/{medicationId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteMedication(@PathVariable int medicationId) {
        return medicationService.deleteOneById(medicationId);
    }

    @RequestMapping(value = "/getMedicationByName/{name}", method = RequestMethod.POST)
    @ResponseBody
    public List<Medication> getMedicationByName(@PathVariable String name) {
        List<Medication> list=new ArrayList();
        list.add(medicationService.getMedicationByName(name));
        return list;
    }
/////////////////////////////////////////////////////////////////////////////////////////
}
