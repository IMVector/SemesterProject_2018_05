//
//package com.qdu.service.impl;
//
//import com.qdu.dao.CourseDao;
//import com.qdu.dao.QuestionDao;
//import com.qdu.service.ExamService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ExamServiceImpl implements ExamService{
//    
//    @Autowired
//    private CourseDao courseDao;
//    
//    @Autowired
//    private QuestionDao questionDao;
//
//    @Override
//    public List getQuestionListByCourse(String courseId) {
//        return questionDao.getQuestionListByCourseId(courseId);
//    }
//
//    @Override
//    public List getCourseList() {
//        return courseDao.getCourseList();
//    }    
//}
