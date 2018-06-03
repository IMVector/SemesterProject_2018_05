/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service.impl;

import com.vector.dao.BackpackFileDao;
import com.vector.pojo.BackpackFile;
import com.vector.service.BackpackFileService;
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
public class BackpackFileServiceImpl implements BackpackFileService {

    @Autowired
    private BackpackFileDao backpackFileDao;
    @Transactional
    @Override
    public List<BackpackFile> getAllList(Serializable currentPage) {
        return backpackFileDao.getListOfAllWithPagination(currentPage);
    }
    @Transactional
    @Override
    public int getListItemNumber() {
        return backpackFileDao.getListItemNumber();
    }
    @Transactional
    @Override
    public BackpackFile getBackpackFileById(Serializable id) {
        return backpackFileDao.getOneById(id);
    }

}
