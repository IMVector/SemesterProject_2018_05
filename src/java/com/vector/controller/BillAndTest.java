/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.CheckResultService;
import com.qdu.service.LBillService;
import com.qdu.service.LCheckItemService;
import com.qdu.service.LCheckRecordService;
import com.qdu.service.LMedicalRecordService;
import com.qdu.service.StaffService;
import com.vector.service.PatientSearchService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 刘福港
 */
@Controller
public class BillAndTest {
    @Autowired
    private LCheckItemService checkService;
    @Autowired
    private LCheckRecordService recordService;
    @Autowired
    private PatientSearchService searchService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private LMedicalRecordService mrecordService;
    @Autowired
    private LBillService billService;
    @Autowired
    private CheckResultService service;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
    }
    
    @RequestMapping(value = "/patient/physicalTest",method = POST)
    
    public String insertCheckRecord(String LcheckResult,String LpatientId,String LisChecked,String LpaymentStatus,String LcheckItem,Date LcheckDate){
//        Patient p=searchService.searchPatient("p001");
//        
//        CheckItem c=checkService.getCheckItemById(Integer.parseInt(LcheckItem));
//        Staff staff=staffService.getStaffById("999");
//        MedicalRecord medicalRecord=mrecordService.getLatestMedicalRecord("p001");
//        System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000");
//        System.out.println(medicalRecord.getDoctorName());
//        Bill bill=new Bill(0, p, LpaymentStatus, LcheckDate);
//        Bill bill1=billService.getBillById("p001");
//        CheckResult cc=new CheckResult(c, medicalRecord, p, staff, LcheckDate, LcheckResult);
//        service.insertCheckResult(cc);
////        System.out.println("6666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
////        System.out.println(r.getCheckResultDescription());
////        System.out.println(r.getCheckResultId());
////        CheckResult hh=recordService.getCheckResult("p001");
//        CheckRecord cr=new CheckRecord(0, bill1, c, cc, p, LpaymentStatus, LcheckDate, Integer.SIZE);
//        recordService.insertCheckRecord(cr);
        return "physicalTestInsert";
    }
}
