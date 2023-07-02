package com.mtech.elearning.dao;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;

import java.util.List;

public interface ElearningDao {

    void save(Instructor instructor);

    void save(Course theCourse);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    void remove(int id);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int theId);

//    void deleteInstructorById(int theId);

    void deleteInstructor(Instructor instructor);

    List<Course> findCoursesByInstructorId(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    Course findCourseAndReviewsByCourseId(int theId);


}
