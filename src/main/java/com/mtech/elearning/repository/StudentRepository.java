package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student findStudentById(int id);

    void save(Student student);

    void update(Student student);

    void deleteStudent(Student student);

    Student findStudentAndCoursesByStudentId(int theId);


}
