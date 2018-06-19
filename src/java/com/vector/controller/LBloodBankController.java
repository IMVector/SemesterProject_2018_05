/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.qdu.service.BloodBankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 刘福港
 */
@Controller
public class LBloodBankController {
    
    @Autowired
    private BloodBankService bloodService;
    
    
    @RequestMapping(value = "/bloodBank/delectBloodRecord",method = POST)
    @ResponseBody
    public void delectBloodRecord(int recordId){
        bloodService.deleteBloodBank(recordId);
    }
    
    @RequestMapping(value = "/bloodBank/getBloodList",method = RequestMethod.GET)
    @ResponseBody
    public List getBloodList(String LbloodType){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List list=bloodService.getBloodBankByType(LbloodType);
        System.out.println("44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444");
        System.out.println(list.size());
        return list;
    }
    
    @RequestMapping(value = "/bloodBank/getDonor",method = RequestMethod.GET)
    public String getDonor(int recordId,Model model){
        model.addAttribute("donor", bloodService.getDonor(recordId));
        return "donorDetail";
    }
}
