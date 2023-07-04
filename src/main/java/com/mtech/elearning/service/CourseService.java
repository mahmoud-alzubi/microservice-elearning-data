package com.mtech.elearning.service;

import com.mtech.elearning.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();

    Course findCourseById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Course findCourseAndReviewsByCourseId(int theId);

    void save(Course theCourse);

    void update(int id, Course tempCourse);

    void deleteCourseById(int theId);

}
