package com.mtech.elearning.service;

import com.mtech.elearning.entity.Course;
import com.mtech.elearning.repository.CourseRepositoryImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final CourseRepositoryImpl repository;

    //////////////////////////////////////////////////

    /**
     * Class Constructor
     *
     * @param repository
     */
    @Autowired
    public CourseServiceImpl(CourseRepositoryImpl repository) {
        this.repository = repository;
    }


    //////////////////////////////////////////////////

    /**
     * To Find All Courses
     *
     * @return
     */
    @Override
    public List<Course> findAllCourses() {
        try {
            logger.info("findAllCourses()");
            List<Course> courseList = repository.findAllCourses();
            return courseList;
        } finally {
            logger.info("/findAllCourses()");
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Specific Course By Given ID
     *
     * @param theId
     * @return
     */
    @Override
    public Course findCourseById(int theId) {
        try {
            logger.info("findCourseById({})", theId);
            Course course = repository.findCourseById(theId);
            return course;
        } finally {
            logger.info("/findCourseById({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find All Courses For Specific Constructor
     *
     * @param theId
     * @return
     */
    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        try {
            logger.info("findCoursesByInstructorId({})", theId);
            List<Course> courseList = repository.findCoursesByInstructorId(theId);
            return courseList;
        } finally {
            logger.info("/findCoursesByInstructorId({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Find Courses And Reviews By Given Course ID
     *
     * @param theId
     * @return
     */
    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        try {
            logger.info("findCourseAndReviewsByCourseId({})", theId);
            Course course = repository.findCourseAndReviewsByCourseId(theId);
            return course;
        } finally {
            logger.info("/findCourseAndReviewsByCourseId({})", theId);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Add New Course Record
     *
     * @param theCourse
     */
    @Transactional
    @Override
    public void save(Course theCourse) {
        try {
            logger.info("save({})", theCourse);
            repository.save(theCourse);
        } finally {
            logger.info("/save({})", theCourse);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Update Existing Course
     *
     * @param id
     * @param tempCourse
     */
    @Override
    @Transactional
    public void update(int id, Course tempCourse) {
        try {
            logger.info("update({}, {})", tempCourse);
            tempCourse.setId(id);
            repository.update(tempCourse);
        } finally {
            logger.info("/update({}, {})", tempCourse);
        }
    }

    //////////////////////////////////////////////////

    /**
     * To Remove Selected Course By ID
     *
     * @param theId
     */
    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        try {
            logger.info("deleteCourseById({})", theId);
            Course course = repository.findCourseById(theId);
            // handle course not found exception

            repository.deleteCourse(course);
        } finally {
            logger.info("/deleteCourseById({})", theId);
        }
    }


}
