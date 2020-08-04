package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//这个接口是与Mapping连接的接口，由StudentDaoImpl去具体实现
public interface StudentDao {
     List<Student> getAll();
     int A = 200;
    public Student selectStudents(String id);

    public void insertStudent(Student stu);

    
}
