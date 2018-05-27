/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Patient;
import com.vector.service.PatientSearchService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vector
 */
@Controller
public class NextPage {

    @Autowired
    private PatientSearchService patientSearchService;

    @RequestMapping({"/index", "/"})
    public String index() {
        return "mainIndex";
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
}
