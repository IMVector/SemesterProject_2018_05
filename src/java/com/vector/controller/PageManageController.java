/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Staff;
import com.vector.service.HStaffService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vector
 */
@Controller
public class PageManageController {

    @Autowired
    private HStaffService staffService;

    @RequestMapping("/staffWithImage/{pageNum}")
    @ResponseBody
    public List<Staff> getStaffWithImage(@PathVariable int pageNum) {
        return staffService.getStaffWithImage(pageNum);
    }
}
