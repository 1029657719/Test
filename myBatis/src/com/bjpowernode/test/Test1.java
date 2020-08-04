package com.bjpowernode.test;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.Impl.StudentServiceImpl;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.serviceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.bjpowernode.util.sqlSessionUtil;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //ss就是由反射机制创建的代理类的实例
        StudentService ss = (StudentService) serviceFactory.getService(new StudentServiceImpl());
//
//        Student stu = new Student();
//        stu.setName("11111");
//        stu.setAge(23214723);
//        stu.setId("17334");
//        System.out.println(stu);
//        ss.insertStudent(stu);
//        Student stu2 = null;
//        stu2 = ss.getById("5");
//        System.out.println(stu2);
        List<Student> studentList = ss.getAll();
        for (Student stu1: studentList) {
            System.out.println(stu1);
        }
    }
}







//        String resource = "mybatis-config.xml";
//        InputStream inputStream  = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSession.openSession();
//        List<Student> studentList= session.selectList("com.bjpowernode.domain.Student.selectStudents");
//        for (Student stu:studentList) {
//            System.out.println(stu);
//        }
//        session.close();


//        String resource = "mybatis-config.xml";
//        InputStream inputStream  = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSession.openSession();
//        Student stu = new Student();
//        stu.setName("nannan");
//        stu.setAge(21);
//        stu.setId("5");
//        int num= session.insert("com.bjpowernode.domain.Student.insertStudent",stu);
//        if ( num == 11){
//            System.out.println("插入成功");
//        }
//        session.commit();
//        session.close();

//        String resource = "mybatis-config.xml";
//        InputStream inputStream  = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSession.openSession();
//        Student stu = new Student();
//        stu.setName("xiaokeai");
//        stu.setAge(18);
//        stu.setId("15");
//        int num= session.update("com.bjpowernode.domain.Student.insertStudent",stu);
//        if ( num == 11){
//            System.out.println("插入成功");
//        }
//        session.commit();
//        session.close();
