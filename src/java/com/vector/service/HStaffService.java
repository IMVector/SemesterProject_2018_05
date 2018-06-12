/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Staff;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface HStaffService extends AdminBaseService<Staff> {

    Staff getOneById(Serializable id);

    List<Staff> getStaffByTitle(Serializable titleName, Serializable currentPage);

    List<Staff> getStaffByName(Serializable Name, Serializable currentPage);

    List<Staff> getStaffWithImage(Serializable number);

    Integer getStaffByNameItemNum(Serializable name);

    Integer getStaffByTitleItemNum(Serializable titleName);
}
