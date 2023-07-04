package com.mtech.elearning.repository;

import com.mtech.elearning.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAllCourses();

    Course findCourseById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Course findCourseAndReviewsByCourseId(int theId);

    void save(Course theCourse);

    void update(Course tempCourse);

    void deleteCourse(Course course);
}
