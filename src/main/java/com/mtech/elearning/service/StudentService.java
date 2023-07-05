package com.mtech.elearning.service;

import com.mtech.elearning.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findStudentById(int id);

    Student findStudentAndCoursesByStudentId(int theId);
    
    void save(Student student);

    void update(int id, Student student);

    void deleteStudentById(int id);

}
