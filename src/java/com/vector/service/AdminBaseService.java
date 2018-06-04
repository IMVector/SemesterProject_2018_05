/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vector
 */
public interface AdminBaseService<T> {

    List<T> getAllList(Serializable currentPage);

    int getListItemNumber();

    boolean addOne(T object);

    boolean updateOne(T object);

    boolean deleteOne(Serializable id);

}
