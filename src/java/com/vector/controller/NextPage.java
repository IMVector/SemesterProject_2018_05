/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vector
 */
@Controller
public class NextPage {

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
    public String personalCenter() {
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
