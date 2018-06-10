/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public void uploadPic(HttpServletRequest request, PrintWriter out, String lastRealPath) throws IOException {
        // 将当前上下文初始化给CommonsMultipartResolver 
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form中是否有enctype＝"multipart／form－data" 
        if (resolver.isMultipart(request)) {
            // 强制转化request 
            MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
            // 从表单获取input名称 
            Iterator<String> iterable = req.getFileNames();
            // 存在文件
            if (iterable.hasNext()) {
                String inputName = iterable.next();
                // 获得文件 
                MultipartFile mf = req.getFile(inputName);
                byte[] mfs = mf.getBytes();
                // 定义文件名 
                String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                Random random = new Random();
                for (int i = 0; i < 3; i++) {
                    fileName = fileName + random.nextInt(10);
                }
                // 获得后缀名 
                String oriFileName = mf.getOriginalFilename();
                String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
                // 上传图片到本地 
                String localPath = "/Users/ZR/Desktop/webPro/console/src/main/webapp/image/" + fileName + suffix;
                mf.transferTo(new File(localPath));
                // 获取图片的宽高 
                BufferedImage bufferedImage = ImageIO.read(new FileInputStream(new File(localPath)));
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                // 获取文件大小
                long size = mf.getSize();
            }
        }
    }

}
