/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.PatientService;
import com.qdu.service.StaffService;
import com.qdu.service.TitleService;
import com.vector.pojo.Patient;
import com.vector.pojo.Staff;
import com.vector.service.PatientSearchService;
import static com.vector.utils.MD5Utils.md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 刘福港
 */
@Controller
public class RegisterOrSignup {
    @Autowired
    private PatientService psi;
    @Autowired
    private PatientSearchService pss;
    @Autowired
    private StaffService ss;
    @Autowired
    private TitleService ts;
//    @Autowired
//    private 
    @RequestMapping(value = "/doctor/searchPassword/searchQuestion",method = POST)
    @ResponseBody
    public String getDoctorQuestion(String staffId,Model model){
        String question=ss.getQuestion(staffId);
        Staff s=ss.getStaffById(staffId);
        model.addAttribute("s",s);
        System.out.println("............................................");
        System.out.println(s.getStaffName());
        System.out.println(question);
        return question;
    }
    
    @RequestMapping(value = "/doctor/searchPassword/searchPassword",method = POST)
    @ResponseBody
    public String getDoctorPassword(String staffId,String answer){
        String password=ss.getPassword(staffId, answer);
        System.out.println("..........................................");
        System.out.println(password);
        if(password!=null){
            ss.getStaffById(staffId).setStaffPassword(md5("123456"));
            return "123456";
        }
        else
            return "问题与答案不匹配";
    }
    
    @RequestMapping(value="/patient/searchPassword/searchPasswordQuestion",method = POST)
    @ResponseBody
    public String getQuestion(String patientId,Model model){
        String s=psi.getQuestion(patientId);
        System.out.println(s);
        Patient p=pss.searchPatient(patientId);
        model.addAttribute("patient", p);
        
        return s;
    }
    @RequestMapping("/patient/searchPassword/searchPassword")
    @ResponseBody
    public String getPassword(String patientId,String answer){
        String sh=psi.getPassword(patientId, answer);
        System.out.println(sh);
        pss.searchPatient(patientId).setPatientPassword(md5("123456"));
        
        return "123456";
        
    }
//    @RequestMapping("/doctor/register")
//    public void getDepartment(Model model){
//        List<Department> list=departmentService.getDepartmentList();
//        model.addAttribute("department", list);
//    }
    @RequestMapping("/patient/signup/validate")
    public String validatePassword(String username,String password,Model model){
        Patient p=psi.validatePatient(username, md5(password));
        if(p!=null)
            return "patientIndex";
        else
            return "密码或用户名错误";
    }
    @RequestMapping(value = "patient/register/register",method = POST)
    public String insertPatient(Patient newPatient){
        newPatient.setPatientId(newPatient.getPatientEmail());
        newPatient.setPatientPassword(md5(newPatient.getPatientPassword()));
        psi.addPatient(newPatient);
        Patient p=pss.searchPatient(newPatient.getPatientId());
        if(p!=null)
            return "signup";
        else
            return "注册失败";
    }
    @RequestMapping(value = "doctor/register/register",method = GET)
    public String insertDoctor(Staff newstaff){
        
        newstaff.setTitle(ts.getTitle(newstaff.getTitleId()));
        newstaff.setStaffPassword(md5(newstaff.getStaffPassword()));
        ss.addStaff(newstaff);
        Staff s=ss.getStaffById(newstaff.getStaffId());
        if(s!=null)
            return "dsignup";
        else
            return "index";
    }
    @RequestMapping(value = "/doctor/signup/signup",method = POST)
    public String doctorSignUp(String username,String password){
        Staff s=ss.validateStaff(username, md5(password));
        if(s!=null)
            return "index";
        return "登录失败";
    }
}
