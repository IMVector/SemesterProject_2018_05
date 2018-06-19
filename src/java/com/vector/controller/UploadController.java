/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Image;
import com.vector.service.HImageService;
import com.vector.utils.UploadUtils;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vector
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HImageService imageService;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public boolean uploadImage(HttpServletRequest request) {
        String showPath = "";
        try {
            showPath = UploadUtils.uploadImage(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image image = new Image(0, showPath);
        return imageService.addOne(image);
    }

    @RequestMapping(value = "/uploadImage/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateImage(HttpServletRequest request, @PathVariable int id) {
        String showPath = "";
        try {
            showPath = UploadUtils.uploadImage(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image image = imageService.getImageById(id);
        image.setImagePath(showPath);
        return imageService.updateOne(image);
    }

    @RequestMapping(value = "/uploadImage/uploadPatientImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadPatientImage(HttpServletRequest request) {
        String showPath = "";
        try {
            showPath = UploadUtils.uploadImage(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image image = new Image(0, showPath);
        try {
            imageService.addOne(image);
        } catch (Exception e) {
            return "Error";
        }
        return showPath;
    }

}
