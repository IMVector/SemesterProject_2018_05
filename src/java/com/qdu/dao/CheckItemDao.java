/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.vector.pojo.CheckItem;
import java.util.List;

/**
 *
 * @author 刘福港
 */
public interface CheckItemDao extends BaseDao<CheckItem>{
    
    List<CheckItem> getCheckItemList();
}
