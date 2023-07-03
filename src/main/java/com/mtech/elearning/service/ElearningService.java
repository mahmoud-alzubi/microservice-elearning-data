package com.mtech.elearning.service;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.Student;

import java.util.List;

public interface ElearningService {
    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void update(int id, Instructor tempInstructor);

    void deleteInstructorById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Course findCourseById(int theId);

    void save(Course theCourse);

    void update(int id, Course tempCourse);

    void deleteCourseById(int theId);


    Student findStudentById(int id);

    void save(Student student);

    void update(int id, Student student);

    void deleteStudentById(int id);

    Course findCourseAndReviewsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

}
