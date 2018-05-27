/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.MedicalRecord;
import com.vector.service.MedicalRecordService;
import com.vector.service.PatientSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NIIT
 */
@Controller
public class PatientController {
// produces = "text/html;charset=utf-8"

    @Autowired
    private PatientSearchService patientSearchService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @RequestMapping(value="/medicalRecordDetails/{MdeicalRecordId}",method =RequestMethod.GET )
    public String showMdeicalRecordDetails(@PathVariable int MdeicalRecordId, Model model) {
        System.out.println(MdeicalRecordId);
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordById(MdeicalRecordId);
        model.addAttribute("medicalRecord", medicalRecord);
        return "medicalRecordDetails";
    }

    @RequestMapping(value = "/medicalRecordList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showMdeicalRecordList(@PathVariable String patientId,@PathVariable int currentPage) {
        List<MedicalRecord> list = medicalRecordService.getMedicalRecordOfPatient(patientId, currentPage);
        return list;
    }
}
