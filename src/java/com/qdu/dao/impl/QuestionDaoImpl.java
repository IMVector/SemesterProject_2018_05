
//package com.qdu.dao.impl;
//
////创建一个QuestionDao的实现类-QuestionDaoImpl
//
//import com.qdu.dao.QuestionDao;
//import com.qdu.pojo.Question;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//@Repository
//public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao{
//    /**
//     * 根据课程编号获取该课程的所有题目
//     * @param courseId 课程编号
//     * @return 题目列表
//     */
//    @Override
//    public List<Question> getQuestionListByCourseId(String courseId) {
//        //因为Question类中没有courseId字段
//        //Question表是复合主键，复合主键映射到属性id
//        //id包含两个信息，courseId和questionId，所以需要通过id访问courseId
//        return getListByQuery("from Question where id.courseId=?",courseId);
//    }
//}
