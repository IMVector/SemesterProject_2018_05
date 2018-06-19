/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Staff;
import com.vector.service.HStaffService;
import java.io.Serializable;
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
public class PageManageController {

    @Autowired
    private HStaffService staffService;

    @RequestMapping(value = "/staffWithImage/{pageNum}")
    @ResponseBody
    public List<Staff> getStaffWithImage(@PathVariable int pageNum) {
        return staffService.getStaffWithImage(pageNum);
    }

    @RequestMapping(value = "/getStaffWithImageItemNum", method = RequestMethod.POST)
    @ResponseBody
    public int getStaffWithImageItemNum() {
        return staffService.getStaffNumWithImage();
    }

    @RequestMapping(value = "/getStaffByDepartment/{departmentName}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<Staff> getStaffByDepartmentName(@PathVariable String departmentName, @PathVariable int currentPage) {
        return staffService.getStaffByDepartmentName(departmentName, currentPage);
    }

    @RequestMapping(value = "/getStaffByDepartmentItemNum/{departmentName}", method = RequestMethod.POST)
    @ResponseBody
    public int getStaffByDepartmentNameItemNum(@PathVariable String departmentName) {
        return staffService.getStaffByDepartmentNameItemNum(departmentName);
    }

}
