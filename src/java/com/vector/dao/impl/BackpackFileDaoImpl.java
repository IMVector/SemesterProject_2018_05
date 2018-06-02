/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.dao.impl;

import com.vector.dao.BackpackFileDao;
import com.vector.pojo.BackpackFile;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vector
 */
@Repository
public class BackpackFileDaoImpl extends BaseDaoImpl<BackpackFile> implements BackpackFileDao {

    @Override
    public boolean deleteFile(String fileId) {
        boolean bool = false;
        try {
            delete(fileId);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    @Override
    public BackpackFile getFileById(Integer Id) {
        return getOneById(Id);
    }

    @Override
    public List<BackpackFile> getFileList() {
        String hql = "from BackpackFile";
        return getListByQuery(hql);
    }

}
