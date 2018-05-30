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
public interface AbstractDao<T> extends BaseDao<T>{

    List<T> getListById(Serializable id, Serializable currentPage);

    List<T> getList(Serializable currentPage);

    T getOneOfSomeoneById(Serializable id);

    int getItemNum();

    int getItemNum(Serializable id);

}
