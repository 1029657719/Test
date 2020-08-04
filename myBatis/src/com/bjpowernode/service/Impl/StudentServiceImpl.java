package com.bjpowernode.service.Impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.sqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = sqlSessionUtil.createSession().getMapper(StudentDao.class);

    @Override
    public Student selectStudents(String id) {
        Student s = studentDao.selectStudents(id);
        return s;
    }

    @Override
    public void insertStudent(Student stu) {
        studentDao.insertStudent(stu);
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = studentDao.getAll();
        return list;
    }
}
