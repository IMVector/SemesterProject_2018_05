/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.CheckItemDao;
import com.qdu.service.LCheckItemService;
import com.vector.pojo.CheckItem;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 刘福港
 */
@Service
public class CheckItemServiceImpl implements LCheckItemService{
    
    @Autowired
    private CheckItemDao checkDao;

    @Override
    @Transactional
    public List getCheckItemList() {
        return checkDao.getCheckItemList();
    }

    @Override
    @Transactional
    public CheckItem getCheckItemById(int itemId) {
        return checkDao.getListByQuery("from CheckItem where checkItemId=?", itemId).get(0);
    }
    
}
