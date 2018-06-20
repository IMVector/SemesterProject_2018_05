/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.DepartmentService;
import com.qdu.service.PatientService;
import com.qdu.service.StaffService;
import com.qdu.service.TitleService;
import com.vector.pojo.Image;
import com.vector.pojo.Patient;
import com.vector.pojo.Staff;
import com.vector.service.HImageService;
import com.vector.service.PatientSearchService;
import static com.vector.utils.DateUtils.yearDateDiff;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
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
    @Autowired
    private SessionFactory session;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private HImageService imageService;

//    @Autowired
//    private 
    @RequestMapping(value = "/doctor/searchPassword/searchQuestion", method = POST)
    @ResponseBody
    public String getDoctorQuestion(String staffId, Model model) {
        String question = ss.getQuestion(staffId);
        Staff s = ss.getStaffById(staffId);
        model.addAttribute("s", s);
        System.out.println("............................................");
        System.out.println(s.getStaffName());
        System.out.println(question);
        return question;
    }

    @RequestMapping(value = "/doctor/searchPassword/searchPassword", method = POST)
    @ResponseBody
    public String getDoctorPassword(String staffId, String answer) {
        String password = ss.getPassword(staffId, answer);
        System.out.println("..........................................");
        System.out.println(password);
        if (password != null) {
            Staff s = ss.getStaffById(staffId);
            String newPassword = "123456";
            System.out.println(s.getStaffName());
            s.setStaffPassword(newPassword);
            System.out.println(ss.getStaffById(staffId).getStaffPassword());
            ss.updateStaff(s);
            return "123456";
        } else {
            return "问题与答案不匹配";
        }
    }

    @RequestMapping(value = "/patient/searchPassword/searchPasswordQuestion", method = POST)
    @ResponseBody
    public String getQuestion(String patientId, Model model) {
        String s = psi.getQuestion(patientId);
        System.out.println(s);
        Patient p = pss.searchPatient(patientId);
        model.addAttribute("patient", p);

        return s;
    }

    @RequestMapping("/patient/searchPassword/searchPassword")
    @ResponseBody
    public String getPassword(String patientId, String answer) {
        String sh = psi.getPassword(patientId, answer);
        System.out.println(sh);
        Patient pp = pss.searchPatient(patientId);
        pp.setPatientPassword("123456");
        psi.updatePatient(pp);
        return "123456";
    }

    @RequestMapping("/patient/signup/validate")
    public String validatePassword(String username, String password, HttpSession session) {
        Patient p = psi.validatePatient(username, password);
        session.setAttribute("patient", p);

        if (p != null) {
            return "personalCenter";
        } else {
            return "密码或用户名错误";
        }
    }

    @RequestMapping(value = "/patient/register/register", method = POST)
    public String insertPatient(Patient newPatient) throws ParseException {
        newPatient.setPatientId(newPatient.getPatientEmail());
        newPatient.setPatientPassword(newPatient.getPatientPassword());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int age = yearDateDiff(newPatient.getPatientBirthday(),
                sdf.format(new Date()));
        newPatient.setPatientAge(age);

        String path = newPatient.getPatientImagePath();
        if (!path.equals("")) {
            Image image = imageService.getImageByPath(path);
            newPatient.setImage(image);
        }

        psi.addPatient(newPatient);

        Patient p = pss.searchPatient(newPatient.getPatientId());

        if (p != null) {
            return "signup";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping(value = "/doctor/register/register", method = GET)
    public String insertDoctor(Staff newstaff) {

        newstaff.setTitle(ts.getTitle(newstaff.getTitleId()));
        newstaff.setStaffPassword(newstaff.getStaffPassword());

        newstaff.setDepartment(departmentService.getDepartmentById(newstaff.getDepartmentId()));
        System.out.println(newstaff.getDepartment().getDepartmentName());

        String path = newstaff.getStaffImagePath();
        if (!path.equals("")) {
            Image image = imageService.getImageByPath(path);
            newstaff.setImage(image);
        }

        ss.addStaff(newstaff);
        Staff s = ss.getStaffById(newstaff.getStaffId());
        if (s != null) {
            return "dsignup";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/doctor/signup/signup", method = POST)
    public String doctorSignUp(String username, String password, HttpSession session) {
        Staff s = ss.validateStaff(username, password);

        session.setAttribute("staffDetail", s);
        if (s != null) {
            return "doctorCenter";
        }
        return "登录失败";
    }
}
