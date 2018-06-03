/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface AdminAbstractDao<T> {

    List<T> getListOfAllWithPagination(Serializable currentPage);
    
    int getListItemNumber();

    boolean addOne(T object);

    boolean updateOne(T object);

    boolean deleteOneById(Serializable id);
}
