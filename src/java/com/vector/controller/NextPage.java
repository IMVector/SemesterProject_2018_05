/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.DepartmentService;
import com.qdu.service.TitleService;
import com.vector.pojo.Department;
import com.vector.pojo.Patient;
import com.vector.pojo.Title;
import com.vector.service.PatientSearchService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Vector
 */
@Controller
public class NextPage {

    @Autowired
    private PatientSearchService patientSearchService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TitleService titleService;

    @RequestMapping({"/index", "/"})
    public String index() {
        return "mainIndex";
    }
    
    @RequestMapping({"patient/signup"})
    public String signupIndex() {
        return "signup";
    }
    
    @RequestMapping({"patient/searchPassword"})
    public String searchPasswordIndex() {
        return "searchPassword";
    }
    
    @RequestMapping({"patient/register"})
    public String registerIndex() {
        return "register";
    }
    
     @RequestMapping({"doctor/signup"})
    public String signupDoctorIndex() {
        return "dsignup";
    }
    
    @RequestMapping({"doctor/searchPassword"})
    public String searchPasswordDoctorIndex() {
        return "dsearchPassword";
    }
    
    @RequestMapping({"doctor/register"})
    public String registerDoctorIndex(Model model) {
        List<Department> list=departmentService.getDepartmentList();
        List<Title> titleList=titleService.getAllTitle();
        model.addAttribute("department", list);
        model.addAttribute("title", titleList);
        return "dregister";
    }

    @RequestMapping("/patientIndex")
    public String patientIndex() {
        return "patientIndex";
    }

    @RequestMapping("/staffIndex")
    public String staffIndex() {
        return "staffIndex";
    }

    @RequestMapping("/adminIndex")
    public String adminIndex() {
        return "adminIndex";
    }

    @RequestMapping("/personalCenter")
    public String personalCenter(HttpSession session) {

        Patient p = patientSearchService.searchPatient("p001");
        session.setAttribute("patient", p);
        return "personalCenter";
    }

    @RequestMapping("/medicalRecord")
    public String medicalRecord() {
        return "medicalRecord";
    }

    @RequestMapping("/billReport")
    public String billReport() {
        return "billReport";
    }

    @RequestMapping(value="/admin/{page}",method=RequestMethod.GET)
    public String changePage(@PathVariable String page) {
        System.out.println(page);
        return page;
    }
    
    
    
    
    
}
