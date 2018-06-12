/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 *
 * @author Vector
 */
public class UploadUtils {

    public static String uploadImage(HttpServletRequest request) throws IOException {
        String showPath = "";
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
                // 获得后缀名 
                String oriFileName = mf.getOriginalFilename();
                String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
                // 上传图片到本地 
                String realPath = req.getServletContext().getRealPath("") + "resources\\image\\" + fileName + suffix;
                mf.transferTo(new File(realPath));

                showPath = "resources\\image\\" + fileName + suffix;
            }
        }
        return showPath;
    }
}