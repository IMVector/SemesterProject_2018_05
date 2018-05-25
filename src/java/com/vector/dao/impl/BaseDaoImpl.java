
package com.vector.dao.impl;

//创建一个BaseDao接口的实现类，给出5个通用方法实现代码

import com.vector.dao.BaseDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//包含类型参数的类叫做泛型类
//实际要用的类是该类的子类或其他派生类
//也就是CourseDaoImpl和QuestionDaoImpl
//@Repository 所以该类不需要交给spring管理

public class BaseDaoImpl<T> implements BaseDao<T> {

    //定义一个变量存储T的class
    private Class<T> clazz;
    //可考虑在构造函数中获取T的class
    public BaseDaoImpl(){
        //ParameterizedType来自于java.lang.reflect
        //这两句的意思就是获取T的class
        ParameterizedType type
                =(ParameterizedType)this.getClass().getGenericSuperclass();
        clazz=(Class<T>)type.getActualTypeArguments()[0];
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void insert(T t) {
        
        sessionFactory.getCurrentSession().save(t);
    }
    
    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(Serializable id) {
        //先获取要删除的数据对象
        T t=getOneById(id);
        //delete()接收的是一个数据对象,不是主键值
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public T getOneById(Serializable id) {
        return (T)sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> getListByQuery(String hql, Object... params) {
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0;i<params.length;i++) //遍历参数数组,设置查询参数值
            query.setParameter(i, params[i]);
        return query.list(); //执行查询,返回结果列表
    }
}
