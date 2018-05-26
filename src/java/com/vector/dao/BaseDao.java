
package com.vector.dao;

//定义 所有Dao的通用操作

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> { 
    
    void insert(T t);
    void update(T t);
    void delete(Serializable id);
    T getOneById(Serializable id);
    List<T> getListByQuery(String hql,Object... params); //可变参数
    
}
