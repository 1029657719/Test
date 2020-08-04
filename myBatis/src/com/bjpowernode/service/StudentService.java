package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;


//这个接口呢，实际上和StudentDao作用一样，只不过在规范化流程中，
//需要由Service 去调用 Dao
public interface StudentService {
    public Student selectStudents(String id);

    public void insertStudent(Student stu);

    public List<Student> getAll();
}
