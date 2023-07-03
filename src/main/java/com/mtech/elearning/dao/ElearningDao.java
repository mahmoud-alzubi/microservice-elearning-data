package com.mtech.elearning.dao;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;
import com.mtech.elearning.entity.InstructorDetail;
import com.mtech.elearning.entity.Student;

import java.util.List;

public interface ElearningDao {

    void save(Instructor instructor);

    void save(Course theCourse);

    void save(Student student);

    void save(InstructorDetail instructorDetail);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    void update(Student student);

    void update(InstructorDetail instructorDetail);

    void remove(int id);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int theId);

    void deleteInstructor(Instructor instructor);

    List<Course> findCoursesByInstructorId(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetail(InstructorDetail instructorDetail);

    Course findCourseById(int theId);

    void deleteCourse(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    Student findStudentById(int id);

    void deleteStudent(Student student);

}
