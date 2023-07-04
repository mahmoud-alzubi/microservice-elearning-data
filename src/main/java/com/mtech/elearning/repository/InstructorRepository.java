package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Instructor;

import java.util.List;

public interface InstructorRepository {

    List<Instructor> findAllInstructors();

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int theId);

    void save(Instructor instructor);

    void update(Instructor tempInstructor);

    void deleteInstructor(Instructor instructor);
}
