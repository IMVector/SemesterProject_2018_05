/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.MedicalRecord;
import com.vector.service.PatientSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NIIT
 */
@Controller
public class MedicalRecordController {
// produces = "text/html;charset=utf-8"
    @Autowired
    private PatientSearchService patientSearchService;

    @RequestMapping("/medicalRecordDetails/{MdeicalRecordId}")
    public String showMdeicalRecordDetails(@PathVariable int MdeicalRecordId) {

        return "medicalRecordDetails";
    }

    @RequestMapping(value = "/medicalRecordList/{patientId}",method = RequestMethod.POST)
    @ResponseBody
    public List showMdeicalRecordList(@PathVariable String patientId) {
        List<MedicalRecord> list = patientSearchService.searchMedicalRecordsList(patientId);
        System.out.println(list.get(0).getInDiagnosis());
        return list;
    }
}
