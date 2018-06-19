/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.BloodBankService;
import com.qdu.service.DepartmentService;
import com.qdu.service.LCheckItemService;
import com.qdu.service.LMedicalRecordService;
import com.qdu.service.TitleService;
import com.qdu.service.impl.LMedicalRecordServcieImpl;
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
    @Autowired
    private BloodBankService bloodService;
    @Autowired
    private LCheckItemService checkService;
    @Autowired
    private LMedicalRecordService recordService;
    @Autowired
    LMedicalRecordService l;

    @RequestMapping({"/index", "/"})
    public String index() {
        return "mainIndex";
    }

    @RequestMapping({"/hhhhhh"})
    public String indexhh() {
        return "hhhhhh";
    }

    @RequestMapping({"/doctor/doctorCenter"})
    public String intoDoctorCenter() {
        return "doctorCenter";
    }

    @RequestMapping({"/getStaffDetail"})
    public String getDetail() {
        return "staffDetail";
    }

    @RequestMapping({"/goBackToDoctorCenter"})
    public String goDoctorCenter() {
        return "doctorCenter";
    }

    @RequestMapping({"/bloodBank"})
    public String bloodBank(Model model) {
        model.addAttribute("bloodType", bloodService.getBloodBankList());
        return "bloodBank";
    }

//    @RequestMapping({"/test"})
//    public String test() {
//        l.addMedicalRecord();
//        return "diagnosis";
//    }
    @RequestMapping({"patient/signup"})
    public String signupIndex() {
        return "signup";
    }

    @RequestMapping({"/physicalTest"})
    public String physicalTestIndex(Model model) {
        model.addAttribute("checkList", checkService.getCheckItemList());
        return "physicalTest";
    }

    @RequestMapping(value = "/patient/getMedicalRecord")
    public String patientMedicalRecord(String patientId, Model model) {
        if (model.addAttribute("record", recordService.getRecordById(patientId)) != null) {
            return "LPatientMedicalRecord";
        } else {
            return "记录为空";
        }
    }

    @RequestMapping({"patient/searchPassword"})
    public String searchPasswordIndex() {
        return "searchPassword";
    }

    @RequestMapping({"/diagnosis"})
    public String diagnosisIndex(HttpSession session) {
        session.setAttribute("true", "true");
        return "diagnosis";
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
        List<Department> list = departmentService.getDepartmentList();
        List<Title> titleList = titleService.getAllTitle();
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

        if (null != session.getAttribute("patient")) {
            return "personalCenter";
        } else {
            return "signup";
        }
    }

    @RequestMapping("/medicalRecord")
    public String medicalRecord() {
        return "medicalRecord";
    }

    @RequestMapping("/billReport")
    public String billReport() {
        return "billReport";
    }

    @RequestMapping(value = "/admin/{page}", method = RequestMethod.GET)
    public String changePage(@PathVariable String page) {
        System.out.println(page);
        return page;
    }

    @RequestMapping(value = "/about/{departmentName}", method = RequestMethod.GET)
    public String aboutPage(@PathVariable String departmentName, Model model) {
        model.addAttribute("departmentName", departmentName);
        return "about";
    }

    @RequestMapping(value = "updateDetail", method = RequestMethod.GET)

    public String gotoUpdatePatientInfo() {
        return "patientDetail";
    }

}
