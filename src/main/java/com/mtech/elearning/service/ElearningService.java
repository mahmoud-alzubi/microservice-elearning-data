package com.mtech.elearning.service;

import com.mtech.elearning.entity.*;

import java.util.List;

public interface ElearningService {

    List<InstructorDetail> findAllInstructorDetails();

    InstructorDetail findInstructorDetailById(int theId);

    void save(InstructorDetail instructorDetail);

    void update(int id, InstructorDetail instructorDetail);

    void deleteInstructorDetail(int id);


    List<Instructor> findAllInstructors();

    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void update(int id, Instructor tempInstructor);

    void deleteInstructorById(int theId);

    List<Course> findCoursesByInstructorId(int theId);


    List<Course> findAllCourses();

    Course findCourseById(int theId);

    void save(Course theCourse);

    void update(int id, Course tempCourse);

    void deleteCourseById(int theId);


    Student findStudentById(int id);

    void save(Student student);

    void update(int id, Student student);

    void deleteStudentById(int id);


    Review findReviewById(int id);

    void save(Review review);

    void update(int id, Review review);

    void deleteReview(int id);


    Course findCourseAndReviewsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

}
