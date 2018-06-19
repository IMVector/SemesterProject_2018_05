/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.LDietAdviceService;
import com.qdu.service.LMedicalRecordService;
import com.qdu.service.LPrescriptionService;
import com.qdu.service.MedicalHistoryService;
import com.qdu.service.StaffService;
import com.vector.pojo.DietAdvice;
import com.vector.pojo.MedicalRecord;
import com.vector.pojo.MedicationHistory;
import com.vector.pojo.Patient;
import com.vector.pojo.Prescription;
import com.vector.pojo.Staff;

import com.vector.service.PatientSearchService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 刘福港
 */
@Controller
public class DiagnosisController {

    @Autowired
    private PatientSearchService patientSearch;
    @Autowired
    private LDietAdviceService dietService;
    @Autowired
    private MedicalHistoryService medicalService;
    @Autowired
    private LPrescriptionService prescriptionService;
    @Autowired
    private StaffService ss;
    @Autowired
    private LMedicalRecordService l;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
    }

    @RequestMapping(value = "/diagnosis/getPatient", method = RequestMethod.POST)
    @ResponseBody
    public Patient getPatientById(String patientId, HttpSession session) {
        System.out.println("...............................!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Patient p = patientSearch.searchPatient(patientId);
        session.setAttribute("Lpatient", p);
        System.out.println("......................................................................................................");
        System.out.println(p.getPatientId());
        Patient patient = p;
        patient.setImage(null);
        patient.setBills(null);
        patient.setCheckRecords(null);
        patient.setCheckResults(null);
        patient.setDietAdvices(null);
        patient.setMedicalRecords(null);
        patient.setMedicationHistories(null);
        patient.setPrecautionAdvices(null);
        patient.setPrescriptions(null);
        l.addMedicalRecord(patient);

//            private Set<DietAdvice> dietAdvices = new HashSet<DietAdvice>(0);
//    private Set<Bill> bills = new HashSet<Bill>(0);
//    private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>(0);
//    private Set<CheckResult> checkResults = new HashSet<CheckResult>(0);
//    private Set<PrecautionAdvice> precautionAdvices = new HashSet<PrecautionAdvice>(0);
//    private Set<Prescription> prescriptions = new HashSet<Prescription>(0);
//    private Set<CheckRecord> checkRecords = new HashSet<CheckRecord>(0);
//    private Set<MedicationHistory> medicationHistories = new HashSet<MedicationHistory>(0);
        return patient;
    }

    @RequestMapping(value = "/diagnosis/getDietAdvice")
    public String getDietAdviceByPatientId(String patientId, Model model) {
        DietAdvice da = dietService.getAdviceByPatientId(patientId);
        if (da != null) {
            model.addAttribute("dietAdvice", dietService.getAdviceByPatientId(patientId));
            model.addAttribute("isTrue", "true");
            return "patientDietAdvice";
        } else {
            model.addAttribute("dietAdvice", dietService.getAdviceByPatientId(patientId));
            model.addAttribute("isTrue", "false");
            return "patientDietAdvice";
        }

    }

    @RequestMapping(value = "/diagnosis/getMedicalHistory")
    public String getMedicationHistoryByPatientId(String patientId, Model model) {
        MedicationHistory mh = medicalService.getMedicalHistoryByPatientId(patientId);
        model.addAttribute("mh", mh);
        if (mh != null) {
            model.addAttribute("isTrue", "true");
        } else {
            model.addAttribute("isTrue", "false");
        }
        return "patientMedicalHistory";
    }

    @RequestMapping(value = "/diagnosis/getPrescription")
    public String getPrescriptionByPatientId(String patientId, Model model) {
        Prescription p = prescriptionService.getPrescriptionById(patientId);
        model.addAttribute("prescription", p);
        if (p != null) {
            model.addAttribute("isTrue", "true");
        } else {
            model.addAttribute("isTrue", "false");
        }
        return "patientPrescription";
    }

    @RequestMapping(value = "/patient/prescription/insert", method = RequestMethod.GET)
    @ResponseBody
    public String insertPrescription(String prescriptionPrecautions, String patientId, String prescriptionContent, Date prescriptionDate) {
        System.out.println(patientId);
        System.out.println(prescriptionPrecautions);
        System.out.println(prescriptionContent);
        System.out.println(prescriptionDate);
        Patient patient = patientSearch.searchPatient(patientId);
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println(patientId);
        MedicalRecord medicalRecord = l.getLatestMedicalRecord("p001");
        System.out.println(medicalRecord.getDoctorName()+"1111111111111111111111111111111111111111111111111");
        try {
//            if (medicalRecord!=null ) {
                Prescription p = new Prescription(0, patient, medicalRecord, prescriptionContent, prescriptionDate, prescriptionPrecautions);
                prescriptionService.insertPrescription(p);
//            } else {
//                MedicalRecord mr = new MedicalRecord(0, patient, prescriptionDate);
//                Prescription p = new Prescription(0, patient, mr, prescriptionContent, prescriptionDate, prescriptionPrecautions);
//                prescriptionService.insertPrescription(p);
//            }
        } catch (Exception e) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }

        return "success";
    }

    @RequestMapping(value = "/patient/insertDietAdvice", method = RequestMethod.POST)
    @ResponseBody
    public String updateDietAdvice(String dietAdviceContent, String patientId, String staffId, Date time) {
        System.out.println(".................................................................................................................................................................................................................");
        System.out.println(patientId);
        System.out.println("9999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(staffId);
        
        System.out.println(patientId);
        Staff s = ss.getStaffById(staffId);
//        da.setStaff(s);
        Patient p = patientSearch.searchPatient("p001");
//        da.setPatient(p);
        System.out.println("...................................................................");
        DietAdvice da = new DietAdvice(p, s, dietAdviceContent, time);
//        System.out.println(da.getDietAdviceId());
//        System.out.println(da.getDietAdviceContent());
        dietService.insertDietAdvice(da);

        return "插入成功";
    }

}
