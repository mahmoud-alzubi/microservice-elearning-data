package com.mtech.elearning.service;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.entity.Instructor;

import java.util.List;

public interface ElearningService {
    Instructor findInstructorById(int id);
    void save(Instructor instructor);
    void update(int id, Instructor tempInstructor);
    void deleteInstructorById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
//    Course findCourseById(int theId);

//    void save(Course theCourse);
//    void update(Course tempCourse);
//    void deleteCourseById(int theId);
//

}
