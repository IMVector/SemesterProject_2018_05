/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.Prescription;
import com.vector.service.BillService;
import com.vector.service.CheckRecordService;
import com.vector.service.MedicalRecordService;
import com.vector.service.PatientSearchService;
import com.vector.service.PrescriptionService;
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

    @Autowired
    private CheckRecordService checkRecordService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/medicalRecordDetails/{MdeicalRecordId}", method = RequestMethod.GET)
    public String showMdeicalRecordDetails(@PathVariable int MdeicalRecordId, Model model) {
        MedicalRecord medicalRecord = medicalRecordService.getOneById(MdeicalRecordId);
        model.addAttribute("medicalRecord", medicalRecord);
        return "medicalRecordDetails";
    }

    @RequestMapping(value = "/medicalRecordList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showMdeicalRecordList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<MedicalRecord> list = medicalRecordService.getAllListOfSomeone(patientId, currentPage);

        return list;
    }

    @RequestMapping(value = "/medicalRecordListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showMdeicalRecordListItemNumber(@PathVariable String patientId) {
        return medicalRecordService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/checkRecordList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showCheckRecordList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<CheckRecord> list = checkRecordService.getAllListOfSomeone(patientId, currentPage);
        return list;
    }

    @RequestMapping(value = "/checkRecordListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showCheckRecordListItemNumber(@PathVariable String patientId) {
        return checkRecordService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/checkRecordDetails/{checkRecordId}", method = RequestMethod.GET)
    public String showCheckRecordDetails(@PathVariable int checkRecordId, Model model) {
        CheckRecord checkRecord = checkRecordService.getOneById(checkRecordId);
        model.addAttribute("checkRecord", checkRecord);
        return "checkRecordDetails";
    }

    @RequestMapping(value = "/prescriptionList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showPrescriptionList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<Prescription> list = prescriptionService.getAllListOfSomeone(patientId, currentPage);
        return list;
    }

    @RequestMapping(value = "/prescriptionListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showPrescriptionListItemNumber(@PathVariable String patientId) {
        return prescriptionService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/prescriptionDetails/{prescriptionId}", method = RequestMethod.GET)
    public String showPrescriptionDetails(@PathVariable int prescriptionId, Model model) {
        Prescription prescription = prescriptionService.getOneById(prescriptionId);
        model.addAttribute("prescription", prescription);
        return "prescriptionDetails";
    }

    @RequestMapping(value = "/graphy_times/{patientId}/{year}", method = RequestMethod.POST)
    @ResponseBody
    public int[] getMedicalOfPatientByYear(@PathVariable String patientId, @PathVariable int year, Model model) {
        return medicalRecordService.getMedicalVisitsNum(patientId, year);

    }

    @RequestMapping(value = "/billList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showBillList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<Bill> list = billService.getAllListOfSomeone(patientId, currentPage);
        return list;
    }

    @RequestMapping(value = "/billListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showBillListItemNumber(@PathVariable String patientId) {
        return billService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/billDetails/{billId}", method = RequestMethod.GET)
    public String showBillDetails(@PathVariable int billId, Model model) {
        Bill bill = billService.getOneById(billId);
        model.addAttribute("bill", bill);
        return "billDetails";
    }

    @RequestMapping(value = "/graphy_fee/{patientId}/{year}", method = RequestMethod.POST)
    @ResponseBody
    public double[] getMedicalFeeOfPatientByYear(@PathVariable String patientId, @PathVariable int year, Model model) {
        return billService.getMedicalVisitsFee(patientId, year);

    }

}
