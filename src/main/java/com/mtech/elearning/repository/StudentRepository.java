package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Student;

public interface StudentRepository {

    Student findStudentById(int id);

    void save(Student student);

    void update(Student student);

    void deleteStudent(Student student);

    Student findStudentAndCoursesByStudentId(int theId);


}
