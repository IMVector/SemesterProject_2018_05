/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.TitleDao;
import com.vector.pojo.Title;
import com.vector.service.HTitleService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vector
 */
@Service
public class HtitleServiceImpl implements HTitleService {

    @Autowired
    private TitleDao titleDao;

    @Transactional
    @Override
    public List<Title> getOneByName(Serializable name) {
        return titleDao.getOneByName(name);
    }

    @Transactional
    @Override
    public List<Title> getAllList(Serializable currentPage) {
        return titleDao.getListOfAllWithPagination(currentPage);
    }

    @Transactional
    @Override
    public int getListItemNumber() {
        return titleDao.getListItemNumber();
    }

    @Transactional
    @Override
    public boolean addOne(Title object) {
        return titleDao.addOne(object);
    }

    @Transactional
    @Override
    public boolean updateOne(Title object) {
        return titleDao.updateOne(object);
    }

    @Transactional
    @Override
    public boolean deleteOne(Serializable id) {
        return titleDao.deleteOneById(id);
    }

    @Transactional
    @Override
    public List<Title> getTitleList() {
        return titleDao.getTitleList();
    }

}
