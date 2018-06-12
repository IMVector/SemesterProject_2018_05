/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import com.vector.pojo.Image;
import com.vector.service.HImageService;
import com.vector.utils.UploadUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
    public void uploadPic(HttpServletRequest request) throws IOException {

        String showPath = UploadUtils.uploadImage(request);
        Image image = new Image(0, showPath);
        imageService.addOne(image);

    }
}

//                // 获取图片的宽高 
//                BufferedImage bufferedImage = ImageIO.read(new FileInputStream(new File(realPath)));
//                int width = bufferedImage.getWidth();
//                int height = bufferedImage.getHeight();
//                // 获取文件大小
//                long size = mf.getSize();
//                System.out.println("上传");
//                String path = req.getServletContext().getContextPath();
//                System.out.println(path);
//                //C:\Users\Vector\Documents\NetBeansProjects\SemesterProject\build\web\resources\image
//                String myPath = req.getServletContext().getRealPath("")+"resources\\image";
//                System.out.println(myPath);
