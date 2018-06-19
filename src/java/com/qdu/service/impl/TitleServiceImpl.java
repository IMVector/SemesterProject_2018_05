/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.service.TitleService;
import com.vector.pojo.Title;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.dao.LTitleDao;

/**
 *
 * @author 刘福港
 */
//<hr class="hr15">
//                <select name="title" id="">
//                    <c:forEach items="${title}" var="t" >
//                        <option value="${t}">${t.titleName}</option>
//                    </c:forEach>
//                </select>
@Service
public class TitleServiceImpl implements TitleService{
    
    @Autowired
    private LTitleDao td;

    @Override
    @Transactional
    public List<Title> getAllTitle() {
        return td.getListByQuery("from Title");
    }

    @Override
    @Transactional
    public Title getTitle(int id) {
        return td.getOneById(id);
    }

    @Override
    @Transactional
    public Title getTitleByName(String name) {
        return td.getListByQuery("from Title where titleName=?", name).get(0);
    }
}
