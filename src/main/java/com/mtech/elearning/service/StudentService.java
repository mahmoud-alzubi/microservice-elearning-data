package com.mtech.elearning.service;

import com.mtech.elearning.entity.Student;

public interface StudentService {


    Student findStudentById(int id);

    Student findStudentAndCoursesByStudentId(int theId);
    
    void save(Student student);

    void update(int id, Student student);

    void deleteStudentById(int id);

}
