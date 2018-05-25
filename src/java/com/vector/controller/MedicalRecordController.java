/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.service.PatientSearchService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NIIT
 */
@Controller
public class MedicalRecordController {

    @Autowired
    private PatientSearchService patientSearchService;

    @RequestMapping("/medicalRecordDetails/{MdeicalRecordId}")
    public String showMdeicalRecordDetails(@PathParam("MdeicalRecordId") int MdeicalRecordId) {

        return "medicalRecordDetails";
    }

    @RequestMapping("/medicalRecordList/{patientId}")
    public String showMdeicalRecordList(@PathParam("patientId") String patientId) {
        patientSearchService.searchMedicalRecordsList(patientId);
        return "medicalRecordDetails";
    }
}
