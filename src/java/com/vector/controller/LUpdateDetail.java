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
import com.vector.pojo.Title;
import static com.vector.utils.MD5Utils.md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LUpdateDetail {
    
    @Autowired
    private StaffService ss;
    @Autowired
    private PatientService ps;
    @Autowired
    private TitleService ts;
    @RequestMapping(value = "/staff/updateDetail",method = POST)
    public String updateStaffDetail(Staff staff,Model model,String titleName){
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(titleName);
        Title title=ts.getTitleByName(titleName);
        staff.setTitle(title);
        staff.setStaffPassword(staff.getStaffPassword());
        ss.updateStaff(staff);
        model.addAttribute("isSuccess", "更新成功!<a href=\"goBackToDoctorCenter\">返回</a>");
        return "staffDetail";
    }
    
    @RequestMapping(value = "/patient/updateDetail",method = POST)
    public String updatePatientDetail(Patient patient,Model model){
        
        
        patient.setPatientPassword(md5(patient.getPatientPassword()));
        ps.updatePatient(patient);
        model.addAttribute("isSuccess", "更新成功");
        return "patientDetail";
    }
    
}
