/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.ImageDao;
import com.vector.pojo.Image;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class ImageDaoImpl extends BaseDaoImpl<Image> implements ImageDao {

    @Override
    public List<Image> getListOfAllWithPagination(Serializable currentPage) {
        String hql = "from Image";
        return getListPaginationByQuery(hql, currentPage);
    }

    @Override
    public boolean addOne(Image object) {
        boolean flag = false;
        try {
            insert(object);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateOne(Image object) {
        boolean flag = false;
        try {
            update(object);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteOneById(Serializable id) {
        boolean flag = false;
        try {
            delete(id);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public int getListItemNumber() {
        String hql="select count(*) from Image";
        return getListSize(hql);
    }

}
