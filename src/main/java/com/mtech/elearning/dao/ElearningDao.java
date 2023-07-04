package com.mtech.elearning.dao;

import com.mtech.elearning.entity.*;

import java.util.List;

public interface ElearningDao {


    List<Instructor> findAllInstructors();
    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int theId);

    void save(Instructor instructor);

    void update(Instructor tempInstructor);

    void deleteInstructor(Instructor instructor);


    List<Course> findAllCourses();
    Course findCourseById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    void save(Course theCourse);

    void update(Course tempCourse);

    void deleteCourse(Course course);


    List<InstructorDetail> findAllInstructorDetails();

    InstructorDetail findInstructorDetailById(int theId);

    void save(InstructorDetail instructorDetail);

    void update(InstructorDetail instructorDetail);

    void deleteInstructorDetail(InstructorDetail instructorDetail);


    Student findStudentById(int id);

    void save(Student student);

    void update(Student student);

    void deleteStudent(Student student);

    Review findReviewById(int id);

    void save(Review review);

    void update(Review review);

    void deleteReview(Review review);


    Course findCourseAndReviewsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);


}
