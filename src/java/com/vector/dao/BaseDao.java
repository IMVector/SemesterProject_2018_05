
package com.vector.dao;

//定义 所有Dao的通用操作

import java.io.Serializable;
import java.util.List;

//包含类型参数的接口叫做泛型接口
//包含类型参数的类叫做泛型类
public interface BaseDao<T> { //类型参数
    
    //插入一条新记录到数据库
    void insert(T t);
    //更新数据库中的一条记录
    void update(T t);
    //根据主键值删除数据库中的一条记录
    void delete(Serializable id);
    //根据主键值获取数据库中的一条记录
    T getOneById(Serializable id);
    //传入一个查询和查询参数获得结果列表
    List<T> getListByQuery(String hql,Object... params); //可变参数
    
}
