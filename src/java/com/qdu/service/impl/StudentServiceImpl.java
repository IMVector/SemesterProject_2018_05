
//package com.qdu.service.impl;
//
//import com.qdu.dao.StudentDao;
//import com.qdu.pojo.Student;
//import com.qdu.service.StudentService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentServiceImpl implements StudentService{
//
//    @Autowired
//    private StudentDao studentDao;
//    
//    @Override
//    public Student validateStudent(String stuId, String stuPwd) {
//        
//        Student s=studentDao.getStudentById(stuId);
//        if(null!=s&&s.getStuPassword().equals(stuPwd))
//            return s;
//        else
//            return null;
//    }
//
//    @Override
//    public void addStudent(Student newStudent) {
//        studentDao.insert(newStudent);
//    }
//    @Override
//    public void updateStudent(Student updatedStudent) {
//        studentDao.update(updatedStudent);
//    }
//    @Override
//    public void deleteStudent(String stuId) {
//        studentDao.delete(stuId);
//    }
//    @Override
//    public List<Student> getStudentList() {
//        return studentDao.getStudentList();
//    }
//    
//}
