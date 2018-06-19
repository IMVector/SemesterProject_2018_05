/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.ImageDao;
import com.vector.pojo.Image;
import com.vector.service.HImageService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Transactional
@Service
public class HImageSerivceImpl implements HImageService {

    @Autowired
    private ImageDao imageDao;

   
    @Override
    public List<Image> getAllList(Serializable currentPage) {
        return imageDao.getListOfAllWithPagination(currentPage);
    }

   
    @Override
    public int getListItemNumber() {
        return imageDao.getListItemNumber();
    }

   
    @Override
    public boolean addOne(Image object) {
        return imageDao.addOne(object);
    }

   
    @Override
    public boolean updateOne(Image object) {
        return imageDao.updateOne(object);
    }

   
    @Override
    public boolean deleteOne(Serializable id) {
        return imageDao.deleteOneById(id);
    }

   
    @Override
    public List<Image> getFirstPageImage() {
        return imageDao.getFirstPageImage();
    }
   
    @Override
    public Image getImageById(Serializable id) {
        return imageDao.getOneById(id);
    }

    @Override
    public Image getImageByPath(Serializable path) {
        return imageDao.getImageByPath(path);
    }

}
