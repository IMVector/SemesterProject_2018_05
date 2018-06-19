/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import com.vector.pojo.Department;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface DepartmentDao extends BaseDao<Department>, AdminAbstractDao<Department> {

    List<Department> getOneByName(Serializable name);

    public List<Department> getAllList();
}
