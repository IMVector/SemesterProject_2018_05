
package com.vector.dao.impl;


import com.vector.dao.BaseDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clazz;
    public BaseDaoImpl(){
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
        T t=getOneById(id);
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
