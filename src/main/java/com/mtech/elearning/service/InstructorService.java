package com.mtech.elearning.service;

import com.mtech.elearning.entity.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAllInstructors();

    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void update(int id, Instructor tempInstructor);

    void deleteInstructorById(int theId);

}
