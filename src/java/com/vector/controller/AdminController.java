/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.BackpackFile;
import com.vector.pojo.BackpackSetting;
import com.vector.pojo.Department;
import com.vector.pojo.Image;
import com.vector.pojo.Medication;
import com.vector.pojo.Staff;
import com.vector.pojo.Title;
import com.vector.service.BackpackFileService;
import com.vector.service.DatabaseFileOperation;
import com.vector.service.HDepartmentService;
import com.vector.service.HImageService;
import com.vector.service.HStaffService;
import com.vector.service.HTitleService;
import com.vector.service.MedicationService;
import java.text.SimpleDateFormat;
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

    @Autowired
    private HDepartmentService departmentService;

    @Autowired
    private HTitleService titleService;

    @Autowired
    private HStaffService staffService;

    @Autowired
    private HImageService imageService;

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
        return medicationService.getAllList(currentPage);
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
        return medicationService.deleteOne(medicationId);
    }

    @RequestMapping(value = "/getMedicationByName/{name}", method = RequestMethod.POST)
    @ResponseBody
    public List<Medication> getMedicationByName(@PathVariable String name) {
        return medicationService.getOneByName(name);
    }
////////////////////////////////////部门管理/////////////////////////////////////////////////////

    @RequestMapping(value = "/departmentList", method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getDepartmentList() {
        return departmentService.getAllList();
    }

    @RequestMapping(value = "/departmentList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getDepartmentList(@PathVariable int currentPage) {
        return departmentService.getAllList(currentPage);
    }

    @RequestMapping(value = "/departmentListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getDepartmentListItemNum() {
        return departmentService.getListItemNumber();
    }

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    @ResponseBody
    public boolean adddePartment(Department departmetn) {
        return departmentService.addOne(departmetn);
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateDepartment(Department department) {
        return departmentService.updateOne(department);
    }

    @RequestMapping(value = "/deleteDepartment/{departmentId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteDepartment(@PathVariable int departmentId) {
        return departmentService.deleteOne(departmentId);
    }

    @RequestMapping(value = "/getDepartmentByName/{name}", method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getDepartmentByName(@PathVariable String name) {
        return departmentService.getOneByName(name);
    }

    /////////////////////////////////职称管理///////////////////////////////////////////////////////
    @RequestMapping(value = "/titleList", method = RequestMethod.POST)
    @ResponseBody
    public List<Title> getTitleList() {
        return titleService.getTitleList();
    }

    @RequestMapping(value = "/titleList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Title> getTitleList(@PathVariable int currentPage) {
        return titleService.getAllList(currentPage);
    }

    @RequestMapping(value = "/titleListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getTitleListItemNum() {
        return titleService.getListItemNumber();
    }

    @RequestMapping(value = "/addTitle", method = RequestMethod.POST)
    @ResponseBody
    public boolean addTitle(Title title) {
        return titleService.addOne(title);
    }

    @RequestMapping(value = "/updateTitle", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateTitle(Title title) {
        return titleService.updateOne(title);
    }

    @RequestMapping(value = "/deleteTitle/{titleId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteTitle(@PathVariable int titleId) {
        return titleService.deleteOne(titleId);
    }

    @RequestMapping(value = "/getTitleByName/{name}", method = RequestMethod.POST)
    @ResponseBody
    public List<Title> getTitleByName(@PathVariable String name) {
        return titleService.getOneByName(name);
    }

    ////////////////////////////////////职工管理////////////////////////////////////////////////////
    @RequestMapping(value = "/staffList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Staff> getStaffList(@PathVariable int currentPage) {
        List<Staff> list = staffService.getAllList(currentPage);
        return list;
    }

    @RequestMapping(value = "/staffListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getStaffListItemNum() {
        return staffService.getListItemNumber();
    }

    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    @ResponseBody
    public boolean addStaff(Staff staff) {
        return staffService.addOne(staff);
    }

    @RequestMapping(value = "/updateStaff", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateStaff(Staff staff) {
        return staffService.updateOne(staff);
    }

    @RequestMapping(value = "/deleteStaff/{staffId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteStaff(@PathVariable String staffId) {//外键约束在此抛出异常
        try {
            return staffService.deleteOne(staffId);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/getStaffByName/{name}/{page}", method = RequestMethod.POST)
    @ResponseBody
    public List<Staff> getStaffByName(@PathVariable String name, @PathVariable int page) {
        return staffService.getStaffByName(name, page);
    }

    @RequestMapping(value = "/getStaffByNameItemNum/{name}", method = RequestMethod.POST)
    @ResponseBody
    public int getStaffByNameItemNum(@PathVariable String name) {
        return 0;
    }

    @RequestMapping(value = "/getStaffByTitle/{titleName}/{page}", method = RequestMethod.POST)
    @ResponseBody
    public List<Staff> getStaffBytitle(@PathVariable String titleName, @PathVariable int page) {
        return staffService.getStaffByTitle(titleName, page);
    }

    @RequestMapping(value = "/getStaffBytitleItemNum/{titleName}", method = RequestMethod.POST)
    @ResponseBody
    public int getStaffByTitleItemNum(@PathVariable String titleName) {
        return 0;
    }

    ///////////////////////////////////图像管理/////////////////////////////////////////////////////
    @RequestMapping(value = "/imageList/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Image> getImageList(@PathVariable int currentPage) {
        return imageService.getAllList(currentPage);
    }

    @RequestMapping(value = "/imageListItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getImageListItemNum() {
        return imageService.getListItemNumber();
    }

    @RequestMapping(value = "/updateImage", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateImage(Image image) {
        return imageService.updateOne(image);
    }

    @RequestMapping(value = "/deleteImage/{departmentId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteImage(@PathVariable int imageId) {
        return imageService.deleteOne(imageId);
    }

    /////////////////////////////////////////////////////////////////////////////////
}
