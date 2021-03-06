/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.Staff;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface StaffDao extends BaseDao<Staff>, AdminAbstractDao<Staff> {

    Staff getStaffById(Serializable id);

    List<Staff> getStaffByName(Serializable name, Serializable currentPage);

    List<Staff> getStaffByTitle(Serializable title, Serializable currentPage);

    List<Staff> getStaffWithImage(Serializable number);

    Integer getStaffByNameItemNum(Serializable name);

    Integer getStaffByTitleItemNum(Serializable titleName);

    public int getStaffNumWithImage();

    public List<Staff> getStaffByDepartmentName(Serializable departmentName, Serializable currentPage);

    public int getStaffByDepartmentNameItemNum(Serializable departmentName);
}
