/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Bill;
import com.vector.pojo.CheckRecord;
import com.vector.pojo.DietAdvice;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.PrecautionAdvice;
import com.vector.pojo.Prescription;
import com.vector.service.BillService;
import com.vector.service.CheckRecordService;
import com.vector.service.DietAdviceService;
import com.vector.service.HealthAdviceService;
import com.vector.service.MedicalRecordService;
import com.vector.service.PatientSearchService;
import com.vector.service.PrescriptionService;
import com.vector.service.WeatherService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HealthAdviceService healthAdviceService;

    @Autowired
    private DietAdviceService dietAdviceService;

    @Autowired
    private WeatherService weatherService;

    //////////////////////////////////////////病例报告//////////////////////////////////////////////
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

    /////////////////////////////////////检查记录以及检查结果报告///////////////////////////////////////////////////
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

    ///////////////////////////////////////处方报告/////////////////////////////////////////////////
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
    ///////////////////////////////////账单报告/////////////////////////////////////////////////////

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
    //////////////////////////////////健康内容可视化//////////////////////////////////////////////////////

    @RequestMapping(value = "/graphy_times/{patientId}/{year}", method = RequestMethod.POST)
    @ResponseBody
    public int[] getMedicalOfPatientByYear(@PathVariable String patientId, @PathVariable int year, Model model) {
        return medicalRecordService.getMedicalVisitsNum(patientId, year);

    }

    @RequestMapping(value = "/graphy_fee/{patientId}/{year}", method = RequestMethod.POST)
    @ResponseBody
    public double[] getMedicalFeeOfPatientByYear(@PathVariable String patientId, @PathVariable int year, Model model) {
        return billService.getMedicalVisitsFee(patientId, year);

    }

    @RequestMapping(value = "/medicalRecordYearSet/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public Set getMedicalRecordYearSetOfSomeone(@PathVariable String patientId) {
        return medicalRecordService.getMedicalYear(patientId);
    }

    @RequestMapping(value = "/illnessInfo/{patientId}/{year}", method = RequestMethod.POST)
    @ResponseBody
    public Map getIllnessInfo(@PathVariable String patientId, @PathVariable int year) {
        return medicalRecordService.getIllnessInfo(patientId, year);
    }

    /////////////////////////////////健康建议///////////////////////////////////////////////////////
    @RequestMapping(value = "/healthAdviceList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showHealthAdviceList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<PrecautionAdvice> list = healthAdviceService.getAllListOfSomeone(patientId, currentPage);
        return list;
    }

    @RequestMapping(value = "/healAdviceListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showhealthAdviceListItemNumber(@PathVariable String patientId) {
        return healthAdviceService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/healthAdviceDetails/{healthAdviceId}", method = RequestMethod.GET)
    public String showHealthAdviceDetails(@PathVariable int healthAdviceId, Model model) {
        PrecautionAdvice precautionAdvice = healthAdviceService.getOneById(healthAdviceId);
        model.addAttribute("precautionAdvice", precautionAdvice);
        return "healthAdviceDetails";
    }
    /////////////////////////////////饮食建议///////////////////////////////////////////////////////

    @RequestMapping(value = "/dietAdviceList/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List showDietAdviceList(@PathVariable String patientId, @PathVariable int currentPage) {
        List<DietAdvice> list = dietAdviceService.getAllListOfSomeone(patientId, currentPage);
        return list;
    }

    @RequestMapping(value = "/dietAdviceListItemNumber/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showDietAdviceListItemNumber(@PathVariable String patientId) {
        return dietAdviceService.getListItemNumber(patientId);
    }

    @RequestMapping(value = "/dietAdviceDetails/{dietAdviceId}", method = RequestMethod.GET)
    public String showDietAdviceDetails(@PathVariable int dietAdviceId, Model model) {
        DietAdvice dietAdvice = dietAdviceService.getOneById(dietAdviceId);
        model.addAttribute("dietAdvice", dietAdvice);
        return "dietAdviceDetails";
    }

    //////////////////////////////////////未检查的内容//////////////////////////////////////////////////////////
    @RequestMapping(value = "getCheckRecordWithNoCheck/{patientId}/{currentPage}", method = RequestMethod.POST)
    @ResponseBody
    public List<CheckRecord> getCheckRecordWithNoCheck(@PathVariable String patientId, @PathVariable int currentPage) {
        return checkRecordService.getCheckRecordWithNoCheck(patientId, currentPage);
    }

    @RequestMapping(value = "/checkRecordItemNumberWithNoCheck/{patientId}", method = RequestMethod.POST)
    @ResponseBody
    public int showCheckRecordItemNumberWithNoCheck(@PathVariable String patientId) {
        return checkRecordService.getListItemNumWithNoCheck(patientId);
    }

    @RequestMapping(value = "/checkRecordDetailsWithNoCheck/{checkRecordId}", method = RequestMethod.GET)
    public String showCheckRecordDetailsWithNoCheck(@PathVariable int checkRecordId, Model model) {
        CheckRecord checkRecord = checkRecordService.getOneById(checkRecordId);
        model.addAttribute("checkRecord", checkRecord);
        return "checkRecordDetailsWithNoCheck";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "weather", method = RequestMethod.POST)
    @ResponseBody
    public String showHospitalitalInfo(HttpServletRequest request) {
//        String city = weatherService.getCity(request);
//        System.out.println("controller   "+city);
//        //String city = "青岛";
//        String weather = weatherService.getWeather(city);
//        System.out.println(weather);
//        return weather;
        return "{\"date\":\"06月14日\",\"temperature\":\"19℃\",\"weather\":\"多云\",\"week\":\"今天星期四\",\"windDirection\":\"南风\",\"windPower\":\"3~4级\"}";
//        return "{\"date\":\"06月09日\",\"temperature\":\"22℃\",\"temperature_\":\"18℃\",\"weather\":\"阵雨\",\"weather_\":\"阵雨\",\"week\":\"今天星期六\",\"windDirection\":\"东南风\",\"windDirection_\":\"东南风\",\"windPower\":\"3~4级\",\"windPower_\":\"3~4级\"}";
    }

}
