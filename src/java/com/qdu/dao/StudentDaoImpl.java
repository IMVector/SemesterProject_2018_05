
//package com.qdu.dao;
//
//import com.qdu.pojo.Student;
//import java.util.List;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository //将该类注册为一个spring管理的Dao类
//public class StudentDaoImpl implements StudentDao{
//    
//    @Autowired //自动装配,按照类型装配
//    private SessionFactory sessionFactory;
//    
//    @Override
//    public void insert(Student newStudent) {
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(newStudent);
//        session.getTransaction().commit(); //获取当前事务,提交事务
//        System.out.println("插入成功！");
//        session.close();
//    }
//
//    @Override
//    public void update(Student updatedStudent) {
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.update(updatedStudent); //saveOrUpdate()
//        session.getTransaction().commit(); //获取当前事务,提交事务
//        System.out.println("更新成功！");
//        session.close();
//    }
//
//    @Override
//    public void delete(String stuId) {
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        Student s=(Student)session.get(Student.class, stuId); //先获取学生
//        session.delete(s); //delete接受一个数据对象进行删除
//        session.getTransaction().commit(); //获取当前事务,提交事务
//        System.out.println("删除成功！");
//        session.close();
//    }
//
//    @Override
//    public Student getStudentById(String stuId) {
//        //如果使用openSession()获取会话,增删改需要使用事务,查询可不用
//        //如果使用getCurrentSession()获取会话,所有操作都需要使用事务
//        Session session=sessionFactory.openSession();
//        //load(延迟加载)和get(立刻加载)都可用于根据主键列的值加载一个数据对象
//        Student s=(Student)session.get(Student.class, stuId); // 根据主键列的值加载一个数据对象
//        session.close();
//        return s;
//    }
//    
//    @Override
//    public List<Student> getStudentList() {
//        Session session=sessionFactory.openSession();
//        Query query=session.createQuery("from Student");
//        List<Student> list=query.list(); //执行查询，获取结果集
//        session.close();
//        return list;
//    }
//}
